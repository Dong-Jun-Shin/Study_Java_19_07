package exam_if;

import java.util.Scanner;

public class IfExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �˷��帰 �� ������ Ȧ¦ ���θ� �˷��帳�ϴ�. �Է����ּ���.");
		int number = scan.nextInt();
		
		//���밪
		System.out.println("\n�Է��� ���� �ʱⰪ : " + number);

		System.out.println(number + "�� ���밪�� ");

		if (number < 0) {
			number = -number;
		}
		System.out.println(number + "�Դϴ�.");

		//Ȧ¦
		System.out.println("\n�Է��� ���� �ʱⰪ : " + number);

		if (number % 2 == 0) {
			System.out.println("�Է��� " + number + "�� ¦���Դϴ�.");
		}else {
			System.out.println("�Է��� " + number + "�� Ȧ���Դϴ�.");
		}
		
		scan.close();
		
	}
}
