package exam_casting;

public class CastingExample {
	public static void main(String[] args) {
		//���������� ���
		int intValue = 65;
		System.out.println((char) intValue);

		//������ int�� ����
		long longValue = 500L;
		intValue = (int) longValue;
		System.out.println(intValue);

		//�Ҽ��� �߷��� ���
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		System.out.println(intValue);

		int result;
		double resultDouble;

		// ����� �Ǽ�����, ������ int�� �Ҽ��� �߸��� ���
		result = 3 / 2;
		System.out.println(result);

		// ����� �Ǽ��̰�, ������ �Ǽ��� ���
		resultDouble = 3.0 / 2.0;
		// resultDouble = (double)3/2;
		System.out.println(resultDouble);
	}
}