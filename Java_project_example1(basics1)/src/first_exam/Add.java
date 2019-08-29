package first_exam;

/**
 * 변수 선언 두수의 합을 구하는 프로그램.
 */

public class Add {
	public static void main(String[] args) {
		int x, y, temp; // 첫번째 정수를 저장할 변수

		x = 5;
		y = 3;

		System.out.println("바꾸기 전");
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		temp = x;
		x = y;
		y = temp;

		System.out.println("바꾸기 후");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
}
