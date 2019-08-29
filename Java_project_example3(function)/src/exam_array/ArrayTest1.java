package exam_array;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] numbers = new int[] { 10, 20, 30 };
		// int[] numbers = {10,20,30};

		// 배열의 값 출력(1)
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		// 배열의 값 출력(2)
		for (int num : numbers) {
			System.out.println(num);
		}

		int[] array = new int[] { 10, 20, 30, 40, 50 };
		System.out.println("array의 요소의 개수= " + array.length);

		for (int i = 0; i < array.length; i++) {
			System.out.printf("%5d", array[i]);
		}
		
		// 배열을 재할당 후 출력
		array = new int[] { 100, 200, 300 };
		
		System.out.println("\nar의 재할당된 요소의 개수 = " + array.length);
		
		for(int i = 0; i< array.length; i++) {
			System.out.printf("%5d", array[i]);
		}
	}
}
