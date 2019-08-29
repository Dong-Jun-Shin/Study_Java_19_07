package exam_operation;

public class ComparisonOperator {
	public static void main(String[] args) {
		int x = 3;
		int y = 4;

		System.out.println("x == y	|" + (x == y));
		System.out.println("x != y	|" + (x != y));

		System.out.println("x > y	|" + (x > y));
		System.out.println("x < y	|" + (x < y));
		System.out.println("x <= y	|" + (x <= y));

		char char1 = 'A';
		char char2 = 'B';
		boolean result = (char1 < char2);
		System.out.println("result  |" + result);
	}
}
