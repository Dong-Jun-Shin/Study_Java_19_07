package exam_operation;

import java.util.Scanner;

/*
 * ��� 45763���� ������ ������ ���� ��� �����ڸ� �̿��Ͽ� ���� ����� ���� ����ϵ��� �ڵ带 �ۼ��Ͻÿ�.
 * ������
 * 		45763����
 * 			500�� : 00��
 * 			100�� : 0��
 * 			 50�� : 0��
 * 			 10�� : 0��
 * 			  1�� : 0���Դϴ�.
 */
public class OperationExam2 {
	public static void main(String[] args) {
		int c50000, c10000, c5000, c1000,c500, c100, c50, c10, c1;
		int money;

		System.out.println("�ݾ��� �Է����ּ���.");
		Scanner scan = new Scanner(System.in);
		money = scan.nextInt();
		
		c50000 = money / 50000;
		c10000 = money % 50000 / 10000;
		c5000 = money % 10000 / 5000;
		c1000 = money % 5000 / 1000;
		c500 = money % 1000 / 500;
		c100 = money % 500 / 100;
		c50 = money % 100 / 50;
		c10 = money % 50 / 10;
		c1 = money % 10;

		System.out.println("50000�� : " + c50000);
		System.out.println("10000�� : " + c10000);
		System.out.println("5000�� : " + c5000);
		System.out.println("1000�� : " + c1000);
		System.out.println("500�� : " + c500);
		System.out.println("100�� : " + c100);
		System.out.println("50�� : " + c50);
		System.out.println("10�� : " + c10);
		System.out.println("1�� : " + c1);
		
		scan.close();
	}
}
