public class UndefinedSort {
	public static void main(String[] args) {
		// ���� ���� ���� ���ؼ� ���� ������ �ͼ� ����
		// 25�� �ݺ� (������ ���� ���� ���� �˻縦 ����.)
		
		int x[] = {21, 13, 6, 2, 20, 26, 3, 10, 23, 5, 4, 9, 11, 24, 16, 8, 25, 12, 27, 15, 7, 17, 1, 22, 19, 14, 18};
		int leng = x.length;
		int temp;

		for (int i = 0; i < x.length - 1; i++) {
			for (int j = 0; j < leng - 1; j++) {
				if (x[leng - 1] < x[j]) {
					temp = x[leng - 1];
					x[leng - 1] = x[j];
					x[j] = temp;
				}
			}
			leng--;
		}
		
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
		
	}
}

