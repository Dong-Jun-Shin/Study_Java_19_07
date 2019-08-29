package exam_operation;
// Unary 단항
public class UnaryOperator {
	public static void main(String[] args) {
		// 증감 연산자는 처리되는 그 때를 기준으로 전, 후를 따져 계산된다.		
		int x = 1;
		int y = 1;

		System.out.println("변경 전 변수값 출력");
		System.out.println("x = " + x + ", y = " + y);

		System.out.println("증가 연산자 후 변수값 출력");
		System.out.println("x = " + (++x) + ", y = " + (y++));

		int nextx = ++x; //(x = x + 1) 대입 전 x증가
		int nexty = y++; //(x = x + 1) 대입 후 y증가
		
		System.out.println("증가 연산자 후 변수값 출력");
		System.out.println("x = " + x + ", y = " + y);
		System.out.println("nextx = " + nextx + ", nexty = " + nexty);
	
	}
}
