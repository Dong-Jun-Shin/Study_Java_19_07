package exam_array_2Dimension;

import tool.examArray2D;
/*
 * 2����(3X3) �迭�� ������ �����Ͽ� (1~9) ����ϰ��� �Ѵ�.
 * �׸��� �� ��� ���� ��ġ�� �ٲپ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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





















