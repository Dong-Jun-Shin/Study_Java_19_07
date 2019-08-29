package exam_lab;

import java.util.Scanner;

public class Page96 {
	public static void main(String[] args) {
		double radius, area, PI;
		Scanner scan = new Scanner(System.in);

		System.out.println("반지름의 길이를 입력해주세요.");
		radius = scan.nextDouble();

		PI = 3.14;
		area = PI * radius * radius;

		System.out.println("원의 면적은 " + area);
		
		scan.close();
	}
}
