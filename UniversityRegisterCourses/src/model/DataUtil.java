package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataUtil {
	
	/**
	 * 유효성 체크를 위한 메서드.
	 * 
	 * @param value 입력값
	 * @param printData 보여줄 문자열
	 * @return boolean 결과
	 */
	public static boolean validityCheck(String value, String printData) {
		boolean result = true;
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("입력 여부 확인");
		
		//입력값 공백 여부 확인
		if(isBlank(value)) {
			alert.setHeaderText(printData + " 입력 및 선택해 주세요");
			alert.setContentText("값이 입력되지 않으면 정상적으로 작업을 수행 할 수가 없습니다.");
			alert.showAndWait();
			result = false;
		}
		
		return result;
	}
	
	private static boolean isBlank(String str) {
		int strLen;
		if(str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if(!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
