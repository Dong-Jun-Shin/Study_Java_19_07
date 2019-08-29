package exam_array_2Dimension;

import tool.examArray2D;
/*
 * 2차원(3X3) 배열에 내용을 저장하여 (1~9) 출력하고자 한다.
 * 그리고 그 행과 열의 위치를 바꾸어서 출력하는 프로그램을 작성하시오.
 */
public class RowColumnExchange {
	public static void main(String[] args) {
		int[][] arr = new int[3][3];

		arr = examArray2D.logic(arr, "rows");
		examArray2D.show(arr, "before");

		arr = examArray2D.logic(arr, "columns");
		examArray2D.show(arr, "after");
	}
}





















