package exam_exception;

public class DivideByZeroTest {
	public static void main(String[] args) {
		//0으로 나눈 상황
		int x = 1;
		int y = 0;
		int result = 0;

		try {
			result = x / y;
			System.out.println("result:" + result);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("프로그램은 계속 진행됩니다.");

		//배열 범위 넘어섬
		int[] array = new int[10];
		int result1 = 0;
		for (int i = 0; i < 10; i++) {
			array[i] = i;
		}

		try {
			result1 = array[10];
			System.out.println("result:" + result1);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("프로그램은 계속 진행됩니다.");
		
	}
}
