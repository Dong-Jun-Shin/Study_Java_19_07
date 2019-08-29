package exam_for;

public class ForExample {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		// 1���� 100������ ��
		int sum = 0;
		for (int i = 1; i <= 100; i++)
			sum += i;
		System.out.printf("1���� 100������ ������ �� = %d\n", sum);
		System.out.println();

		// for���� �̿��ؼ� 1���� 100������ ���� �߿��� 3�� ����� ������ ���ϴ� �ڵ带 �ۼ��غ�����.
		sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("1���� 100���� �� 3�� ��� �� : " + sum);
		System.out.println();

		// 1���� n������ ���丮��
		/*
		 * ���丮�� ���̶� 1���� � ���� ���� n������ ������ ��� ���� ���� ���ϸ� n!�� ��Ÿ����.
		 *  ex) n! = 1 x 2 x 3 x ... x n
		 */
		int num = 0;
		long f_sum = 1;

		for (int i = 2; i <= num; i++) {
			f_sum = f_sum * i;
		}

		System.out.println(num + "! = " + f_sum);
	}
}
