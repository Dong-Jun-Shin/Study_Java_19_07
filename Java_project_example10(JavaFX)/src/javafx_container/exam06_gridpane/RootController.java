package javafx_container.exam06_gridpane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RootController implements Initializable {
	@FXML	private TextField userId;
	@FXML	private PasswordField userPw;
	@FXML	private Label result;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void login(ActionEvent event) {
		String inputId = this.userId.getText();
		String inputPw = this.userPw.getText();
		String dbId = "abcd1234";
		String dbPw = "123123";
		
		if(inputId.equals("") || inputPw.equals("")) {
			result.setText("Not Input of Id or Pw");
		}else if(dbId.equals(inputId) && dbPw.equals(inputPw)) {
			result.setText("Login Success");
		}else {
			result.setText("Login Failed");
		}
		
		this.userId.clear();
		this.userPw.clear();
	}

	public void cancel(ActionEvent event) {
		this.userId.clear();
		this.userPw.clear();
		result.setText("");
		Platform.exit();
//		System.exit(0);
	}
}
