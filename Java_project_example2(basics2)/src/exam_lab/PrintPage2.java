package exam_lab;

import java.util.Scanner;

public class PrintPage2 {
	public static void menu() {
		System.out.println("----------------------------");
		System.out.println("1.����  | 2.���  | 3.�ܰ�  | 4.����");
		System.out.println("----------------------------");
		System.out.print("����> ");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int account = 0, add = 0, sub = 0;
		int sel_num;
		
		/*
		 * byte, short, int, ���� ���������� switch���� ���������, 
		 * �� �̿��� ���� ũ�Ⱑ Ŀ�� if���� ����Ѵ�.
		 */
		outer: while (true) {
			menu();
			sel_num = scan.nextInt();

			switch (sel_num) {
			case 1:
				System.out.print("���ݾ�> ");
				add = scan.nextInt();

				if (add >= 0) {
					account += add;
				} else {
					System.out.println("����� �ƴմϴ�.");
				}
				break;
			case 2:
				System.out.print("��ݾ�> ");
				sub = scan.nextInt();

				if (account - sub >= 0) {
					account -= sub;
				} else {
					System.out.println("�ܰ� ����!!");
				}
				break;
			case 3:
				System.out.print("�ܰ�> " + account);
				break;

			case 4:
				System.out.println("���α׷� ����");
				break outer;
			default:
				System.out.println("�ٽ� �޴� ������ �ּ���.");
				break;
			}
			System.out.println();
		}
		scan.close();
	}
}