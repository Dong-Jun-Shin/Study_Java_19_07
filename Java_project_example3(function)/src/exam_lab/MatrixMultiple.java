package exam_lab;

/*
 	2���� �迭 array1(2,4)�� array2(4,3)�� �־����� �� �� �� ����� ���� ���Ͽ� �� ���� ���� 
 	multi(2,3)�� �����ϴ� �ڵ带 ���� ����� ���� ����Ͻÿ�.

	[����]
	- ��� ����� ������ ����
	76 164 100
	17 94 69
	
	- �־��� �迭 ������ ������ ����Ѵ�.
	int [][] array1 = {{5,7,10,4},{2,5,3,6}};
	int [][] array2 = {{4,1,1},{-6,7,5},{9,9,4},{2,5,5}};
	int [][] multi = new int[2][3];
 */
public class MatrixMultiple {
	public static void main(String[] args) {
		int[][] array1 = { { 5, 7, 10, 4 }, { 2, 5, 3, 6 } };
		int[][] array2 = { { 4, 1, 1 }, { -6, 7, 5 }, { 9, 9, 4 }, { 2, 5, 5 } };
		int[][] multi = new int[2][3];

		for (int i = 0; i < array1.length; i++) {
			for (int n = 0; n < array2[0].length; n++) {
				for (int j = 0; j < array2.length; j++) {
					multi[i][n] += array1[i][j] * array2[j][n];
				}
			}
		}
		
		for (int i = 0; i < multi.length; i++) {
			for (int j = 0; j < multi[i].length; j++) {
				System.out.print(multi[i][j] + " ");
			}
			System.out.println();
		}
	}
}
