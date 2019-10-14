package javafx_layout.programmatical_layout;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		////layout 설정
		//Parent 하위 객체인 VBox(수직 객체) 생성		
		VBox root = new VBox();
		//VBox의 폭 설정
		root.setPrefWidth(350);
		//VBox의 높이 설정
		root.setPrefHeight(150);
		//컨트롤을 중앙으로 정렬
		root.setAlignment(Pos.CENTER);
		//컨트롤의 수직 간격
		root.setSpacing(20);
		
		////label
		//Label 컨트롤 생성
		Label label =new Label();
		//text 속성 설정
		label.setText("Hello, JavaFX");
		//font 속성 설정
		label.setFont(new Font(50));
		
		////Button
		//Button 컨트롤 생성
		Button button = new Button();
		//text 속성 설정(버튼 내 나타낼 문자)
		button.setText("확인");
		
		//무명 클래스( 추상클래스나 인터페이스를 정의와 함께 객체 생성해주는 것)
		button.setOnAction(new EventHandler<ActionEvent>() {
			//클릭 이벤트 처리(ActionEvent)
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		
		//VBox에 Label 컨트롤 추가
		root.getChildren().add(label);
		//VBox에 Button 컨트롤 추가
		root.getChildren().add(button);
		
		//VBox를 루트 컨테이너로 해서 Scene 생성과 셋
		Scene scene = new Scene(root);
		//윈도우의 제목 설정
		primaryStage.setTitle("가나다라");
		//윈도우에 장면 설정
		primaryStage.setScene(scene);
		//윈도우 보여주기
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
