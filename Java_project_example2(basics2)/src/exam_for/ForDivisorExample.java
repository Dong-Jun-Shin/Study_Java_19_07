package exam_for;

import java.util.Scanner;

public class ForDivisorExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("���� ������ �Է��Ͻÿ�: ");
		int num = scan.nextInt();

		System.out.println(num + "�� ����� ������ �����ϴ�.");
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
			}
		}
		scan.close();
	}
}
