package exam_array_2Dimension;

/*
 * ������ ���� ���� �ʱⰪ���� ���� {95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88}
 * 2���� �迭�� �����Ѵ�. (array)
 * ��ü �׸��� �հ� ��հ��� ����ϵ��� ���α׷��� �ۼ��� �ּ���.
 */
public class TwoDimension {
	public static void main(String[] args) {
		int[][] arr = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int total = 0, cnt = 0;
		double avg = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
				cnt++;
			}
		}
		avg = (double)total / cnt;

		System.out.println("�迭�� ���� : " + cnt);
		System.out.println(total + " <-�հ� | ��� -> " + avg);

	}
}
