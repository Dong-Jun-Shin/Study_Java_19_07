package javafx_container.exam03_borderpane;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Borderpane은 center 한칸으로 구성되있고, 영역을 지정하고 정의하면 해당 영역을 분리해서 구성해준다.
 */
public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(true);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
