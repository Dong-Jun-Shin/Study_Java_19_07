package exam_for;

//2�ܺ��� 9�ܱ��� ���
public class ForMulTableExample {
	public static void main(String[] args) {
		// ���� ���
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + " = " + i * j);
			}
			System.out.println();
		}

		// ���� ���
		for (int j = 1; j < 10; j++) {
			for (int i = 2; i < 10; i++) {
				System.out.printf("%d * %d = %2d  ", i, j, i * j);
			}
			System.out.println();
		}
		
	}
}