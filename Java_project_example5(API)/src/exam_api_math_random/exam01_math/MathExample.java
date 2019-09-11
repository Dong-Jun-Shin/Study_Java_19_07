package exam_api_math_random.exam01_math;

public class MathExample {
	public static void main(String[] args) {
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1(Math.abs)=" + v1);
		System.out.println("v2(Math.abs)=" + v2);
		
		double v3 = Math.ceil(5.1); // 매개변수 값을 올림함.
		System.out.println("v3(Math.ceil)=" + v3);
		
		double v4 = Math.floor(5.9); // 매개변수 값을 내림함.
		System.out.println("v4(Math.floor)=" + v4);
		
		int v5 = Math.max(5,  9); //최대값을 구함
		double v6 = Math.max(5.3,  2.5);
		System.out.println("v5(Math.max)=" + v5);
		System.out.println("v6(Math.max)=" + v6);
		
		int v9 = Math.min(5, 9); //최소값을 구함
		double v10 = Math.min(5.3,  2.5);
		System.out.println("v3(Math.min)=" + v9);
		System.out.println("v3(Math.min)=" + v10);
		
		long v12 = Math.round(5.3); //소수점 첫째 자리에서 반올림함.
		long v13 = Math.round(5.7);
		System.out.println("v12(Math.round)=" + v12);
		System.out.println("v13(Math.round)=" + v13);
	}
}
