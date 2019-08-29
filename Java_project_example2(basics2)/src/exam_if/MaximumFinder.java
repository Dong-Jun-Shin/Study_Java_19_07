package exam_if;

import java.util.Scanner;

public class MaximumFinder {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, c;
		int max;

		System.out.println("세 개의 수를 입력해주세요.");
		System.out.print("첫번째 수 : ");
		a = scan.nextInt();

		System.out.print("두번째 수 : ");
		b = scan.nextInt();

		System.out.print("세번째 수 : ");
		c = scan.nextInt();
		
		max = a;
		if (max < b) {
			max = b;
		}
		if (max < c) {
			max = c;
		}
		
		System.out.println("최대값 : " + max);

		scan.close();
	}
}
