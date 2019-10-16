package javafx_container.exam03_borderpane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class RootController implements Initializable {
	@FXML
	private TextField tField;
	@FXML
	private TextArea tArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void send(ActionEvent event) {
//		StringBuffer sb = new StringBuffer();
//		sb.append(tArea.getText());
//		sb.append(tField.getText() + '\n');
//		tArea.setText(sb.toString());
//		tField.clear();
		
		tArea.appendText(tField.getText()+"\n");
		tField.clear();
	}
	
	public void keyValue(KeyEvent event) {
		
	}
}
