package exam_array_2Dimension;

public class Array2DTest {
	public static void main(String[] args) {
		// 2차원 배열
		int[][] arr1 = new int[2][3];

		System.out.println("arr1.length = " + arr1.length); // arr1의 행 개수
		System.out.println("arr1.length[0] = " + arr1[0].length); // arr1의 0행의 열개수
		System.out.println("arr1.length[1] = " + arr1[1].length); // arr1의 1행의 열개수
		System.out.println();

		for (int i = 0; i < arr1.length; i++) {
			for (int k = 0; k < arr1[i].length; k++) {
				System.out.print("arr1[" + i + "][" + k + "]=" + arr1[i][k] + " ");
			}
			System.out.println();
		}
		System.out.println();

		// 2차원 배열 - 행에 따른 열을 각각 설정
		int[][] arr3 = new int[2][];
		arr3[0] = new int[2];
		arr3[1] = new int[3];

		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.print("arr2[" + i + "][" + j + "]=" + arr3[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		// 2차월 배열 - 행에 따른 열을 각각 설정 및 초기화
		int[][] myArrays = new int[3][];
		myArrays[0] = new int[] { 1, 2, 3 };
		myArrays[1] = new int[] { 5, 4, 3, 2, 1 };
		myArrays[2] = new int[] { 11, 22 };

		for (int i = 0; i < myArrays.length; i++) {
			for (int j = 0; j < myArrays[i].length; j++) {
				System.out.printf("%5d", myArrays[i][j]);
			}
		}
		System.out.println("\n");

		//2차원 배열
		int[][] arr4 = {{95, 80},{92, 96, 80}};
		for(int i =0; i<arr4.length; i++) {
			for(int j=0; j<arr4[i].length; j++) {
				System.out.println("arr4[" + i + "][" + j + "]=" + arr4[i][j] + " ");
			}
		}
		System.out.println();
		
		
		// 다차원 배열
		int[][][][][][][][] my_arr = new int[1][2][3][4][5][6][7][8];
		int num = 1;
		
		for (int a = 0; a < my_arr.length; a++) {
			for (int b = 0; b < my_arr[a].length; b++) {
				for (int c = 0; c < my_arr[a][b].length; c++) {
					for (int d = 0; d < my_arr[a][b][c].length; d++) {
						for (int e = 0; e < my_arr[a][b][c][d].length; e++) {
							for (int f = 0; f < my_arr[a][b][c][d][e].length; f++) {
								for (int g = 0; g < my_arr[a][b][c][d][e][f].length; g++) {
									for (int h = 0; h < my_arr[a][b][c][d][e][f][g].length; h++) {
										my_arr[a][b][c][d][e][f][g][h] = num;
										num++;
										System.out.println("my_arr[" + a + "][" + b + "][" + c + "][" + d + "][" + e
												+ "][" + f + "][" + g + "][" + h + "]=" + my_arr[a][b][c][d][e][f][g][h]
												+ " ");										
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println();
		
		int result = 2; //배열의 행의 개수
		// i시작 = 열 개수, i범위 = 행열을 제외한 배열차원의 개수 (순차적으로 배열차원의 수가 늘어날 때)
		for(int i=3; i<4; i++) {
			result *= i;
			System.out.print(result+ " ");
		}
	}
}
