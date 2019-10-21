package javafx_control.exam03_view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class TableController implements Initializable {
	@FXML
	private TableView<PersonVO> addressTable; //TabelView<모델클래스>
	@FXML
	private TextField addFirstName;
	@FXML
	private TextField addLastName;
	@FXML
	private TextField addEmail;

	private ObservableList<PersonVO> personList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		personList = FXCollections.observableArrayList(
				new PersonVO("Jacob", "Smith", "jacob.smith@example.com"),
				new PersonVO("Isabella", "Johnson", "isabella.johnson@example.com"),
				new PersonVO("Ethan", "Williams", "ethan.williams@example.com"),
				new PersonVO("Emma", "Jones", "emma.jones@example.com"),
				new PersonVO("Michael", "Brown", "michael.brown@example.com")
				);
		//TableColumn<S, T> : S - TableView 제네릭 형식의 형식.
		//					  T - TableColumn의 모든 셀에 있는 내용의 유형.
		//addressTable.getColumns().get(0) : 0번째 열의 주소값 반환
		TableColumn<PersonVO, ?> toFirstName = addressTable.getColumns().get(0);
		toFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//		toFirstName.setStyle("-fx-alignment: CENTER;"); //style.css에 직접 정의
		
		TableColumn<PersonVO, ?> toLastName = addressTable.getColumns().get(1);
		toLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
//		toLastName.setStyle("-fx-alignment: CENTER;"); //style.css에 직접 정의
		
		TableColumn<PersonVO, ?> toEmail = addressTable.getColumns().get(2);
		toEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
//		toEmail.setStyle("-fx-alignment: CENTER;"); //style.css에 직접 정의
		
		addressTable.setItems(personList);
	}

	public void recodeChoice(MouseEvent e) {
		ObservableList<PersonVO> selectPerson = addressTable.getSelectionModel().getSelectedItems();
		if(selectPerson!=null) {
			PersonVO person = addressTable.getSelectionModel().getSelectedItem();
			addFirstName.setText(person.getFirstName());
			addLastName.setText(person.getLastName());
			addEmail.setText(person.getEmail());
		}
	}

	public void addRow(ActionEvent e) {
		personList.add(new PersonVO(addFirstName.getText(), addLastName.getText(), addEmail.getText()));
		reset();
	}

	public void reset() {
//		addFirstName.setText("");
//		addLastName.setText("");
//		addEmail.setText("");
		
		addFirstName.clear();
		addLastName.clear();
		addEmail.clear();
	}
}
