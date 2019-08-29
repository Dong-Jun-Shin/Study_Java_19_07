package exam_array_2Dimension;

import tool.examArray2D;

/*
 * ������ �迭�� ����, ����, �밢���� �� ���Ͽ� ����Ͻÿ�.
 */
public class Array2DSum {
	public static void main(String[] args) {
//		int[][] arr = new int[5][5];
//		examArray2D.insert(arr);
		
		int[][] arr= {
				{10,10,10,10,0},
				{30,30,30,30,0},
				{40,40,40,40,0},
				{50,50,50,50,0},
				{0,0,0,0,0}
		};
		
		examArray2D.show(arr, "before");
		arr = examArray2D.arraySum(arr, "rows");
		arr = examArray2D.arraySum(arr, "columns");
		arr = examArray2D.arraySum(arr, "diagonal");
		examArray2D.show(arr, "after");
	}
}
