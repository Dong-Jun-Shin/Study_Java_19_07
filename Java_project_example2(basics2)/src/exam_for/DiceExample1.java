package exam_for;

/*
 * �� ���� �ֻ����� ������ �� ������ ���� (��1, ��2) ���·� ����ϰ�,
 * ���� ���� 5�� �ƴϸ� ��� �ֻ����� ������, ���� ���� 5�̸� ������ ���ߴ�
 * �ڵ带 �ۼ��غ�����.
 * ���� ���� 5�� �Ǵ� ������ (1, 4), (4, 1), (2,3), (3,2)�̴�.
 */

public class DiceExample1 {
	public static void main(String[] args) {
		int n1, n2;
		int n_sum = 0;

		do {
			n1 = (int)((Math.random()*6)+1);
			n2 = (int)((Math.random()*6)+1);
			n_sum = n1 + n2;
			
		}while (n_sum != 5);
		
		System.out.printf("%d, %d", n1, n2);
	}
}
