package exam_lab;

import java.util.Scanner;

public class Page96 {
	public static void main(String[] args) {
		double radius, area, PI;
		Scanner scan = new Scanner(System.in);

		System.out.println("�������� ���̸� �Է����ּ���.");
		radius = scan.nextDouble();

		PI = 3.14;
		area = PI * radius * radius;

		System.out.println("���� ������ " + area);
		
		scan.close();
	}
}
