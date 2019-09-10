package exam_api_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		// Tue Sep 10 10:55:02 KST 2019
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		// 2019(yyyy)년 09(MM)월 10(dd)일 화(E)요일 오전(a) 10(hh)시 55(mm)분 02(ss)초
		// 대소문자 구분 / a를 빼게 되면 hh는 24시 기준이 된다.
		// SimpleDateFormat 생성 시, Date를 생성한 후, 지정한 패턴으로 반환.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		// sdf의 지정되어 있는 값을 format을 이용해서 String으로 반환
		String strNow2 = sdf.format(now); //Date형식
		System.out.println(strNow2);
		
		// Calendar 클래스로 날짜 설정.
		Calendar today = Calendar.getInstance();
		System.out.println(sdf.format(today.getTime())); //Calendar형 -> Date형식
	}
}
