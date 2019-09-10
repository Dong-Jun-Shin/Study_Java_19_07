package exam_api_string.exam02_method;
/**
  	ssn 변수에 대입된 값으로 성별과 나이(만)을 출력하도록 작성해 보세요.
	우선 성별을 출력하도록 코드 작성해 주세요.
	나이(만), 성별 구하기
 */

import java.time.LocalDateTime;
//import java.util.Calendar;

class Oper {
	private static LocalDateTime now = LocalDateTime.now();
	
	//현재 날짜 & 시간을 가져 오는 클래스
	//Calendar now = Calendar.getInstance();
	//year = now.get(Calendar.YEAR);
	//year = now.get(Calendar.MONTH)+1;
	//year = now.get(Calendar.DAY_OF_MONTH);
	
	
	public static String getGender(String ssn) {
		String judge = ssn.substring(9, 10);
		String gender = "구분 불가";

		//성별 구분 (1900년대와 2000년대의 경우 구분)
		if (judge.equals("1") || judge.equals("3")) {
			gender = "남";
		} else if (judge.equals("2") || judge.equals("4")) {
			gender = "여";
		}

		return gender;
	}

	private static int getAge(String ssn) {
		String judge = ssn.substring(9, 10);
		int year = 0;

		//성별 구분 (1900년대와 2000년대의 경우 구분
		if (judge.equals("1") || judge.equals("2")) {
			year = now.getYear() - 1900;
		} else if (judge.equals("3") || judge.equals("4")) {
			year = now.getYear() - 2000;
		} else {
			return 0;
		}

		int yAge = Integer.parseInt(ssn.substring(0, 2));
		int age = (year - yAge) + 1;

		return age;
	}

	public static String filterAge(String ssn) {
		String s = "";
		int n = getAge(ssn);
		
		// 입력이 잘못 되었을때
		if(n == 0) {
			s = "입력 오류";
		}else{
			s = String.valueOf(n);
		}
		
		return s;
	}
	
	public static String getTrueAge(String ssn) {
		//나이 구하기 (기본 만 나이(-1))
		int age = getAge(ssn) - 1;
		String sYear = "";
		
		//월 구하기
		int month = now.getMonthValue();
		int mAge = Integer.parseInt(ssn.substring(2, 4));
		
		//일 구하기
		int day = now.getDayOfMonth();
		int dAge = Integer.parseInt(ssn.substring(4, 6));
		
		//나이가 잘못 입력되지 않고, 생일이 안 지났으면(-1)
		if (age != -1) {
			if (mAge > month) {
				if (dAge > day) {
					age -= 1;
				}
			}
			sYear = age + "";
		}else {
			sYear = "입력 오류";
		}
		
		return sYear;
	}

}

public class OperAgeGender {
	public static void main(String[] args) {
		String ssn = "660606 - 1234561";

		System.out.printf("나이(만): %s(%s)\n", Oper.filterAge(ssn), Oper.getTrueAge(ssn));
		System.out.println("성별 : " + Oper.getGender(ssn));
	}
}