package exam_array;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] numbers = new int[] { 10, 20, 30 };
		// int[] numbers = {10,20,30};

		// �迭�� �� ���(1)
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		// �迭�� �� ���(2)
		for (int num : numbers) {
			System.out.println(num);
		}

		int[] array = new int[] { 10, 20, 30, 40, 50 };
		System.out.println("array�� ����� ����= " + array.length);

		for (int i = 0; i < array.length; i++) {
			System.out.printf("%5d", array[i]);
		}
		
		// �迭�� ���Ҵ� �� ���
		array = new int[] { 100, 200, 300 };
		
		System.out.println("\nar�� ���Ҵ�� ����� ���� = " + array.length);
		
		for(int i = 0; i< array.length; i++) {
			System.out.printf("%5d", array[i]);
		}
	}
}
