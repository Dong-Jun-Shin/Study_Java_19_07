package exam_lab;

import java.util.Scanner;

public class Page129 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1, n2;
		int greatest_common_divisor = 0;

		System.out.println("두 수를 입력하시오(큰 수, 작은 수): ");
		System.out.println("ex) 4(Enter) 8(Enter)");
		n1 = scan.nextInt();
		n2 = scan.nextInt();

		System.out.println("--------------------------------------------");
		System.out.println("입력한 두개의 정수: " + n1 + " " + n2);
		while (true) {
			if (n2 != 0) {
				if (n1 > n2) {
					greatest_common_divisor = n1 % n2;
					n1 = n2;
					n2 = greatest_common_divisor;
				} else {
					greatest_common_divisor = n2 % n1;
					n2 = greatest_common_divisor;
				}
			} else {
				greatest_common_divisor = n1;
				break;
			}
		}
		System.out.println("최대 공약수는 " + greatest_common_divisor);
		scan.close();
	}
}
