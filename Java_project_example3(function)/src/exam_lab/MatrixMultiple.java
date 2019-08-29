package exam_lab;

/*
 	2차원 배열 array1(2,4)와 array2(4,3)이 주어졌을 때 이 두 행렬의 곱을 구하여 그 곱의 합을 
 	multi(2,3)에 저장하는 코드를 실행 결과와 같이 출력하시오.

	[조건]
	- 출력 결과는 다음과 같다
	76 164 100
	17 94 69
	
	- 주어진 배열 변수는 다음을 사용한다.
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
