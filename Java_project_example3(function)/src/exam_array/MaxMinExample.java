package exam_array;

/*
 * ������ ���� �߿� ���� ū��, ���� ���� ���� ������ּ���.
 */
public class MaxMinExample {
	public static void main(String[] args) {
		int max = 0, min = 100;

		int[] array = { 12, 26, 68, 98, 76, 54, 8, 6, 4 };

		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
			if (min > array[i]) {
				min = array[i];
			}
		}
		
		System.out.println(max+" "+min);
	}
}
