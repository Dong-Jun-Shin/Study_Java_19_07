package javafx_control.exam05_menubar_toolbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
	@FXML
	private ComboBox<String> colorChange;
	@FXML
	private TextArea textArea;
	@FXML
	private Button cstYes;
	@FXML
	private Button cstCancle;
	
	// 모달 사용을 위한 주 윈도우 가져오기
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private Popup popup = new Popup();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void handleNew(ActionEvent e) {
		textArea.clear();
		textArea.requestFocus();
	}

	public void handleOpen(ActionEvent e) {
		textArea.appendText("Open\n");
		BufferedReader br = null;
		String data = new String();

		// 파일 선택 Modal
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				// Text Files(*.txt) 형식으로 파일 형식 지정에서 보여주는 것
				new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"), new ExtensionFilter("All Files", "*.*"));

		// openDialog을 보여주고 선택된 파일을 반환한다. (저장형식의 다이얼로그)
		File selectedFile = fileChooser.showOpenDialog(primaryStage);

		// 파일 입출력 작업
		try {
			if (selectedFile != null) {
				String file = selectedFile.getPath(); // 선택한 파일의 경로 설정(확장자명까지)
				if (file.endsWith(".txt")) {
					textArea.clear();
					// 파일 오픈 시 텍스트 파일 처리부분.
					br = new BufferedReader(new FileReader(file)); // 문자 입력
					while ((data = br.readLine()) != null) {
						textArea.appendText(data + "\n");
					}
				} else {
//					Alert alert = new Alert(AlertType.WARNING);
//					alert.setTitle("파일 선택");
//					alert.setHeaderText("파일 선택 여부");
//					alert.setContentText("텍스트 파일만 읽어 들일 수 있습니다.");
//					alert.showAndWait();
					popupShow();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void handleSave(ActionEvent e) {
		// textArea.appendText("Save\n");
		PrintWriter pw = null;
		FileChooser fileChooser = new FileChooser();

		// 파일형식 필터 지정
		fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));

		// 기본 경로 설정
		File defaultDirectory = new File("C:/Temp");
		fileChooser.setInitialDirectory(defaultDirectory);

		// saveDialog을 보여주고 선택된 파일을 반환한다.(저장형식의 다이얼로그)
		File selectedFile = fileChooser.showSaveDialog(primaryStage);
//		System.out.println(selectedFile.getParent());

		try {
			if (selectedFile != null) {
				String file = selectedFile.getPath();
				if (!file.endsWith(".txt")) {
					file = file + ".txt";
				}
				pw = new PrintWriter(new FileWriter(file));
				pw.println(textArea.getText());
				pw.flush();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pw != null)
					pw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void handleColor(ActionEvent e) {
		textArea.setStyle("-fx-text-fill:"+colorChange.getValue());
	}

	public void handleExit(ActionEvent e) {
//		Platform.exit();
		try {
			handleConfirm(e);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void handleConfirm(ActionEvent e) throws Exception{
		//보여지는 창 정의
		//StageStyle.UTILITY : 배경이 흰색이고, 제목줄에 타이틀, 종료버튼만 존재.
		Stage dialog = new Stage(StageStyle.UTILITY);
		//모달 다이얼로그는 다이얼로그를 닫기 전까지 소유자 윈도우 사용 불가
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("확인");
		
		Parent parent = FXMLLoader.load(getClass().getResource("custom_dialog.fxml"));
		Label txtTitle = (Label) parent.lookup("#txtTitle");
		txtTitle.setText("종료하시겠습니까?");
		txtTitle.setStyle("-fx-font-size: 15");
		
		//컨트롤러 정의
		//확인 버튼 제어
		Button btnOk = (Button)parent.lookup("#btnOK");
		btnOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Platform.exit();
			}
		});
		
		//취소 버튼 제어
		Button btnCancel = (Button) parent.lookup("#btnCancel");
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				dialog.close();
			}
		});
		
		//메소드 실행, 정의 후, 창 띄우기
		Scene scene = new Scene(parent);
		dialog.setScene(scene);
		dialog.setResizable(false);
		dialog.show();
	}

	public void popupShow() throws IOException {
		//fxml파일 읽어들이기
		Parent parent = FXMLLoader.load(getClass().getResource("popup.fxml"));
		// lookup 메서드는 id 속성값으로 내부 객체를 찾아올 때 유용하게 사용된다.
		// popup의 컨트롤별 설정
		// ImageView 설정
		ImageView imageView = (ImageView) parent.lookup("#imgMessage");
		imageView.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
		// Label 설정
		Label lblMessage = (Label) parent.lookup("#lblMessage");
		lblMessage.setText("텍스트 파일만 읽어 들일 수 있습니다.");

		popup.getContent().add(parent);
		//다른 윈도우로 포커스를 이동하면 Popup은 자동으로 닫히도록 한다.
//		popup.setAutoHide(true);
		
		//마우스가 클릭되었을 때, 창이 닫히도록 한다.
		popup.setAutoHide(false);
		parent.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				popupHide();
			}
			
		});
		popup.show(primaryStage);
	}
	
	public void popupHide() {
		popup.hide();
	}
}
