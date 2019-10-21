package javafx_control.exam03_view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListViewMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		//fxml 불러오기
		Parent root = FXMLLoader.load(getClass().getResource("list.fxml"));
		//Scene 불러오기
		Scene scene = new Scene(root);
		
		//스테이지에 제목 설정
		primaryStage.setTitle("ListView Example");
		//스테이지에 Scene(화면) 설정
		primaryStage.setScene(scene);
		//(설정이 되어있는) 스테이지를 보여주기
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
