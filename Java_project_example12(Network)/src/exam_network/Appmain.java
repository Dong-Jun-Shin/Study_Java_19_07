package exam_network;

import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Appmain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOqaD2LdTqP-JFP-0VvjaQ0tTlHZKwzTwwnhzuKxL0Z4s-gFbslA&s");
		VBox root = new VBox(); // 루트 컨테이너 생성
		ImageView img = new ImageView();
		Image image = new Image(url.toString());
		img.setImage(image);
		
		root.getChildren().add(img);
		Scene scene = new Scene(root);
		primaryStage.setTitle("이미지");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
