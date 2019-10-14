package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane; //Parent의 하위클래스 포함
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//레이아웃 형식
			BorderPane root = new BorderPane();
			//Scene(layout, width, height) 화면프레임객체
			Scene scene = new Scene(root,400,400);
			//CSS 적용
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Button btn = new Button("Hello");
			root.setCenter(btn);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
