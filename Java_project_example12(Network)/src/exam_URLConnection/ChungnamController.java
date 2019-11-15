package exam_URLConnection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChungnamController implements Initializable {

	// 테이블 구성을 위한 설정
	@FXML
	private TableView<ChungnamVO> cultureTourTableView;

	ObservableList<ChungnamVO> cultureTourDataList = FXCollections.observableArrayList();

	// 서브 윈도우와 메인 윈도우를 위한 설정
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> field = fieldName(new ChungnamVO());
		
		for (int i = 0; i < field.size(); i++) {
			TableColumn columnName = cultureTourTableView.getColumns().get(i);
			columnName.setCellValueFactory(new PropertyValueFactory<>(field.get(i).toLowerCase()));
		}
		
		cultureTourTableView.setItems(cultureTourDataList);
		cultureTourTotalList();
	}

	/**
	 * TableView 클릭시 썸네일 이미지 존재시 서브 윈도우로 제어 메소드
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void cultureTourTableView(MouseEvent event) throws Exception {
		URL url = null;
		Image image = null;
		
		ChungnamVO cVO = cultureTourTableView.getSelectionModel().getSelectedItem();
		//정확하게 레코드가 선택되었는지 확인 
		if(cVO != null) {
			//값이 있는지 여부 확인
			if(cVO.getList_img() != null) {
				url = new URL(cVO.getList_img());
				image = new Image(url.toString());
				
				final Stage dialog = new Stage(StageStyle.UTILITY);
				dialog.initModality(Modality.WINDOW_MODAL);
				dialog.initOwner(primaryStage);;
				dialog.setTitle("이미지 뷰");
				
				Parent parent = FXMLLoader.load(getClass().getResource("imageview.fxml"));
				
				ImageView imageView = (ImageView) parent.lookup("#imageView");
				imageView.setImage(image);
				
				Label title = (Label) parent.lookup("#title");
				title.setText(cVO.getNm());
				
				Button btnClose = (Button) parent.lookup("#btnClose");
				btnClose.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						dialog.close();
					}
					
				});
				
				Scene scene = new Scene(parent);
				dialog.setScene(scene);
				dialog.show();
			}
		}
	}

	/**
	 * 종료 버튼 제어 메서드.
	 * 
	 * @param event
	 */
	public void closeAction(ActionEvent event) {
		Platform.exit();
	}

	/**
	 * TableView에 데이터 출력을 위한 처리 메소드
	 */
	public void cultureTourTotalList() {
		cultureTourDataList.removeAll(cultureTourDataList);
		ChungnamVO cVo = null;
		List<ChungnamVO> list;
		
		try {
			list = dataProcess();
			
			for (int index = 0; index < list.size(); index++) {
				cVo = list.get(index);
				cultureTourDataList.add(cVo);
			}
		} catch (Exception e) {
			System.out.println("cultureTourTotalList() e = [ " + e.getMessage() + "]");
//			e.printStackTrace();
		}
		

	}

	/**
	 * 클래스 내의 필드명을 반환하는 메서드이다.
	 * 
	 * @param obj
	 * @return List<String>
	 */
	public static List<String> fieldName(Object obj) {
		// obj == vo클래스
		// obj의 정의되어 있는 필드명을 배열 타입으로 가져온다.
		Field[] fields = obj.getClass().getDeclaredFields();
		// obj의 필드명을 받아서 ArrayList의 목록에 추가해놓는다.
		List<String> result = new ArrayList<>();
		for (int i = 0; i < fields.length; i++) {
			try {
				result.add(fields[i].getName());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return null;
			}
		}

		// obj의 필드명을 문자열로 갖는 리스트를 반환
		return result;
	}

	/**
	 * 충청남도 관광 명소 데이터 URL을 통해 가져와서 각각의 반복되는 데이터(item)를 
	 * CHungnamVO에 대입하여 ArrayList에 저장하는 메소드
	 * @return List<ChungnamVO>
	 */
	public List<ChungnamVO> dataProcess(){
		Document xml = null;
		Method method;
		
		List<ChungnamVO> dataList = new ArrayList<>();
		
		// https://www.data.go.kr/dataset/15005124/openapi.do - 충청남도 맛집 현황
		// http://tour.chungnam.net/_prog/openapi/?func=tour&mode=getCnt
		try {
			URL url = new URL("http://tour.chungnam.net/_prog/openapi/?func=tour&start=1&end=50");
			URLConnection con = url.openConnection();
			
			//URL의 소스를 읽어들여서 Document객체에 저장한다.
			InputSource is =new InputSource(con.getInputStream());
			xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			
			//root element 취득 (하위노드로 접근하는데 이용)
			Element element = xml.getDocumentElement();
//			System.out.println(element.getNodeName());	//item_info (xml이 가지고 있는 최상위 노드)
			
			//child node 취득 (하위노드가 여러개이므로 NodeList로 모두 받는다.
			NodeList list = element.getChildNodes();
//			System.out.println(list.getLength());	//item 개수
			
			Object obj = null;
			Field[] fields = null;
			if(list.getLength() > 0) {
				for (int i = 0; i < list.getLength(); i++) {
					NodeList childList = list.item(i).getChildNodes();
					obj = new ChungnamVO();
					fields = obj.getClass().getDeclaredFields();
					
					if(childList.getLength() > 0) {
						for (int j = 0, f = 0; j < childList.getLength(); j++) {
							//데이터가 있는 애들만 출력되게 한다.
							if (!childList.item(j).getNodeName().equals("#text")) {
								//노드이름(nm)과 내용(값)을 보여준다. (이미지-경로... 등)
//								System.out.println("\t xml tag name : " + 
//									childList.item(j).getNodeName() + ",\t\t xml값 : " + 
//									childList.item(j).getTextContent());
								
								if(fields[f].getName().equals(childList.item(j).getNodeName())) {
									//method명을 만들기 위한 구문, 예시) "set + F + ields"
									//subString(시작, 개수) - 개수 생략 시, 끝까지
									method = obj.getClass().getMethod(
											"set"+fields[f].getName().substring(0,1).toUpperCase() + 
											fields[f].getName().substring(1).toLowerCase(), 
											new Class[] {String.class});
									
									//invoke(): 메소드를 동적으로 실행하는 메소드
									//obj.obj(new Object[]...)와 같은 기능
									method.invoke(obj, new Object[] {new String(childList.item(j).getTextContent())});
									f++;
								}
							}
						}
//						System.out.println(((ChungnamVO)obj).toString());
						dataList.add((ChungnamVO)obj);
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return dataList;
	}
}
