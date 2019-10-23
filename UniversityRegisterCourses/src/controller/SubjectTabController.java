package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.stage.Stage;
import model.SubjectDAO;
import model.SubjectVO;

public class SubjectTabController implements Initializable {
	// 학과 관리 탭
	@FXML
	TextField txtSubjectNum;
	@FXML
	TextField txtSubjectName;
	@FXML
	TableView<SubjectVO> subjectTableView;

	// 학과 등록
	@FXML
	Button btnInsert;
	// 학과 수정
	@FXML
	Button btnUpdate;
	// 학과 삭제
	@FXML
	Button btnDelete;

	@FXML
	ImageView imageView;
	// 이미지파일 선택
	@FXML
	Button btnImageChoice;
	// 이미지 파일 삭제
	@FXML
	Button btnImageDelete;

	// 검색 단어
	@FXML
	Label txtSearch;
	// 검색
	@FXML
	Button btnSearch;
	// 전체
	@FXML
	Button btnTotalList;

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
//		disable(true);
//		subjectTableView.setEditable(false);

		// 테이블뷰 컬럼이름 설정 및 매칭(각각 설정한 부분) - TableColumn를 fxml에서 생성.
		// <S, T> S:테이블에 들어올 자료형, T:컬럼에 들어올 행의 자료형
		TableColumn<SubjectVO, ?> colNo = subjectTableView.getColumns().get(0);
		colNo.setCellValueFactory(new PropertyValueFactory<>("no"));

		TableColumn<SubjectVO, ?> colSNum = subjectTableView.getColumns().get(1);
		colSNum.setCellValueFactory(new PropertyValueFactory<>("s_num"));

		TableColumn<SubjectVO, ?> colSName = subjectTableView.getColumns().get(2);
		colSName.setCellValueFactory(new PropertyValueFactory<>("s_name"));

		TableColumn<SubjectVO, ?> colSFile = subjectTableView.getColumns().get(3);
		colSFile.setCellValueFactory(new PropertyValueFactory<>("filename"));

		// 테이블뷰 컬럼이름 설정 (SubjectVO의 필드명을 얻고자 설정)
//		List<String> title = DataUtil.fieldName(new SubjectVO());
//		for (int i = 0; i < title.size(); i++) {
//			TableColumn<SubjectVO, ?> columnName = subjectTableView.getColumns().get(i);
//			columnName.setCellValueFactory(new PropertyValueFactory<>(title.));
//		}

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
				String subjectNumber = "";
				try {
					subjectNumber = sbdao.getSubjectNum();
				} catch (Exception e) {
					e.printStackTrace();
				}
				txtSubjectNum.setText(subjectNumber);

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
			System.out.println("e = [" + e.getMessage() + "]");
		}
	}

	/**
	 * 학과 등록 이벤트 핸들러
	 * 
	 * @param event
	 */
	public void btnInsert(ActionEvent event) {
		boolean success = false;
//		if(!DataUtil.validityCheck(txtSubjectName.getText(), "학과 이름을 "))
//		else {
		SubjectVO svo = new SubjectVO();

		svo.setS_num(txtSubjectNum.getText().trim());
		svo.setS_name(txtSubjectName.getText().trim());

		try {
			// 이미지 파일 저장
			String fileName = imageSave(selectedFile);
			svo.setFilename(fileName);

			if (!fileName.equals("default.png")) {
				success = sbdao.subjectInsert(svo);
			}else {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("학과 정보 입력");
		if (success == true) {
			alert.setHeaderText("학과 정보 등록 여부");
			alert.setContentText(" [ " + txtSubjectName.getText() + " ] 학과 정보가 성공적으로 등록되었습니다.");
			subjectTotalList(null);
//			reset();
		} else {
			alert.setAlertType(AlertType.WARNING);
			alert.setHeaderText("학과 정보 등록 여부");
			alert.setContentText("학과 정보 등록에 문제가 있어 등록을 완료하지 못하였습니다.");
		}
		alert.showAndWait();
	}

	public void btnUpdate(ActionEvent event) {

	}

	public void deleteConfirm(ActionEvent event) {

	}

	public void btnReset(ActionEvent event) {
		txtSubjectNum.clear();
		txtSubjectName.clear();
	}

	/**
	 * 이미지 선택 버튼의 작동, 이미지 열기 기능
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
			e.printStackTrace();
		}
	}

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
				dirMake.mkdir();
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
			e.getMessage();
		} finally {
			try {
				if (bos != null)
					bos.close();
				if (bis != null)
					bis.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}

		return fileName;
	}

	public void btnSearchAction(ActionEvent event) {

	}

	public void subjectTableView(MouseEvent event) {

	}
}
