package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DataUtil;
import model.SubjectDAO;
import model.SubjectVO;

public class SubjectTabController implements Initializable {
	// 학과 관리 탭
	@FXML
	private TextField txtSubjectNum;
	@FXML
	private TextField txtSubjectName;
	@FXML
	private TableView<SubjectVO> subjectTableView;

	// 학과 등록
	@FXML
	private Button btnInsert;
	// 학과 수정
	@FXML
	private Button btnUpdate;
	// 학과 삭제
	@FXML
	private Button btnDelete;

	@FXML
	private ImageView imageView;
	// 이미지파일 선택
	@FXML
	private Button btnImageChoice;
	// 이미지 파일 삭제
	@FXML
	private Button btnImageDelete;

	// 검색 단어
	@FXML
	private TextField txtSearch;
	// 검색
	@FXML
	private Button btnSearch;
	// 전체
	@FXML
	private Button btnTotalList;

	// 내가 선택한 행을 담는 필드
	private static ObservableList<SubjectVO> subjectDataList = FXCollections.observableArrayList();
	// 테이블에서 선택한 학과 정보 인덱스 저장
	private int selectedIndex;

	// 데이터베이스 작업을 위한 객체 생성. (싱글톤)
	private SubjectDAO sbdao = SubjectDAO.getInstance();

	// 주 윈도우 설정
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	//// 사진을 가져오고 셋하기 위한 필드
	private File selectedFile = null;
	// 이미지 파일명
	private String selectFileName = "";
	// 이미지 파일 경로
	private String localUrl = "";
	private Image localImage;

	// 이미지 저장할 폴더를 매개변수로 파일 객체 생성
	private File dirSave = new File("C:/JavaExeFile/images");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 학과관리 초기화
		disable(true);
		subjectTableView.setEditable(false);

		// 테이블뷰 컬럼이름 설정 및 매칭(각각 설정한 부분) - TableColumn를 fxml에서 생성.
		// <S, T> S:테이블에 들어올 자료형, T:컬럼에 들어올 행의 자료형

//		// 첫번째 방법 - 하나씩 컬럼 추가
//		TableColumn<SubjectVO, ?> colNo = subjectTableView.getColumns().get(0);
//		colNo.setCellValueFactory(new PropertyValueFactory<>("no"));
//
//		TableColumn<SubjectVO, ?> colSNum = subjectTableView.getColumns().get(1);
//		colSNum.setCellValueFactory(new PropertyValueFactory<>("s_num"));
//
//		TableColumn<SubjectVO, ?> colSName = subjectTableView.getColumns().get(2);
//		colSName.setCellValueFactory(new PropertyValueFactory<>("s_name"));
//
//		TableColumn<SubjectVO, ?> colSFile = subjectTableView.getColumns().get(3);
//		colSFile.setCellValueFactory(new PropertyValueFactory<>("filename"));

		//// 테이블뷰 컬럼이름 설정 (SubjectVO의 필드명을 얻고자 설정)
		// vo에서 가져온 필드명들
		List<String> title = DataUtil.fieldName(new SubjectVO());
		// 설정을 받을 Table의 열
		for (int i = 0; i < title.size(); i++) {
			TableColumn<SubjectVO, ?> columnName = subjectTableView.getColumns().get(i);
			// setCellValueFactory(obj) : objdp 있는 열로 테이블의 열을 설정해준다.
			// new PropertyValueFactory<>() : 값을 가질 수 있는 열로 만든다.
			columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
		}

		// 테이블에 항목 설정
		subjectTableView.setItems(subjectDataList);

		// 학과 전체 목록
		subjectTotalList(null);

		//// 학과번호 자동 부여시
		txtSubjectNum.setPromptText("");
		// 나오는 메모주석 같은 것
		Tooltip tooltip = new Tooltip("학과명을 클릭하면 자동으로 번호를 부여받을 수 있습니다.");
		tooltip.setFont(new Font(12));
		txtSubjectNum.setTooltip(tooltip);
		// 수정 불가
		txtSubjectNum.setEditable(false);

		// 마우스를 올려 두었을 때, 실행
		txtSubjectName.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (selectedIndex == 0) {
					String subjectNumber = "";
					try {
						subjectNumber = sbdao.getSubjectNum();
					} catch (Exception e) {
						e.printStackTrace();
//						System.out.println("ChangeListener<> = [" + e.getMessage() + "]");
					}
					txtSubjectNum.setText(subjectNumber);
				}
			}
		});

	}

	/**
	 * 테이블뷰 레코드 출력(학과 젠체 리스트)
	 * 
	 * @param searchWord
	 */
	public void subjectTotalList(String searchWord) {
		subjectDataList.removeAll(subjectDataList);
		SubjectVO svo = null;
		ArrayList<SubjectVO> list;

		try {
			list = sbdao.getSubjectTotalList(searchWord);
			int rowCount = list.size();

			for (int index = 0; index < rowCount; index++) {
				// 결과 리스트에서 한 행을 가져다가 svo에 대입
				svo = list.get(index);
				// 한 행을 추가
				subjectDataList.add(svo);
			}
		} catch (Exception e) {
			System.out.println("subjectTotalList() = [" + e.getMessage() + "]");
		}
	}

	/**
	 * 테이블뷰 더블클릭 선택시 텍스트필드에 내용 보여주기
	 * 
	 * @param event
	 */
	public void subjectTableView(MouseEvent event) {
		// 클릭수를 카운트해서 조건에 해당하는 경우, 실행된다.
		if (event.getClickCount() == 1) {
			// 선택한 테이블뷰의 모델을 가져오고 해당 아이템을 가져온다.
			SubjectVO svo = subjectTableView.getSelectionModel().getSelectedItem();
			if (svo != null) {
				selectedIndex = svo.getNo();
				String selectedS_num = svo.getS_num();
				String selectedS_name = svo.getS_name();

				txtSubjectNum.setText(selectedS_num);
				txtSubjectName.setText(selectedS_name);

				selectFileName = svo.getFilename();
				if (selectFileName != null) {
					localUrl = "file:/C:/JavaExeFile/images/" + selectFileName;
				} else {
					// 이미지 파일이 존재하지 않을 시, 기본 이미지로 설정
					localUrl = "/image/default.png";
				}
				localImage = new Image(localUrl);
				imageView.setImage(localImage);

				disable(false);
			}
		}
	}

	/**
	 * 학과 정보를 등록하는 이벤트 핸들러
	 * 
	 * @param event
	 */
	public void btnInsert(ActionEvent event) {
		boolean success = false;
		if (!DataUtil.validityCheck(txtSubjectName.getText(), "학과 이름을 ")) {
			return;
		} else {
			SubjectVO svo = new SubjectVO();

			svo.setS_num(txtSubjectNum.getText().trim());
			svo.setS_name(txtSubjectName.getText().trim());

			try {
				// 이미지 파일 저장
				String fileName = null;
				if (selectedFile != null) {
					if (selectFileName != null)
						imageDelete(selectFileName);
					fileName = imageSave(selectedFile);
				}
				svo.setFilename(fileName);

				success = sbdao.subjectInsert(svo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("학과 정보 입력");
			if (success == true) {
				alert.setHeaderText("학과 정보 등록 여부");
				alert.setContentText(" [ " + txtSubjectName.getText() + " ] 학과 정보가 성공적으로 등록되었습니다.");
				subjectTotalList(null);
				reset();
			} else {
				alert.setAlertType(AlertType.WARNING);
				alert.setHeaderText("학과 정보 등록 여부");
				alert.setContentText("학과 정보 등록에 문제가 있어 등록을 완료하지 못하였습니다.");
			}
			alert.showAndWait();
		}
	}

	/**
	 * 학과 정보를 수정하는 이벤트 핸들러
	 * 
	 * @param event
	 */
	public void btnUpdate(ActionEvent event) {
		boolean success = false;

		if (!DataUtil.validityCheck(txtSubjectName.getText(), "학과 이름을 ")) {
			return;
		} else {
			SubjectVO svo = new SubjectVO();
			svo.setNo(selectedIndex);
			svo.setS_name(txtSubjectName.getText().trim());

			try {
				// 이미지 파일 저장
				if (selectedFile != null) {
					// 다른 작업 후 실행시, 남아있는 정보를 지워준다.
					imageDelete(selectFileName);
					String fileName = imageSave(selectedFile);
					svo.setFilename(fileName);
				} else {
					svo.setFilename(selectFileName);
				}
				success = sbdao.subjectUpdate(svo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("학과 정보 수정");
			if (success == true) {
				alert.setHeaderText("학과 정보 수정 여부");
				alert.setContentText(" [ " + txtSubjectName.getText() + " ] 학과 정보가 성공적으로 수정되었습니다.");
				subjectTotalList(null);
				reset();
			} else {
				alert.setAlertType(AlertType.WARNING);
				alert.setHeaderText("학과 정보 수정 여부");
				alert.setContentText("학과 정보 등록에 문제가 있어 수정을 완료하지 못하였습니다.");
			}
			alert.showAndWait();
		}
	}

	/**
	 * 학과 정보를 삭제하는 이벤트 핸들러
	 * 
	 * @param event
	 */
	public void btnDelete(ActionEvent event) {
		boolean success = false;
		boolean result = false;
		try {
			// 이미지 파일 삭제
			if (selectFileName != null) {
				result = imageDelete(selectFileName);
				if (!result) {
					throw new Exception();
				}
			}
			success = sbdao.subjectDelete(selectedIndex);
		} catch (Exception e) {
			System.out.println("btnDelete() = [ " + e + " ]");
			e.printStackTrace();
		}

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("학과 정보 삭제");
		if (success == true) {
			alert.setHeaderText("학과 정보 삭제 여부");
			alert.setContentText(" [ " + txtSubjectName.getText() + " ] 학과 정보가 성공적으로 삭제하였습니다..");
			subjectTotalList(null);
			reset();
			disable(true);
		} else {
			alert.setAlertType(AlertType.WARNING);
			alert.setHeaderText("학과 정보 삭제 여부");
			alert.setContentText("학과 정보 삭제에 문제가 있어 삭제를 완료하지 못하였습니다.");
		}
		alert.showAndWait();
	}

	/**
	 * 삭제 여부를 확인하는 modal을 띄우는 메서드
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void deleteConfirm(ActionEvent event) throws Exception {
		// 보여지는 창 정의
		// getSource(), event를 생성한 객체를 반환 (이벤트 객체를 생성한 객체(Button 등등)을 가져옴)
		Object btn = event.getSource();
		// StageStyle.UTILITY : 배경이 흰색이고, 제목줄에 타이틀, 종료버튼만 존재.
		Stage dialog = new Stage(StageStyle.UTILITY);
		// 모달 다이얼로그는 다이얼로그를 닫기 전까지 소유자 윈도우 사용 불가
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("삭제 여부 확인");

		Parent parent = FXMLLoader.load(getClass().getResource("/view/confirm.fxml"));
		Label txtTitle = (Label) parent.lookup("#txtTitle");
		if (btn == btnDelete) {
			// 쿼리문을 이용하여 데이터 삭제
			txtTitle.setText("학과 정보를 삭제하시겠습니까?");
		} else if (btn == btnImageDelete) {
			txtTitle.setText("이미지 정보를 삭제하시겠습니까?");
		}

		txtTitle.setStyle("-fx-font-size: 15");

		// 컨트롤러 정의
		// 확인 버튼 제어
		Button btnOk = (Button) parent.lookup("#btnOK");
		btnOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				dialog.close();
				if (btn == btnDelete) {
					// 쿼리문을 이용하여 데이터 삭제
					btnDelete(event);
					// 프로시져를 이용하여 데이터 삭제
//						btnDeleteCall(event);
				} else if (btn == btnImageDelete) {
					btnImageFileDelete(event);
				}
			}
		});

		// 취소 버튼 제어
		Button btnCancel = (Button) parent.lookup("#btnCancel");
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				dialog.close();
			}
		});

		// 메소드 실행, 정의 후, 창 띄우기
		Scene scene = new Scene(parent);
		dialog.setScene(scene);
		dialog.setResizable(false);
		dialog.show();
	}

	/**
	 * 텍스트 필드와 변수의 초기화 및 버튼 제어를 위한 메서드
	 * 
	 * @param event
	 */
	public void btnReset(ActionEvent event) {
		reset();
		disable(true);
	}

	/**
	 * 텍스트 필드와 변수의 초기화를 위한 메서드
	 */
	public void reset() {
		selectedIndex = 0;
		subjectTableView.getSelectionModel().select(null);

		txtSubjectNum.clear();
		txtSubjectName.clear();
		// 해당 객체를 커서를 옮겨준다.
//		txtSubjectNum.requestFocus();
		selectFileName = "";
		selectedFile = null;

		if (selectedIndex == 0) {
			// 기본 이미지
			localUrl = "/image/default.png";
			localImage = new Image(localUrl);
			imageView.setImage(localImage);
		}
	}

	/**
	 * 버튼 활성화를 위한 메서드
	 * 
	 * @param idDisable 매개변수에 따라 활성화 여부 결정
	 */
	public void disable(boolean idDisable) {
		btnInsert.setDisable(!idDisable);
		btnUpdate.setDisable(idDisable);
		btnDelete.setDisable(idDisable);
	}

	/**
	 * 이미지 선택 버튼의 작동, 이미지 열기 기능의 메서드
	 * 
	 * @param event
	 */
	public void btnImageFileAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif"));

		File defaultDirectory = new File("C:/");
		fileChooser.setInitialDirectory(defaultDirectory);

		try {
			selectedFile = fileChooser.showOpenDialog(primaryStage);
			if (selectedFile != null) {
				// 이미지 파일 경로
				localUrl = selectedFile.toURI().toString();

				localImage = new Image(localUrl);
				imageView.setImage(localImage);
			}
		} catch (Exception e) { /* MalformedURLException */
			System.out.println("btnImageFileAction()= [ " + e + " ]");
		}
	}

	/**
	 * 이미지 저장 메서드
	 * 
	 * @param file 읽어올 파일 객체
	 * @return 업로드된 파일명 리턴
	 */
	private String imageSave(File file) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		int data = -1;
		String fileName = null;

		try {
			// 폴더 지정
			File dirMake = new File(dirSave.getAbsolutePath());

			// 폴더가 없을 시, 이미지 저장 폴더 생성
			if (!dirMake.exists()) {
				dirMake.mkdirs();
			}

			// 이미지 파일명 생성
			fileName = "subject" + System.currentTimeMillis() + "_" + file.getName();

			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(new FileOutputStream(dirSave.getAbsolutePath() + "\\" + fileName));

			// 선택한 이미지 파일 InputStream의 마지막에 이르렀을 경우는 -1
			while ((data = bis.read()) != -1) {
				bos.write(data);
				bos.flush();
			}
		} catch (Exception e) {
			System.out.println("imageSave()= [ " + e + " ]");
		} finally {
			try {
				if (bos != null)
					bos.close();
				if (bis != null)
					bis.close();
			} catch (IOException e) {
				System.out.println("imageSaveClose()= [ " + e + " ]");
			}
		}

		return fileName;
	}

	/**
	 * 특정 행의 이미지 파일을 삭제하는 메서드
	 * 
	 * @param event
	 */
	public void btnImageFileDelete(ActionEvent event) {
		boolean success = false;
		boolean result = false;

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("이미지 정보 삭제");
		alert.setHeaderText("이미지 정보 삭제 여부");

		try {
			// 전달을 위한 객체 생성
			SubjectVO svo = new SubjectVO();
			svo.setNo(selectedIndex);

			// 이미지 파일이 있는지 확인
			if (selectFileName == null) {
				alert.setAlertType(AlertType.ERROR);
				alert.setContentText("삭제할 이미지가 없습니다.");
				alert.showAndWait();
				return;
			}

			// 이미지 삭제
			result = imageDelete(selectFileName);

			if (!result) {
				throw new Exception();
			}

			// 쿼리문 실행을 위한 svo를 생성
			svo.setS_num(txtSubjectNum.getText());
			svo.setS_name(txtSubjectName.getText());
			// 빈문자열("")로 null을 설정
			svo.setFilename("");
			success = sbdao.subjectUpdate(svo);

			// 성공 여부를 알림창으로 보여준다.
			if (success == true) {
				alert.setContentText(" [ " + txtSubjectName.getText() + " ] 이미지 정보가 성공적으로 삭제하였습니다..");
				imageView.setImage(new Image("/image/default.png"));
				subjectTotalList(null);
				reset();
				disable(true);
			} else {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("이미지 정보 삭제에 문제가 있어 삭제를 완료하지 못하였습니다.");
			}
			alert.showAndWait();
		} catch (Exception e) {
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText("이미지 삭제 중 문제가 발생하여 삭제하지 못하였습니다.");
			alert.showAndWait();
			System.out.println("btnImageFileDelete()= [ " + e + " ]");
		}
	}

	/**
	 * 이미지 파일을 삭제하는 메서드
	 * 
	 * @param fileName 삭제할 경로+파일명을 담은 파일객체
	 * @return 성공여부 반환
	 */
	private boolean imageDelete(String fileName) {
		boolean result = false;
		try {
			// 삭제 이미지 파일
			// getAbsolutePath() : 절대경로 표시
			File fileDelete = new File(dirSave.getAbsolutePath() + "//" + fileName);

			// isDirecctory() : 경로 객체를 확인
			// isFile() : 파일명 객체를 확인
			// exists() : 해당 객체(파일 || 폴더)이 존재하는지 여부를 반환
			if (fileDelete.exists() && fileDelete.isFile()) {
				result = fileDelete.delete();
			}
		} catch (Exception ie) {
			System.out.println("imageDelete() = [ " + ie.getMessage() + "]");
			ie.printStackTrace();
			result = false;
		}
		return result;

	}

	/**
	 * 전체 검색, 부분 검색을 하는 메서드
	 * 
	 * @param event
	 */
	public void btnSearchAction(ActionEvent event) {
		// 검색버튼 클릭시
		if (event.getSource() == btnSearch) {
			if (!DataUtil.validityCheck(txtSearch.getText(), "검색할 대상의 학과명을 ")) {
				return;
			} else {
				subjectTotalList(txtSearch.getText());
			}
			// 전체버튼 클릭시
		} else if (event.getSource() == btnTotalList) {
			txtSearch.clear();
			subjectTotalList(null);

		}
	}
}
