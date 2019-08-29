package exam_lab;

import java.util.Scanner;

public class Page98 {
	public static void main(String[] args) {
		double w, h, area, perimeter;
		Scanner scan = new Scanner(System.in);

		System.out.print("사각형의 가로를 입력하시오 : ");
		w = scan.nextDouble();

		System.out.print("사각형의 가로를 입력하시오 : ");
		h = scan.nextDouble();

		area = w * h;
		perimeter = 2 * (w + h);

		System.out.println("사각형의 넓이는 " + area);
		System.out.println("사각형의 둘레는 " + perimeter);
		
		scan.close();
	}
}
