package model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataUtil {

	
	
	/**
	 * 유효성 체크를 위한 메서드.
	 * 
	 * @param value     입력값
	 * @param printData 보여줄 문자열
	 * @return boolean 결과
	 */
	public static boolean validityCheck(String value, String printData) {
		boolean result = true;
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("입력 여부 확인");

		// 입력값 공백 여부 확인
		if (isBlank(value)) {
			alert.setHeaderText(printData + " 입력 및 선택해 주세요");
			alert.setContentText("값이 입력되지 않거나 공백이 있으면 정상적으로 작업을 수행 할 수가 없습니다.");
			alert.showAndWait();
			result = false;
		}

		return result;
	}

	private static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
				if (Character.isWhitespace(str.charAt(i))) {
					return true;
				}
		}
		return false;
	}

	/**
	 * fieldName() 메서드는 클래스 내의 필드명을 반환하는 메서드이다.
	 * 
	 * @param (필드명을 얻고자 하는 클래스)
	 * @return List<String> 타입. 참고 : Class 클래스는 클래스에 대한 정보를 얻고자 할 때 사용하는 클래스이다.
	 *         Class 클래스는 생성자가 존재하지 않는다. - String getName(): 클래스의 이름을 리턴한다. -
	 *         Field[] getFields(): public으로 선언된 변수 목록을 Field 클래스 배열 타입으로 리턴한다. -
	 *         Field[] getDeclaredFields(): 해당 클래스에서 정의된 변수 목록을 field 클래스 배열 타입으로
	 *         리턴한다. - Method[] getMethods(): public으로 선언된 모든 메소드 목록을 Method 클래스 배열
	 *         타입으로 리턴한다. 해당 클래스에서 사용 가능한 상속받은 메소드도 포함된다.
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

}
