package exam_lab;

import java.util.Scanner;

/*
 * 3, 6, 9 ������ �����ض�.
 * switch���� cnt�� Ȱ���ؼ� ����
 */
public class PrintPage1_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n, oper, cnt = 0;
		
		System.out.print("1~99 ������ ������ �Է��Ͻÿ�>> ");
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
			System.out.println("���� ������ �ʰ��Ͽ����ϴ�.");
		}

		switch (cnt) {
		case 1:
			System.out.println("�ڼ�¦");
			break;
		case 2:
			System.out.println("�ڼ�¦¦");
		}
		scan.close();
	}
}