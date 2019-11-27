package exam_lambda;

interface Calculator {
	int func();
}

public class LambdaExample08 {
	static int num1 = 10;
	int num2 = 20;

	public static void main(String[] args) {
		LambdaExample08 test = new LambdaExample08();
//		 int num3 = 30;

		//하나의 클래스를 정의하는 느낌, 내부클래스와 비슷 (Lambda08.스택 != Calculator.스택)
		Calculator calc = () -> {
			int num4 = 40;
			LambdaExample08.num1++;
			test.num2++;
			// 오류발생
//			num3++;
			num4++;
			// 가능
//			return num3;
			return num4;
		};
		
		System.out.println("실행결과: " + calc.func());
	}
}
