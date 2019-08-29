package exam_input;

import java.util.Scanner;

public class Add2 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int x;
		int y;
		int sum;

		System.out.println("첫번째 숫자를 입력하시오: ");
		x = scan.nextInt();

		System.out.println("두번째 숫자를 입력하시오: ");
		y = scan.nextInt();

		sum = x + y;

		System.out.println("두 수의 합 : " + sum);

		scan.close();
	}
}
