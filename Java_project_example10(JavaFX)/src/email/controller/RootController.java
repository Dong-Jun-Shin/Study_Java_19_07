package email.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RootController implements Initializable {
	@FXML private TextField googleId;
	@FXML private PasswordField googlePwd;
	@FXML private TextField emailTo;
	@FXML private TextField emailToName;
	@FXML private TextField emailFrom;
	@FXML private TextField emailFromName;
	@FXML private TextField emailSubject;
	@FXML private TextArea emailMsg;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	//TODO 로그인 여부 확인, 텍스트 필드로 바꾸기
	public void send(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION); 
		alert.setHeaderText("전송결과");

		String inputId = googleId.getText();
		String inputPw = googlePwd.getText();
		String id = "abcd1234";
		String pw = "123123";
		
		if(inputId.equals("") && inputPw.equals("")) {
			alert.setContentText("빈칸을 모두 채워주세요.");
			
		}else if(id.equals(inputId) && pw.equals(inputPw)) {
			alert.setContentText("로그인에 실패했습니다.");
			
		}else if(emailTo.getText().equals("") && emailToName.getText().equals("")) {
			alert.setContentText("받는 사람의 정보가 잘못되었습니다.");
		}else if(emailFrom.getText().equals("") && emailFromName.getText().equals("")) {
			alert.setContentText("보내는 사람의 정보가 잘못되었습니다.");
		}else if(emailSubject.getText().equals("") && emailMsg.getText().equals("")) {
			alert.setContentText("보낼 내용이나 제목이 없습니다.");
		}else {
			alert.setContentText("전송에 성공했습니다.");
		}
		
		alert.show();
	}
	
	public void clear(ActionEvent event) {
		googleId.clear();
		googlePwd.clear();
		emailTo.clear();
		emailToName.clear();
		emailFrom.clear();
		emailFromName.clear();
		emailSubject.clear();
		emailMsg.clear();
	}
	
	public void cancel(ActionEvent event) {
		Platform.exit();
	}
	
}
