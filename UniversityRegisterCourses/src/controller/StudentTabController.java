package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DataUtil;
import model.StudentDAO;
import model.StudentVO;
import model.SubjectVO;

public class StudentTabController implements Initializable {
	//// 정보 입력 필드
	/// 학과명 받기
//	// 1번째 콤보박스로 보여주기
//	@FXML
//	private ComboBox<SubjectVO> cbxSubjectName;
	// 2번째 검색으로 찾기
	@FXML
	private TextField txtSubjectName;
	@FXML
	private Button btnNameSearch;
	/// 나머지 정보 받기
	@FXML
	private TextField txtStudentNum;
	@FXML
	private TextField txtStudentName;
	@FXML
	private TextField txtStudentId;
	@FXML
	private Button btnIdCheck;
	@FXML
	private PasswordField pwStudentPasswd;
	@FXML
	private TextField txtStudentBirth;
	@FXML
	private TextField txtStudentPhone;
	@FXML
	private TextField txtStudentAddress;
	@FXML
	private TextField txtStudentEmail;
	@FXML
	private Button btnEmail;

	//// 정보 관리 필드
	@FXML
	private Button btnStudentInsert;
	@FXML
	private Button btnStudentUpdate;
	@FXML
	private Button btnStudentDelete;

	//// 정보 검색 필드
	@FXML
	private ToggleGroup groupSearch;
	@FXML
	private TextField txtSearch;
	@FXML
	private DatePicker dpDate;
	@FXML
	private Button btnSearch;
	@FXML
	private Button btnTotalList;

	//// 테이블 필드
	@FXML
	private TableView<StudentVO> studentTableViewUp;
	@FXML
	private TableView<StudentVO> studentTableViewDown;
	ObservableList<StudentVO> studentDataUpList = FXCollections.observableArrayList();
	ObservableList<StudentVO> studentDataDownList = FXCollections.observableArrayList();

	// 테이블에서 선택한 행의 인덱스, 학번, 학과코드
	int selectedStudentIndex; // 학생등록 탭에서 선택한 학과 정보 인덱스 저장
	String studentNumber = "";
	private String selectSubjectNum; // 선택한 학과명의 학과코드

	// Modal을 위한 설정
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	// 데이터베이스 작업을 위한 객체 생성
//	private SubjectDAO sbdao = SubjectDAO.getInstance();
	private StudentDAO stdao = StudentDAO.getInstance();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// 학생등록 초기화
		// disable(true);

		// 테이블뷰 수정 금지
		studentTableViewUp.setEditable(false);
		studentTableViewDown.setEditable(false);
		txtStudentNum.setEditable(false);

		try {
			// 테이블뷰 컬럼이름 설정(StudentVO의 필드명을 얻어와서 설정한다.)
			List<String> title = DataUtil.fieldName(new StudentVO());

			for (int i = 0; i < title.size(); i++) {
				TableColumn<StudentVO, ?> columnName;
				if (i == 0) {
					columnName = studentTableViewUp.getColumns().get(i);
					columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i).toLowerCase()));

					columnName = studentTableViewDown.getColumns().get(i);
					columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i).toLowerCase()));
				} else if (i < 7) {
					columnName = studentTableViewUp.getColumns().get(i);
				} else {
					int num = i - 6;
					columnName = studentTableViewDown.getColumns().get(num);
				}
				columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i).toLowerCase()));
			}

			studentTableViewUp.setItems(studentDataUpList);
			studentTableViewDown.setItems(studentDataDownList);

			// TODO 아래 테이블 선택 비활성화

			// 학생 전체 목록
			studentTotalList(null);

			// 추가된 학과명 호출
//			addSubjectName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 전체 학생에 대해 값을 받아 행으로 출력
	 * 
	 * @param searchWord 검색을 위한 매개변수
	 */
	public void studentTotalList(String searchWord) {
		studentDataUpList.removeAll(studentDataUpList);
		studentDataDownList.removeAll(studentDataDownList);

		StudentVO svo = null;
		ArrayList<StudentVO> list;
		try {
			if (searchWord == null) {
				// 전체 레코드를 조회해서 출력하는 메소드
				list = stdao.getStudentTotalList();
			} else {
				// 검색
				String[] word = searchWord.split(",");
				// (대상, 단어)
				list = stdao.getStudentSearch(word[0], word[1]);
			}
			int rowCount = list.size();
			for (int index = 0; index < rowCount; index++) {
				svo = list.get(index);
				studentDataUpList.add(svo);
				studentDataDownList.add(svo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 콤보박스에 학과 정보(학과명) 출력
	 * 
	 * @throws Exception
	 */
//	public void addSubjectName() throws Exception {
//		ArrayList<SubjectVO> subjectNameList = new ArrayList<>();
//		subjectNameList = sbdao.getSubjectTotalList(null);
//		// 학생 등록 탭 학과 번호 콤보 값 설정
//		cbxSubjectName.setItems(FXCollections.observableArrayList(subjectNameList));
//	}

	/**
	 * 학생 등록 탭의 학과 선택 이벤트 핸들러
	 * 
	 * @param event
	 */
//	public void cbxSubjectNameAction(ActionEvent event) {
//		SubjectVO svo = null;
//		String serialNumber = ""; // 일련번호
//		String sdYear = "";
//
//		svo = cbxSubjectName.getSelectionModel().getSelectedItem();
//		if (svo != null) {
//			selectSubjectNum = svo.getS_num();
//
//			// 학번은 8자리로 구성한다. (연도 2자리 + 학과 2자리 + 일련번호 4자리 0 예로06010001)
//			// 년도 2자리 구하기
//			SimpleDateFormat sdf = new SimpleDateFormat("yy");
//			sdYear = sdf.format(new Date());
//
//			try {
//				// 일련번호 4자리 구하기
//				serialNumber = stdao.getStudentCount(selectSubjectNum);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			studentNumber = sdYear + selectSubjectNum + serialNumber;
//			txtStudentNum.setText(studentNumber);
//		}
//	}

	/**
	 * 과검색 버튼으로 Modal을 통해 학과명 및 학번 얻기
	 * 
	 * @param event
	 */
	public void btnSubjectNameSearch(ActionEvent event) throws Exception {
		try {
			// StageStyle로 Modal의 속성을 설정
			Stage searchDialog = new Stage(StageStyle.UTILITY);

			searchDialog.initModality(Modality.WINDOW_MODAL);
			searchDialog.initOwner(primaryStage);
			searchDialog.setTitle("학과 선택 화면");

			// 컨트롤러와 스테이지의 동작을 연결
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/subjectSub.fxml"));
			Parent parent = loader.load();
			SubjectSubController controller = loader.getController();
			controller.setDialog(searchDialog);

			// 선택버튼
			Button btnChoice = (Button) parent.lookup("#btnChoice");
			btnChoice.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					searchDialog.close();

					@SuppressWarnings("unchecked")
					TableView<SubjectVO> tView = (TableView<SubjectVO>) parent.lookup("#subjectView");
					SubjectVO svo = tView.getSelectionModel().getSelectedItem();
					txtSubjectName.setText(svo.getS_name());

					selectSubjectNum = svo.getS_num();
					// 학번은 8자리로 구성한다. (연도2자리 + 학과2자리 + 일련번호4자리 - 예로 06010001)
					// 년도 2자리 구하기
					SimpleDateFormat sdf = new SimpleDateFormat("yy");
					String sdYear = sdf.format(new Date());
					String serialNumber = "";
					try {
						// 일련번호 4자리 구하기
						serialNumber = stdao.getStudentCount(selectSubjectNum);
					} catch (Exception e) {
						e.printStackTrace();
					}
					studentNumber = sdYear + selectSubjectNum + serialNumber;
					txtStudentNum.setText(studentNumber);
				}

			});

			Scene scene = new Scene(parent);
			searchDialog.setScene(scene);
			searchDialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 학생 아이디 중복 체크 이벤트 핸들러
	 * 
	 * @param event
	 */
	public void btnIdCheck(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("아이디 중복 확인");

		try {
			String searchId = txtStudentId.getText().trim();
			if (!DataUtil.validityCheck(searchId, "아이디를 ")) {
				// 해당 객체로 커서를 활성화시킨다.
				txtStudentId.requestFocus();
				return;
			} else {
				boolean result = stdao.getStudentIdOverlap(searchId);
				if (result) {
					alert.setHeaderText("결과 : 불가능");
					alert.setContentText("이미 사용중인 아이디가 있습니다.\n다른 아이디를 사용해주세요.");
					txtStudentId.clear();
					txtStudentId.requestFocus();

				} else {
					alert.setHeaderText("결과 : 가능");
					alert.setContentText("사용 가능한 아이디입니다.");
					txtStudentId.setEditable(false);
					btnIdCheck.setDisable(true);
					btnStudentInsert.setDisable(false);
				}

				alert.showAndWait();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void btnSendAction(ActionEvent event) {

	}

	public void btnStudentInsert(ActionEvent event) {
		boolean success = false;
		if (!DataUtil.validityCheck(txtStudentName.getText(), "학생명을 "))
			return;
		else if (!DataUtil.validityCheck(txtStudentId.getText(), "아이디를 "))
			return;
		else if (!DataUtil.validityCheck(pwStudentPasswd.getText(), "비밀번호를 "))
			return;
		else if (!DataUtil.validityCheck(txtStudentBirth.getText(), "생년월일을 "))
			return;
		else if (!DataUtil.validityCheck(txtStudentPhone.getText(), "연락처를"))
			return;
		else if (txtStudentAddress.getText().equals("")) {
			DataUtil.validityCheck("", "주소를");
			return;
		} else if (!DataUtil.validityCheck(txtStudentEmail.getText(), "이메일을 "))
			return;
		else {
			StudentVO svo = new StudentVO();

			svo.setNo(10);
			svo.setSd_num(txtStudentNum.getText().trim());
			svo.setSd_name(txtStudentName.getText().trim());
			svo.setSd_id(txtStudentId.getText().trim());
			svo.setSd_passwd(pwStudentPasswd.getText().trim());
//			svo.setS_num(cbxSubjectName.getSelectionModel().getSelectedItem().getS_num());
			svo.setS_num(txtStudentNum.getText().substring(2, 4));
			svo.setS_num(selectSubjectNum);

			String sd_b = txtStudentBirth.getText().trim();
			StringBuffer sb = new StringBuffer();
			sb.append(sd_b.substring(0, 4));
			sb.append("-");
			sb.append(sd_b.substring(4, 6));
			sb.append("-");
			sb.append(sd_b.substring(6, 8));
			svo.setSd_birth(sb.toString());

			svo.setSd_phone(txtStudentPhone.getText().trim());
			svo.setSd_address(txtStudentAddress.getText().trim());
			svo.setSd_email(txtStudentEmail.getText().trim());

			try {
				success = stdao.studentInsert(svo);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("학생 정보 입력");
			if (success == true) {
				alert.setHeaderText("학생 정보 등록 여부");
				alert.setContentText(" [ " + txtStudentName.getText() + " ] 학생 정보가 성공적으로 등록되었습니다.");
				studentTotalList(null);
//				reset();
			} else {
				alert.setAlertType(AlertType.WARNING);
				alert.setHeaderText("학생 정보 등록 여부");
				alert.setContentText("학생 정보 등록에 문제가 있어 등록을 완료하지 못하였습니다.");
			}
			alert.showAndWait();

			btnStudentInit(event);
		}
	}

	
	public void btnStudentUpdate(ActionEvent event) {
		boolean success = false;

		try {
			if (!DataUtil.validityCheck(txtSubjectName.getText(), "학생 이름을 ")) {
				return;
			} else {
				StudentVO svo = new StudentVO();

				svo.setNo(selectedStudentIndex);
				svo.setSd_passwd(pwStudentPasswd.getText().trim());
				
				String sd_b = txtStudentBirth.getText().trim();
				StringBuffer sb = new StringBuffer();
				sb.append(sd_b.substring(0, 4));
				sb.append("-");
				sb.append(sd_b.substring(4, 6));
				sb.append("-");
				sb.append(sd_b.substring(6, 8));
				svo.setSd_birth(sb.toString());
//				svo.setSd_birth(txtStudentBirth.getText().trim());
				
				svo.setSd_phone(txtStudentPhone.getText().trim());
				svo.setSd_address(txtStudentAddress.getText().trim());
				svo.setSd_email(txtStudentEmail.getText().trim());

				success = stdao.studentUpdate(svo);

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("학생 정보 수정");
				if (success == true) {
					alert.setHeaderText("학생 정보 수정 여부");
					alert.setContentText(" [ " + txtSubjectName.getText() + " ] 학생 정보가 성공적으로 수정되었습니다.");
					studentTotalList(null);
					reset();
				} else {
					alert.setAlertType(AlertType.WARNING);
					alert.setHeaderText("학생 정보 수정 여부");
					alert.setContentText("학생 정보 등록에 문제가 있어 수정을 완료하지 못하였습니다.");
				}
				alert.showAndWait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteConfirm(ActionEvent event) {

	}

	/**
	 * 필드를 초기화하는 버튼 메서드
	 * 
	 * @param event
	 */
	public void btnStudentInit(ActionEvent event) {
		reset();
		editable(true);
		disable(true);
	}

	/**
	 * 필드를 초기화하는 메서드
	 */
	private void reset() {
		// 콤보박스를 이용하는 방식일 때, 사용
//		cbxSubjectName.getSelectionModel().clearSelection();
		// 검색창을 이용하는 방식일 때, 사용
		txtSubjectName.clear();

		txtStudentNum.clear();
		txtStudentName.clear();
		txtStudentId.clear();
		pwStudentPasswd.clear();
		selectSubjectNum = "";
		txtStudentBirth.clear();
		txtStudentPhone.clear();
		txtStudentAddress.clear();
		txtStudentEmail.clear();
		studentTableViewUp.getSelectionModel().select(null);
		txtSearch.clear();
//		dpDate.
	}

	public void searchView(ActionEvent event) {

	}

	public void btnSearchAction(ActionEvent event) {

	}

	public void btnPieChartAction(ActionEvent event) {

	}

	public void btnBarChartAction(ActionEvent event) {

	}

	/**
	 * 학생 테이블 뷰 더블 클릭 이벤트 핸들러
	 * 
	 * @param event
	 */
	public void studentTableView(MouseEvent event) {
		// 한 번 클릭시 아래 테이블의 커서도 같은 위치를 표시
		if (event.getClickCount() == 1) {
			StudentVO selectStudent = studentTableViewUp.getSelectionModel().getSelectedItem();
			// TODO 아래 테이블 다루기
			if (selectStudent != null) {
				selectedStudentIndex = selectStudent.getNo();
//				studentTableViewDown.requestFocus();
//				studentTableViewDown.getFocusModel().focus(selectedStudentIndex-1);
				studentTableViewDown.getSelectionModel().select(selectedStudentIndex - 1);
			}
		}

		if (event.getClickCount() == 2) {
			StudentVO selectStudent = studentTableViewUp.getSelectionModel().getSelectedItem();
			// TODO 아래 테이블 다루기
			if (selectStudent != null) {
				selectedStudentIndex = selectStudent.getNo();

				txtSubjectName.setText(selectStudent.getS_num());
				txtStudentNum.setText(selectStudent.getSd_num());
				txtStudentName.setText(selectStudent.getSd_name());
				txtStudentId.setText(selectStudent.getSd_id());
				pwStudentPasswd.setText(selectStudent.getSd_passwd());
				txtStudentBirth.setText(selectStudent.getSd_birth().replace("-", ""));
				txtStudentPhone.setText(selectStudent.getSd_phone());
				txtStudentAddress.setText(selectStudent.getSd_address());
				txtStudentEmail.setText(selectStudent.getSd_email());

				editable(false);
				disable(false);
			}
		}
	}

	/**
	 * 필드들 제어
	 * 
	 * @param idDisable
	 */
	public void editable(boolean idDisable) {
		studentTableViewUp.setEditable(false);
		studentTableViewDown.setEditable(false);
//		studentTableViewDown.;

		txtSubjectName.setEditable(false);
		txtStudentNum.setEditable(false);

		txtStudentName.setEditable(idDisable);
		txtStudentId.setEditable(idDisable);
	}

	/**
	 * 버튼 제어
	 * 
	 * @param idDisable true이면 수정 활성화, false이면 입력 활성화
	 */
	public void disable(boolean idDisable) {
		btnIdCheck.setDisable(!idDisable); // 비활
		if (selectedStudentIndex != 0)
			// 비활
			btnStudentInsert.setDisable(true);
		else
			// 활성화
			btnStudentInsert.setDisable(!btnIdCheck.isDisable());

		btnEmail.setDisable(idDisable); // 활성화
		btnStudentUpdate.setDisable(idDisable); // 활성화
		btnStudentDelete.setDisable(idDisable); // 활성화
	}
}
