package exam_operation;
	
public class LogicalOperator {
	public static void main(String[] args) {
		int x = 3;
		int y = 4;

		System.out.println((x == 3) && (y == 7));
		System.out.println((x == 3) || (y == 4));

		//앞 조건은 우선 실행 후, 조건을 판단한다.
		//앞 조건으로 결과 도출 시, 뒤의 조건은 실행되지 않는다. (이중 if 방식)
		//					False      Not Execute
		//                 4 == 3
		boolean result = (++x == 3) && (y++ == 7);

		System.out.println("x = " + x + ", y = " + y);
		System.out.println("result = " + result);

		//앞 조건으로 결과 도출 시, 뒤의 조건은 실행되지 않는다. (이중 if 방식)
		//			True       Not Execute
		//		   4 == 4
		result = (x++ == 4) || (++y == 7);

		System.out.println("x = " + x + ", y = " + y);
		System.out.println("result = " + result);

	}
}
