package exam_lab;

import java.util.Scanner;

public class Page137 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i, num, sum = 0;

		System.out.println("������ ���� : ");
		num = scan.nextInt();

		for (i = 0; i < num; i++) {
			sum = sum + (int) ((Math.random() * 100) + 1);
		}

		System.out.println("\n���� " + num + "���� ���� " + sum);
		scan.close();
	}
}