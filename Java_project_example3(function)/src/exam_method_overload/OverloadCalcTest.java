package exam_method_overload;

public class OverloadCalcTest {
	public static void main(String[] args) {
		OverloadCalc calc = new OverloadCalc();
		
		System.out.println("int");
		System.out.println(calc.plus(10, 20));
		System.out.println();
		
		// 'f'생략시, 실수 기본형인 double형으로 로딩된다.
		System.out.println("float");
		System.out.println(calc.plus(10.99f, 20.88f));
		System.out.println();
		
		System.out.println("double");
		System.out.println(calc.plus(10.99, 20.88));
		System.out.println();
		
		System.out.println("가변 길이 매개변수");
		System.out.println(calc.plus(10, 20, 10, 40, 30));
		System.out.println();
		
		int[] v = {10, 20, 10, 40, 30};
		System.out.println("시작주소를 갖고 있는 배열변수 -> 매개변수");
		System.out.println(calc.plus(v));
		System.out.println();
		
		System.out.println("배열선언을 하고 주소를 -> 매개변수");
		System.out.println(calc.plus(new int[] {10, 20, 10, 40, 30}));
		System.out.println();
	}
}
