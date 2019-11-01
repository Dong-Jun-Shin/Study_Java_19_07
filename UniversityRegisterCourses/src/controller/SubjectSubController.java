package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DataUtil;
import model.SubjectDAO;
import model.SubjectVO;

public class SubjectSubController implements Initializable{
	@FXML private TextField s_name;
	@FXML private Button btnSearch;
	@FXML private TableView<SubjectVO> subjectView;
//	@FXML private Button btnChoice;
//	@FXML private Button btnClose;
	
	private Stage dialog;
	public void setDialog(Stage dialog) {
		this.dialog = dialog;
	}
	
	private SubjectDAO sbdao = SubjectDAO.getInstance();
	
	//DB결과를 담는 변수
	private ObservableList<SubjectVO> data = FXCollections.observableArrayList();
	
	private String s_num = "";
	public String getS_num() {
		return s_num;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<SubjectVO, ?> dnoColumn = subjectView.getColumns().get(0);
		dnoColumn.setCellValueFactory(new PropertyValueFactory<>("s_num"));
		
		TableColumn<SubjectVO, ?> dnameColumn = subjectView.getColumns().get(1);
		dnameColumn.setCellValueFactory(new PropertyValueFactory<>("s_name"));
		
		subjectView.setItems(data);
		TableViewData(null);
	}
	
	/**
	 * 테이블뷰에 보여줄 레코드 설정
	 * 
	 * @param searchWord
	 */
	private void TableViewData(String searchWord) {
		SubjectVO dvo = null;
		ArrayList<SubjectVO> list;
		//다른 결과가 있을수도 있는 DB결과를 담는 변수를 비워준다.
		data.removeAll(data);
		
		try {
			list = sbdao.getSubjectTotalList(searchWord);
			
			int rowCount = list.size();
			for (int index = 0; index < rowCount; index++) {
				dvo = list.get(index);
				data.add(dvo);
			}
		} catch (Exception e) {
			System.out.println("e TableViewData() = [ " + e.getMessage() + "]");
		}
		
	}

	/**
	 * 검색 버튼 및 전체(목록) 버튼
	 * @param event
	 */
	public void btnSearchAction(ActionEvent event) {
		if (!DataUtil.validityCheck(s_name.getText(), "검색할 학과명을")) {
			return;
		}else {
			TableViewData(s_name.getText());
		}
	}
	
	/**
	 * 테이블에서 행 선택
	 * @param event
	 */
	public void tableSelected(MouseEvent event) {
		//항목을 가져온다.
		SubjectVO svo = subjectView.getSelectionModel().getSelectedItem();
		
		//비어있지 않을 떄, 설정
		if(svo != null) {
			s_num = svo.getS_num();
			s_name.setText(svo.getS_name());
		}
	}
	
	/**
	 * 검색 창 닫기
	 * @param event
	 */
	public void btnClose(ActionEvent event) {
		dialog.close();
	}
}
