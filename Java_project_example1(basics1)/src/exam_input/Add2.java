package exam_input;

import java.util.Scanner;

public class Add2 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int x;
		int y;
		int sum;

		System.out.println("ù��° ���ڸ� �Է��Ͻÿ�: ");
		x = scan.nextInt();

		System.out.println("�ι�° ���ڸ� �Է��Ͻÿ�: ");
		y = scan.nextInt();

		sum = x + y;

		System.out.println("�� ���� �� : " + sum);

		scan.close();
	}
}
