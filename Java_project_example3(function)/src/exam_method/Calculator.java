package exam_method;

public class Calculator {
	public int plus(int x, int y) {
		int result = x + y;

		return result;
	}

	public int minus(int x, int y) {
		int result = x - y;

		return result;
	}

	public int multiply(int x, int y) {
		int result = x * y;

		return result;
	}

	public double divide(int x, int y) {
		double result = 0;

		if (y == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
		} else {
			result = (double) x / (double) y;
		}

		return result;
	}

	public int add(int[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;

	}
}
