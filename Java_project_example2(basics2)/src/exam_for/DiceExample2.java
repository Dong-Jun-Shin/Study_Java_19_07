package exam_for;

/*
 * 2���� �ֻ����� ������ ������ �ִٰ� ��������.
 * 2�� �ֻ����� ���� 6�� �Ǵ� ���� ����� ������?
 * 6�� �Ǵ� ��� ����� ���� ����ϴ� ���α׷��� �ۼ��غ���.
 * (1,5)
 * ...
 */
public class DiceExample2 {
	public static void main(String[] args) {
		int n1, n2;
		n1 = (int) ((Math.random() * 6) + 1);
		n2 = (int) ((Math.random() * 6) + 1);

		while (true) {
			if (n1 + n2 == 6) {
				System.out.println(n1 + ", " + n2);
			}
		}
	}
}
