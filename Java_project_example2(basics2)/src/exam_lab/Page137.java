package exam_lab;

import java.util.Scanner;

public class Page137 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i, num, sum = 0;

		System.out.println("난수의 개수 : ");
		num = scan.nextInt();

		for (i = 0; i < num; i++) {
			sum = sum + (int) ((Math.random() * 100) + 1);
		}

		System.out.println("\n난수 " + num + "개의 합은 " + sum);
		scan.close();
	}
}