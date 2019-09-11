package exam_api;

import java.util.Scanner;
import java.util.StringTokenizer;

/* 다음은 프로그램의 실행 방법과 결과를 보여준다. 동일하게 작성하도록 자바 프로그램을 완성하라.
 * 
 * [실행결과]
 * 문자를 입력해 주세요:name=홍길동&id=java1234&email=java1234@naver.com
 * name 홍길동
 * id java1234
 * email java1234@naver.com
 */
public class QueryString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자를 입력해 주세요: ");
//		String str = scan.nextLine();
		String str = "name=홍길동&id=java1234&email=java1234@naver.com";
		System.out.println(str);
		
		str = str.replace("=", "\t");
		StringTokenizer strTk = new StringTokenizer(str, "&");
		
		int i = 0;
		while(strTk.hasMoreTokens()) {
			String strTemp = strTk.nextToken();
			System.out.println(strTemp);
		}
		
		scan.close();
	}
}
