package javafx_control.exam01_button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RootController implements Initializable {
	@FXML
	private CheckBox glasses;
	@FXML
	private CheckBox hat;
	@FXML
	private ImageView checkImageView;

	@FXML
	private ToggleGroup group;
	@FXML
	private ImageView radioImageView;

	@FXML
	private Button btnExit;

	@FXML
	private ToggleGroup groupBtn;
	@FXML
	private Rectangle shape;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// group 토글의 속성 변경을 감시
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				//newValue : radio에 선택되어 있는 값(<userData>)
				Image image = new Image(
						getClass().getResource("images/" + newValue.getUserData().toString() + ".png").toString());
				radioImageView.setImage(image);
				// 속성의 이전 값
				System.out.println(oldValue.getUserData());
				// 속성의 새로운 값
				System.out.println(newValue.getUserData());
			}
		});
		// groupBtn 토글의 속성 변경을 감시
		groupBtn.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			//oldValue : 클릭 전 선택되어 있는 토글의 fx:id
			//newValue : 클릭한 토글의 fx:id
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (newValue == null) {
					shape.setFill(Color.WHITE);
				} else {
					//root.fxml의 <userData>문 내용을 가져온다.
					shape.setFill((Color) newValue.getUserData());
				}
			}
		});
	}

	public void handleChkAction(ActionEvent e) {

	}

	public void handleChkAction() {
		if (glasses.isSelected() && hat.isSelected()) {
			checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses-hair.gif").toString()));
		} else if (glasses.isSelected()) {
			checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses.gif").toString()));
		} else if (hat.isSelected()) {
			checkImageView.setImage(new Image(getClass().getResource("images/geek-hair.gif").toString()));
		} else {
			checkImageView.setImage(new Image(getClass().getResource("images/geek.gif").toString()));
		}
	}

	public void btnAction() {
		Platform.exit();
	}

	public void btnMouseEnter() {
		DropShadow shadow = new DropShadow();
		btnExit.setEffect(shadow);
	}

	public void btnMouseExit() {
		btnExit.setEffect(null);
	}

}
