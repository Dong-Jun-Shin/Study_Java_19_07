package exam_lab;

import java.util.Scanner;

/*
 * 3, 6, 9 게임을 구현해라.
 * switch문과 cnt를 활용해서 구현
 */
public class PrintPage1_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n, oper, cnt = 0;
		
		System.out.print("1~99 사이의 정수를 입력하시오>> ");
		n = scan.nextInt();

		if (n < 100 && n >= 0) {
			oper = n / 10;
			if (oper == 3 || oper == 6 || oper == 9) {
				cnt++;
			}
			oper = n % 10;
			if (oper == 3 || oper == 6 || oper == 9) {
				cnt++;
			}
		} else {
			System.out.println("값의 범위를 초과하였습니다.");
		}

		switch (cnt) {
		case 1:
			System.out.println("박수짝");
			break;
		case 2:
			System.out.println("박수짝짝");
		}
		scan.close();
	}
}