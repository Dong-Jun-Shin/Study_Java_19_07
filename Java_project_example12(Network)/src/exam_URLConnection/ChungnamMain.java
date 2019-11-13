package exam_URLConnection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChungnamMain extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("chungnam.fxml"));
			//연결된 소스 속의 모든 객체를 생성하는 load()
			Parent root = loader.load();
			
			ChungnamController controller = loader.getController();
			controller.setPrimaryStage(primaryStage);

			Scene scene = new Scene(root);
			
			primaryStage.setTitle("충남문화관광");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
