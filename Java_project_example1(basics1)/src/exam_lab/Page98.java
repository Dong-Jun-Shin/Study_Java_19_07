package exam_lab;

import java.util.Scanner;

public class Page98 {
	public static void main(String[] args) {
		double w, h, area, perimeter;
		Scanner scan = new Scanner(System.in);

		System.out.print("�簢���� ���θ� �Է��Ͻÿ� : ");
		w = scan.nextDouble();

		System.out.print("�簢���� ���θ� �Է��Ͻÿ� : ");
		h = scan.nextDouble();

		area = w * h;
		perimeter = 2 * (w + h);

		System.out.println("�簢���� ���̴� " + area);
		System.out.println("�簢���� �ѷ��� " + perimeter);
		
		scan.close();
	}
}
