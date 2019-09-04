package exam_array;

/*
 * 배열을 선언한다. 그 배열을 출력할 수 있는 메소드를 정의하여 출력하도록 프로그램을 작성한다.
 */

public class ArrayTransmission {
	private static void printData(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}
	
	private static int[] getData() {
		int[] testData = {10,20,30,40,50};
		return testData;
	}
	
	public static void main(String[] args) {
		int[] array;
		array = getData();
		printData(array);
	}
}
