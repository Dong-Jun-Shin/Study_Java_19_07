package exam_if;

import java.util.Scanner;

public class MaximumFinder {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, c;
		int max;

		System.out.println("�� ���� ���� �Է����ּ���.");
		System.out.print("ù��° �� : ");
		a = scan.nextInt();

		System.out.print("�ι�° �� : ");
		b = scan.nextInt();

		System.out.print("����° �� : ");
		c = scan.nextInt();
		
		max = a;
		if (max < b) {
			max = b;
		}
		if (max < c) {
			max = c;
		}
		
		System.out.println("�ִ밪 : " + max);

		scan.close();
	}
}
