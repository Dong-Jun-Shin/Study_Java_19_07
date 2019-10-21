package javafx_control.exam03_view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ListController implements Initializable {
	@FXML
	private ListView<String> list;
	@FXML
	private Label result;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ObservableList<String> items = FXCollections.observableArrayList(
				"chocolate", "salmon", "gold",
				"coral", "darkorchid", "darkgoldenrod",
				"lightsalmon", "black", "rosybrown", 
				"blue", "blueviolet", "brown", "red");
		list.setItems(items);
	}

	public void listMouse(MouseEvent e) {
		//SelectionModel(주소)과 SelectedItem(리스트의 목록 텍스트)으로 글자를 가져온다.
		String colorName = list.getSelectionModel().getSelectedItem();
		result.setText(colorName);
		//Color 클래스의 web을 이용해서 색을 설정한다. (글자의 색)
		result.setTextFill(Color.web(colorName));
	}
}
