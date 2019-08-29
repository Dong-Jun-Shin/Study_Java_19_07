package exam_switch;

import java.util.Scanner;

public class SwitchExample2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char oper = '\0';
		int n1, n2, total = 0;

		while (true) {
			System.out.println("������ �Է����ּ���. ex) 4(Enter) +(Enter) 4(Enter)");
			n1 = scan.nextInt();
			oper = scan.next().charAt(0);
			n2 = scan.nextInt();

			if (oper == '+' || oper == '-' || oper == '*' || oper == '/' || oper == '%') {
				break;
			} else {
				System.out.println("�����ڸ� �ٽ� �Է����ּ���.");
			}
		}

		switch (oper) {
		case '+':
			total = n1 + n2;
			break;
		case '-':
			total = n1 - n2;
			break;
		case '*':
			total = n1 * n2;
			break;
		case '/':
			if (n2 != 0) {
				total = n1 / n2;
			} else {
				System.out.println("0���� ���� �� �����ϴ�.");
			}
			break;
		case '%':
			total = n1 % n2;
			break;
		}

		System.out.println("��� : " + total);
		scan.close();
	}
}
