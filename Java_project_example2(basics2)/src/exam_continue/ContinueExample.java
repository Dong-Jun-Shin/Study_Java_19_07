package exam_continue;

import java.util.Scanner;

/*
 * 문자열"no news is good news"를 대상으로 반복하며 문자 'n'이 나타나는 횟수를 카운팅한다. 만약 현재의 문자가 'n'이
 * 아니면 continue문에 의하여 루프의 나머지 부분을 생략하고 다음 문자를 처리한다. 
 * 문자의 길이는 length()로 구하면 된다.
 */
public class ContinueExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sentence = "no news is good news";
		int cnt = 0;

		System.out.println("찾을 문자를 입력해주세요.");
		char ch = scan.next().charAt(0);

		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) != ch) {
				continue;
			}
			cnt++;
		}
		System.out.println(cnt);
		System.out.println();

		scan.close();
	}
}
