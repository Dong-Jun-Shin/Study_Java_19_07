package exam_operation;
// Unary ����
public class UnaryOperator {
	public static void main(String[] args) {
		// ���� �����ڴ� ó���Ǵ� �� ���� �������� ��, �ĸ� ���� ���ȴ�.		
		int x = 1;
		int y = 1;

		System.out.println("���� �� ������ ���");
		System.out.println("x = " + x + ", y = " + y);

		System.out.println("���� ������ �� ������ ���");
		System.out.println("x = " + (++x) + ", y = " + (y++));

		int nextx = ++x; //(x = x + 1) ���� �� x����
		int nexty = y++; //(x = x + 1) ���� �� y����
		
		System.out.println("���� ������ �� ������ ���");
		System.out.println("x = " + x + ", y = " + y);
		System.out.println("nextx = " + nextx + ", nexty = " + nexty);
	
	}
}
