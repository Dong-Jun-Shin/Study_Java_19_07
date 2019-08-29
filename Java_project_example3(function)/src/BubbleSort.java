public class BubbleSort {
	public static void main(String[] args) {
		// Bubble Sort
		// 앞과 뒤를 비교해서 자리바꾸며 끝까지 진행을 반복
		// 66번 반복 (

		int a[] = { 1, 7, 5, 2, 3, 9, 20, 4, 13, 8, 15, 6, 0, 33, 29, 50, 17, 3, 1 };
		int temp;

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
