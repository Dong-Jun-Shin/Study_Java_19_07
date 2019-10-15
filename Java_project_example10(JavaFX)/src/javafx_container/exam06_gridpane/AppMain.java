package javafx_container.exam06_gridpane;

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
		
//		GridPane root = new GridPane();
//		root.setPrefWidth(300.0);
//		root.setHgap(10);
//		root.setVgap(10);
//		root.setPadding(new Insets(10.0));
//		
//		Label idLbl = new Label("아이디");
		
//		Label pwLbl = new Label("패스워드");
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
