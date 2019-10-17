package email.controller;

import java.net.URL;
import java.util.ResourceBundle;

import email.logic.EmailSendLogic;
import email.logic.EmailVO;
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
	@FXML
	private TextField googleId;
	@FXML
	private PasswordField googlePwd;
	@FXML
	private TextField emailTo;
	@FXML
	private TextField emailToName;
	@FXML
	private TextField emailFrom;
	@FXML
	private TextField emailFromName;
	@FXML
	private TextField emailSubject;
	@FXML
	private TextArea emailMsg;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void send(ActionEvent event) {
		EmailVO evo = new EmailVO(googleId.getText(), googlePwd.getText(), emailTo.getText(), emailToName.getText(),
				emailFrom.getText(), emailFromName.getText(), emailSubject.getText(), emailMsg.getText());

		boolean bool = true;
		evo.setGoogleId("tempJavaId");
		evo.setGooglePwd("java!234");
		String id = evo.getGoogleId();
		String pw = evo.getGooglePwd();

		String inputId = evo.getGoogleId();
		String inputPw = evo.getGooglePwd();

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("전송결과");

		if (evo.getEmailFrom().equals("") && evo.getEmailFromName().equals("")) {
			alert.setContentText("보내는 사람의 정보가 잘못되었습니다.");
			bool = false;
		}
		if (evo.getEmailTo().equals("") && evo.getEmailToName().equals("")) {
			alert.setContentText("받는 사람의 정보가 잘못되었습니다.");
			bool = false;
		}
		if (evo.getEmailSubject().equals("") && evo.getEmailMsg().equals("")) {
			alert.setContentText("보낼 내용이나 제목이 없습니다.");
			bool = false;
		}
		if (inputId.equals("") && inputPw.equals("")) {
			alert.setContentText("빈칸을 모두 채워주세요.");
			bool = false;
		}
		if (!(id.equals(inputId) && pw.equals(inputPw))) {
			alert.setContentText("로그인에 실패했습니다.");
			bool = false;
		}

		if (bool) {
			String result = (new EmailSendLogic()).send(evo);
			if (result.equals("Success")) {
				alert.setContentText("(" + result + ") " + evo.getEmailToName() + "님에게 전송 성공했습니다.");
			}else {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("(" + result + ") " + evo.getEmailToName() + "님에게 전송 실패했습니다.");
			}
		}

		alert.showAndWait();
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
