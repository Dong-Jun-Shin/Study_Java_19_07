package exam_switch;

import java.util.Scanner;

public class GradeExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int jumsu = 0, number;
		char hakjum;
		
		/* while���� ������ �̿�
			while (jumsu < 0 || jumsu > 100) {
				System.out.println("������ 0~100���̷� �Է��� �ּ���.");
				jumsu = scan.nextInt();
			}
		 */
		
		/* do~while���� ���
			do {
				System.out.println("������ 0~100���̷� �Է��� �ּ���.");
				jumsu = scan.nextInt();
			} while (jumsu < 0 || jumsu > 100);
		*/
		
		//while, if, break ���
		while (true) {
			System.out.println("������ 0~100���̷� �Է��� �ּ���.");
			jumsu = scan.nextInt();

			System.out.println();
			System.out.println("jumsu�� �ʱⰪ : " + jumsu);

			if (jumsu < 0 || jumsu > 100) {
				System.out.println("������ ������ ������ϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
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
		System.out.println("����� ������ " + hakjum);
		scan.close();
	}
}
