package exam_for;

public class ForOverLapEx {
	public static void main(String[] args) {

		// 1 2 3 4 5 �ٹٲ� �ؼ� 5�� ���
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print((j + 1) + " ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");

		// ���� �� ������ 1���� ����
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print((j + 1) + " ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");

		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print((j + 1) + " ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");

		// ���� �� ������ 1���� ���ϱ�
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((j + 1) + " ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");

		// ���� �ٷ� ������ ���� ���ڸ� �߰��ؼ� �̵�
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					System.out.print((k + j + 1) + " ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
		System.out.println("--------------------");
	}
}
