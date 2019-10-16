package javafx_layout.programmatical_layout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		//// Layout
		// HBox 컨테이너 생성(수평으로 나오는)
		HBox hbox = new HBox();
		// 안쪽 여백 설정
		hbox.setPadding(new Insets(10, 10, 10, 10));
		// 컨트롤 간의 수평 간격 설정
		hbox.setSpacing(10);

		//// TextField, Layer, Button
		// TextField 컨트롤 생성
		TextField textField1 = new TextField();
		// TextField 폭 설정
		textField1.setPrefWidth(50);

		Label oper = new Label("+");

		// TextFiled 컨트롤 생성
		TextField textField2 = new TextField();
		// TextField 폭 설정
		textField2.setPrefWidth(50);

		TextField textResult = new TextField();
		// TextField text 폭 설정
		textResult.setPrefWidth(50);
		// TextField의 text 수정을 못하도록 설정
		textResult.setEditable(false);

		// Buttpn 컨트롤 생성
		Button result = new Button("=");
		// Button 글자 설정
		// btn.setText("확인");
		// 클릭 이벤트 생성
		result.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				boolean textBool = textField1.getText().equals("") && 
									textField2.getText().equals("");
				if (!(textBool)) {
					int num1 = Integer.parseInt(textField1.getText());
					int num2 = Integer.parseInt(textField2.getText());
//					textResult.setText((num1 + num2) + "");
					textResult.setText(String.valueOf(num1+num2));
				} else {
					////경고창 띄우기
					//타입에 따른 아이콘 변경
					//원형 i 아이콘
					Alert alert = new Alert(AlertType.INFORMATION);
					//삼각형 ! 아이콘
					alert.setAlertType(AlertType.WARNING);
					//X 아이콘
					alert.setAlertType(AlertType.ERROR);
					//? 아이콘
					alert.setAlertType(AlertType.CONFIRMATION);
					//아이콘 없음 (종료버튼 안됨)
					alert.setAlertType(AlertType.NONE);
						
					//머리(Head) 제목 부분
					alert.setHeaderText("데이터 입력 오류");
					//몸통(Body) 내용 부분
					alert.setContentText("숫자를 입력해 주세요");
					alert.show();
				}
			}
		});

		Button ce = new Button("초기화");
		//무명 클래스 - new 부모클래스 or 인터페이스() { }
		//				: implements목적, 추상클래스 재정의로 구현
		ce.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textField1.setText("");
				textField2.setText("");
				textResult.setText("");
			}
		});

		// add elements in Layout
		// Layout에 요소들 추가
		hbox.getChildren().add(textField1);
		hbox.getChildren().add(oper);
		hbox.getChildren().add(textField2);
		hbox.getChildren().add(result);
		hbox.getChildren().add(textResult);
		hbox.getChildren().add(ce);

		// Scene 생성
		Scene scene = new Scene(hbox);
		primaryStage.setTitle("더하기");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
