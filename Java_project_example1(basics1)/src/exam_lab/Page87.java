package exam_lab;

import java.util.Scanner;

public class Page87 {
	public static void main(String[] args) {
		double b, c, root, sol1, sol2;
		Scanner scan = new Scanner(System.in);

		System.out.println("b�� ���� �Է����ּ���. (x*x + b*x + c)");
		b = scan.nextDouble();

		System.out.println("c�� ���� �Է����ּ���. (x*x + b*x + c)");
		c = scan.nextDouble();

		// ������ ���
		root = Math.sqrt(b * b - 4 * c);
		sol1 = (-b + root) / 2;
		sol2 = (-b - root) / 2;

		System.out.println("���� " + sol1);
		System.out.println("���� " + sol2);
		
		scan.close();
	}
}
