package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainController implements Initializable{
	//@FXML으로 외부(.fxml)에서 값을 주입받는다. -외부주입
	@FXML private TabPane mainPane;

	@FXML private Tab subject;
	// 참조변수명 부여 방법: include시 명시한 id+"Controller"
	@FXML private SubjectTabController subjectTabController;
	
	@FXML private Tab student;
	@FXML private StudentTabController studentTabController;
	
	// 메인 스테이지를 가져오기 (서브윈도우를 다루기 위함) 
	private Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	/* 컨트롤러 클래스를 초기화한다.
	 * 이 메서드는 fxml 파일이 로드된 후 자동으로 호출된다.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		subjectTabController.setPrimaryStage(primaryStage);
		studentTabController.setPrimaryStage(primaryStage);
		
		mainPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
			//Tab이 바뀔 때를 인지하는 것이기 떄문에 타입은 Tab
			//기존 값과 바뀐 값을 매개변수로 받아준다.
			@Override
			public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
				// TODO Auto-generated method stub
				if(newValue == subject) {
//					System.out.println("학과");
					
					//해당 탭의 내용을 새로고침
					try {
						subjectTabController.subjectTotalList(null);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}else if(newValue == student) {
//					System.out.println("학생");
					
					//해당 탭의 내용을 새로고침					
					try {
						studentTabController.addSubjectName();
						studentTabController.studentTotalList(null);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}
			}
			
		});
	}

	public void menuExit(ActionEvent event) {
		
	}
	
	public void menuInfo(ActionEvent event) {
		
	}
	
}
