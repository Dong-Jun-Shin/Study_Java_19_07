package first_exam;

/**
 * ���� ���� �μ��� ���� ���ϴ� ���α׷�.
 */

public class Add {
	public static void main(String[] args) {
		int x, y, temp; // ù��° ������ ������ ����

		x = 5;
		y = 3;

		System.out.println("�ٲٱ� ��");
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		temp = x;
		x = y;
		y = temp;

		System.out.println("�ٲٱ� ��");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
}
