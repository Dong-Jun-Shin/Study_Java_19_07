package javafx_control.exam02_input;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RootController implements Initializable {
	@FXML
	private TextField txtTitle;
	@FXML
	private TextField txtPassword;
	@FXML
	private Label result;
	@FXML
	private ComboBox<String> comboPublic;
	@FXML
	private DatePicker dateStart;
	@FXML
	private DatePicker dateExit;
	@FXML
	private TextArea txtContent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// dateExit.setShowWeekNumbers(true); //매주 번호 표시 여부
		dateStart.setValue(LocalDate.now());
	}

	public void btnDateAction(ActionEvent e) {

	}
	
	public void btnRegAction(ActionEvent e) {
		boolean bool = true;
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("수정 요청");
		System.out.println("/ "+ txtTitle.getText() + " /");
		
		//TODO 상황에 따른 경고창 출력하도록 만들기
		if (txtTitle.getText() == "") {
			alert.setContentText("제목을 입력해주세요.");
			bool = false;
		}
		if (txtPassword.getText() == "") {
			alert.setContentText("비밀번호를 입력해주세요.");
			bool = false;
		}
		if (comboPublic.getValue() == null) {
			alert.setContentText("공개 여부를 선택해주세요.");
			bool = false;
		}
		if (dateExit.getValue() == null) {
			alert.setContentText("날짜를 선택해주세요.");
			bool = false;
		}
		if (txtContent.getText() == "") {
			alert.setContentText("내용을 입력해주세요.");
			bool = false;
		}

		if (bool) {
			StringBuffer data = new StringBuffer();
			data.append("title: " + txtTitle.getText() + "\n");
			data.append("password: " + txtPassword.getText() + "\n");
			data.append("public: " + comboPublic.getValue() + "\n");
			
			LocalDate localDate = dateExit.getValue();
			data.append("dateExit: " + localDate.toString() + "\n");
			data.append("content: " + txtContent.getText() + "\n");
			
			result.setText(data.toString());
			alert.setContentText("등록되었습니다.");
		}else {
			result.setText("등록 실패");
		}
		
		alert.show();
	}

	public void btnCancelAction(ActionEvent e) {
		Platform.exit();
	}

}
