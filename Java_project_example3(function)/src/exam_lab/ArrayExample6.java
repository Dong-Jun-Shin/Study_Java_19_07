package exam_lab;

/*
 *  ������ �迭�� ���Ե� ������ �ش��ϴ� ���� �׷����� ������ ��������Ͻÿ�.
 *  [���� ���]
 *  
 *  90�� : ������������������
 *  20�� : ����
 *  50�� : ����������
 *  70�� : ��������������
 *  65�� : ������������
 *  90�� : ������������������
 * 100�� : ��������������������
 *  43�� : ��������
 *  55�� : ����������
 *  87�� : ����������������
 */
public class ArrayExample6 {
	public static void main(String[] args) {
		String[] qtyScore = new String[10];
		int[] score = { 90, 20, 50, 70, 65, 90, 100, 43, 55, 87 };

		
		for (int i = 0; i < qtyScore.length; i++) {
			qtyScore[i] = "";
			for (int j = 0; j < (score[i] / 10); j++) {
				qtyScore[i] += '��';
			}
		}
		
		for(int i = 0; i < qtyScore.length; i++) {
			System.out.printf("%3d �� : %s\n", score[i], qtyScore[i]);
		}
	}
}
