package exam_for;

/*
 * 1+3+5+7+...+X���� ���� ���ʷ� 500�� ���� ���� X���� X�� �� ��° ���ΰ��� ����ϴ� ���α׷��� �ۼ�
 */
public class ForExample2 {
	public static void main(String[] args) {
		int i, sum, cnt;
		sum = 0;
		cnt = 0;

		for (i = 1; i <= 500; i = i + 2) {
			sum = sum + i;
			cnt++;
		}

		System.out.println("500�� ���� �������� ��: " + sum);
		System.out.println("500�� ���� ���� X�� : " + i);
		System.out.println("X�� " + cnt + "��°");
	}
}
