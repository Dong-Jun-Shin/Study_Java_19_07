package exam_operation;
	
public class LogicalOperator {
	public static void main(String[] args) {
		int x = 3;
		int y = 4;

		System.out.println((x == 3) && (y == 7));
		System.out.println((x == 3) || (y == 4));

		//�� ������ �켱 ���� ��, ������ �Ǵ��Ѵ�.
		//�� �������� ��� ���� ��, ���� ������ ������� �ʴ´�. (���� if ���)
		//					False      Not Execute
		//                 4 == 3
		boolean result = (++x == 3) && (y++ == 7);

		System.out.println("x = " + x + ", y = " + y);
		System.out.println("result = " + result);

		//�� �������� ��� ���� ��, ���� ������ ������� �ʴ´�. (���� if ���)
		//			True       Not Execute
		//		   4 == 4
		result = (x++ == 4) || (++y == 7);

		System.out.println("x = " + x + ", y = " + y);
		System.out.println("result = " + result);

	}
}
