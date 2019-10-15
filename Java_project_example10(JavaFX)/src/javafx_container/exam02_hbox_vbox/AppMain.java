package javafx_container.exam02_hbox_vbox;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		VBox root = (VBox)FXMLLoader.load(getClass().getResource("root.fxml"));
		Scene scene = new Scene(root);
		
		//사진 삽입
//		VBox root = new VBox(); //루트 컨테이너 생성
//		Label label = new Label();
//		Image image = new Image(getClass().getResourceAsStream("image/1.jpg"));
//		label.setGraphic(new ImageView(image));
//		
//		root.getChildren().add(label);

		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
