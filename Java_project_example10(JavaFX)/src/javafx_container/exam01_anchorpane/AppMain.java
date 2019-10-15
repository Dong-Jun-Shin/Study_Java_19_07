package javafx_container.exam01_anchorpane;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		//윈도우 사이즈 변경 불가로 설정
		primaryStage.setResizable(false);
		
		
		//root.FXML에 정의된 코드를 자바로 표현한 것
//		AnchorPane root = new AnchorPane();
//		root.setPrefWidth(300.0);
//		root.setPrefHeight(150.0);
//		
//		Label id = new Label("ID");
//		id.setLayoutX(42.0);
//		id.setLayoutY(28.0);
//		
//		Label pw = new Label("Password");
//		pw.setLayoutX(42.0);
//		pw.setLayoutY(66.0);
//		
//		TextField tField = new TextField();
//		tField.setLayoutX(120.0);
//		tField.setLayoutY(24.0);
//		
//		PasswordField pField = new PasswordField();
//		pField.setLayoutX(120.0);
//		pField.setLayoutY(62.0);
//		
//		Button btn1 = new Button();
//		btn1.setText("로그인");
//		btn1.setLayoutX(97.0);
//		btn1.setLayoutY(106.0);
//		
//		Button btn2 = new Button();
//		btn2.setText("취소");
//		btn2.setLayoutX(164.0);
//		btn2.setLayoutY(106.0);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
