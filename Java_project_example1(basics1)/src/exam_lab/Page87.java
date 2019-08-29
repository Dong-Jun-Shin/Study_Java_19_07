package exam_lab;

import java.util.Scanner;

public class Page87 {
	public static void main(String[] args) {
		double b, c, root, sol1, sol2;
		Scanner scan = new Scanner(System.in);

		System.out.println("b의 값을 입력해주세요. (x*x + b*x + c)");
		b = scan.nextDouble();

		System.out.println("c의 값을 입력해주세요. (x*x + b*x + c)");
		c = scan.nextDouble();

		// 제곱근 계산
		root = Math.sqrt(b * b - 4 * c);
		sol1 = (-b + root) / 2;
		sol2 = (-b - root) / 2;

		System.out.println("근은 " + sol1);
		System.out.println("근은 " + sol2);
		
		scan.close();
	}
}
