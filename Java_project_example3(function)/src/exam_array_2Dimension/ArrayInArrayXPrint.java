package exam_array_2Dimension;

/*
 * 이차원 배열을 이용해서 다음과 같이 출력해보자.
 * 1 0 0 0 1  (1.1) (1.5)
 * 0 1 0 1 0  (2.2) (2.4)
 * 0 0 1 0 0  (3.3)
 * 0 1 0 1 0  (4.4) (4.2)
 * 1 0 0 0 1  (5.5) (5.1) 
 */
public class ArrayInArrayXPrint {
	public static void main(String[] args) {
		int array[][] = new int[5][5];

		//세번째
		for (int i = 0; i < array.length; i++) {
			int r = array.length - 1;
			for (int j = 0; j < array[i].length; j++) {
				if (i == j) {
					array[i][j] = 1;
					array[i][r - i] = 1;
				}
			}
		}
		
		/*
		// 첫번째 두번째
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i == j || i == 4 - j) {
					array[i][j] = 1;
				}
			}
		}


		//첫번째
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i == j) {
					array[i][j] = 1;
				}

			}
		}

		//두번째
		for (int i = 0; i < array.length; i++) {
			for (int j = 4 - i; j < array[i].length-i; j++) {
				if (i == 2) {
					continue;
				}
				array[i][j] = 1;
			}
		}
		 */
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
