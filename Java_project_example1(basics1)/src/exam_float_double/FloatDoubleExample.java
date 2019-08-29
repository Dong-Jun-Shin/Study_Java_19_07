package exam_float_double;

public class FloatDoubleExample {
	public static void main(String[] args) {
		// int var = 3.14;		
		//변수 - int, 리터럴 - double

		double var2 = 3.14;
		float var3 = 3.14F;

		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);

		// e(지수 표기) 사용하기
		int var4 = 3000000;	// 3000000
		double var5 = 3e6;	// 3000000.0
		float var6 = 3e6F;	// 3000000.0
		double var7 = 2e-3;	// 0.002
		System.out.println("var4: " + var4);
		System.out.println("var5: " + var5);
		System.out.println("var6: " + var6);
		System.out.println("var7: " + var7);
	}
}
