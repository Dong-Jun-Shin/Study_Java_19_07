package exam_operation;

public class ConditionalOperationExample {
	public static void main(String[] args) {

		int x = 100;
		int y = 200;

		int result = ((x > y) ? x : y);

		System.out.print("�� ��(100�� 200) �߿��� �ִ밪 : " + result);

		char even = '¦';
		char odd = 'Ȧ';

		result = ((result % 2 == 0) ? even : odd);
		System.out.println(", (" + (char)result + ")");
		
		//TODO ���� ���ϱ�
	}
}