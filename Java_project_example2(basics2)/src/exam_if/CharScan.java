package exam_if;

import java.util.Scanner;

public class CharScan {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//char변수에 빈 값 넣기.
		//char ch = null; - 쓸 수 없다.
		//char ch = ''; - 쓸 수 없다.
		char ch = '\0'; // 아스키 코드 십진수 - : NUL(NULL)
		
		//String변수에 빈 값 넣기.
		//String str = null; - 가능
		String str = ""; // - 가능
		
		System.out.println("한문자를 입력하세요 : ");
		//charAt(index) - char형태로 'index'번째 글자를 가져온다.
		ch = scan.next().charAt(0);
		
		System.out.println(ch+"는 문자입니다. ^^");
		scan.close();
	}
}
