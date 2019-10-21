package javafx_control.exam05_menubar_toolbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class RootController implements Initializable {
	@FXML
	private ComboBox<String> colorChange;
	@FXML
	private TextArea textArea;

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
		
		//파일 선택 Modal
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				//Text Files(*.txt) 형식으로 파일 형식 지정에서 보여주는 것
				new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
				new ExtensionFilter("All Files", "*.*"));
		
		//openDialog을 보여주고 선택된 파일을 반환한다. (저장형식의 다이얼로그)
		File selectedFile = fileChooser.showOpenDialog(primaryStage);
		
		//파일 입출력 작업
		try {
			if(selectedFile != null) {
				String file = selectedFile.getPath(); //선택한 파일의 경로 설정(확장자명까지)
				if(file.endsWith(".txt")) {
					textArea.clear();
					//파일 오픈 시 텍스트 파일 처리부분.
					br = new BufferedReader(new FileReader(file)); //문자 입력
					while((data = br.readLine())!=null) {
						textArea.appendText(data+"\n");
					}
				}else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("파일 선택");
					alert.setHeaderText("파일 선택 여부");
					alert.setContentText("텍스트 파일만 읽어 들일 수 있습니다.");
					alert.showAndWait();
					//popupShow();
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(br!=null) br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void handleSave(ActionEvent e) {
		//textArea.appendText("Save\n");
		PrintWriter pw = null;
		FileChooser fileChooser = new FileChooser();
		
		//파일형식 필터 지정
		fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));
	
		//기본 경로 설정
		File defaultDirectory = new File("C:/Temp");
		fileChooser.setInitialDirectory(defaultDirectory);
		
		//saveDialog을 보여주고 선택된 파일을 반환한다.(저장형식의 다이얼로그)
		File selectedFile = fileChooser.showSaveDialog(primaryStage);
//		System.out.println(selectedFile.getParent());
		
		try {
			if(selectedFile != null) {
				String file = selectedFile.getPath();
				if(!file.endsWith(".txt")) {
					file = file + ".txt";
				}
				pw = new PrintWriter(new FileWriter(file));
				pw.println(textArea.getText());
				pw.flush();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(pw!=null) pw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void handleColor(ActionEvent e) {

	}

	public void handleExit(ActionEvent e) {
		Platform.exit();
	}

}
