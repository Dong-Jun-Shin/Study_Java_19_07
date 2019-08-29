package exam_casting;

public class CastingExample {
	public static void main(String[] args) {
		//문자형으로 출력
		int intValue = 65;
		System.out.println((char) intValue);

		//범위가 int로 한정
		long longValue = 500L;
		intValue = (int) longValue;
		System.out.println(intValue);

		//소수점 잘려서 출력
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		System.out.println(intValue);

		int result;
		double resultDouble;

		// 결과는 실수지만, 변수가 int라서 소수점 잘리고 출력
		result = 3 / 2;
		System.out.println(result);

		// 결과가 실수이고, 변수도 실수라서 출력
		resultDouble = 3.0 / 2.0;
		// resultDouble = (double)3/2;
		System.out.println(resultDouble);
	}
}