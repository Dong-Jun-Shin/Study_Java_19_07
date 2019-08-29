package exam_switch;

import java.util.Scanner;

public class SwitchExample2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char oper = '\0';
		int n1, n2, total = 0;

		while (true) {
			System.out.println("연산을 입력해주세요. ex) 4(Enter) +(Enter) 4(Enter)");
			n1 = scan.nextInt();
			oper = scan.next().charAt(0);
			n2 = scan.nextInt();

			if (oper == '+' || oper == '-' || oper == '*' || oper == '/' || oper == '%') {
				break;
			} else {
				System.out.println("연산자를 다시 입력해주세요.");
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
				System.out.println("0으로 나눌 수 없습니다.");
			}
			break;
		case '%':
			total = n1 % n2;
			break;
		}

		System.out.println("결과 : " + total);
		scan.close();
	}
}
