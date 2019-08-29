package exam_array;

/*
 * 다음의 정수 중에 가장 큰값, 가장 작은 값을 출력해주세요.
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
