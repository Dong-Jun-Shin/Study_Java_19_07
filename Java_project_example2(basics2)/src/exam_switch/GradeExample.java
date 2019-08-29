package exam_switch;

import java.util.Scanner;

public class GradeExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int jumsu = 0, number;
		char hakjum;
		
		/* while문과 조건을 이용
			while (jumsu < 0 || jumsu > 100) {
				System.out.println("점수는 0~100사이로 입력해 주세요.");
				jumsu = scan.nextInt();
			}
		 */
		
		/* do~while문을 사용
			do {
				System.out.println("점수는 0~100사이로 입력해 주세요.");
				jumsu = scan.nextInt();
			} while (jumsu < 0 || jumsu > 100);
		*/
		
		//while, if, break 사용
		while (true) {
			System.out.println("점수는 0~100사이로 입력해 주세요.");
			jumsu = scan.nextInt();

			System.out.println();
			System.out.println("jumsu의 초기값 : " + jumsu);

			if (jumsu < 0 || jumsu > 100) {
				System.out.println("점수의 범위를 벗어났습니다.");
				System.out.println("다시 입력해주세요.");
				System.out.println("----------------------");
			} else {
				break;
			}
		}

		number = jumsu / 10;
		switch (number) {
		case 10:
		case 9:
			hakjum = 'A';
			break;
		case 8:
			hakjum = 'B';
			break;
		case 7:
			hakjum = 'C';
			break;
		case 6:
			hakjum = 'D';
			break;
		default:
			hakjum = 'F';
		}
		System.out.println("당신의 학점은 " + hakjum);
		scan.close();
	}
}
