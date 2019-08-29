package exam_lab;

import java.util.Scanner;

public class PrintPage2 {
	public static void menu() {
		System.out.println("----------------------------");
		System.out.println("1.예금  | 2.출금  | 3.잔고  | 4.종료");
		System.out.println("----------------------------");
		System.out.print("선택> ");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int account = 0, add = 0, sub = 0;
		int sel_num;
		
		/*
		 * byte, short, int, 문자 정도까지는 switch문을 사용하지만, 
		 * 그 이외의 것은 크기가 커서 if문을 사용한다.
		 */
		outer: while (true) {
			menu();
			sel_num = scan.nextInt();

			switch (sel_num) {
			case 1:
				System.out.print("예금액> ");
				add = scan.nextInt();

				if (add >= 0) {
					account += add;
				} else {
					System.out.println("출금이 아닙니다.");
				}
				break;
			case 2:
				System.out.print("출금액> ");
				sub = scan.nextInt();

				if (account - sub >= 0) {
					account -= sub;
				} else {
					System.out.println("잔고 부족!!");
				}
				break;
			case 3:
				System.out.print("잔고> " + account);
				break;

			case 4:
				System.out.println("프로그램 종료");
				break outer;
			default:
				System.out.println("다시 메뉴 선택해 주세요.");
				break;
			}
			System.out.println();
		}
		scan.close();
	}
}