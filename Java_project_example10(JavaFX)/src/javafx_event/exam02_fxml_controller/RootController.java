package javafx_event.exam02_fxml_controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable {
	/*
	 * initialize() 메소드는 컨트롤러 객체가 생성되고 나서 호출되는데, 
	 * 주로 UI 컨트롤의 초기화, 이벤트 핸들러 등록등의 코드가 작선된다.
	 */
	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML private Button btn1_1;
	
	//fx:id를 이용해서 이벤트 처리하는 방법
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//btn1 버튼의 이벤트 처리
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("버튼1 클릭");
				btnOnPrint(event);
			}
		});

		//btn2 버튼의 이벤트 처리
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("버튼2 클릭");
			}
			
		});
	}
	
	//fxml에서 이벤트 속성을 정의하고 메소드와 연결시키는 방법
	public void btnOnPrint(ActionEvent event) {
		System.out.println("버튼 1 클릭");
	}

}
