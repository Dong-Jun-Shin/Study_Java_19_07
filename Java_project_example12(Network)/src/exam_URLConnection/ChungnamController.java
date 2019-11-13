package exam_URLConnection;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ChungnamController implements Initializable{

	//테이블 구성을 위한 설정
	@FXML private TableView<ChungnamVO> cultureTourTableView;
	
	ObservableList<ChungnamVO> cultureTourDataList = FXCollections.observableArrayList();
	
	//서브 윈도우와 메인 윈도우를 위한 설정
	private Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

	}
	
	/**
	 * 
	 * @param event
	 */
	public void cultureTourTableView(MouseEvent event) {
		
	}
	
	/**
	 * 종료 버튼 제어 메서드.
	 * @param event
	 */
	public void btnClose(ActionEvent event) {
		Platform.exit();
	}
}
