package exam_method_overload;

public class OverloadCalc {
	public int plus(int a, int b) {
		System.out.println("plus(int a, int b)");

		return a + b;
	}

	public float plus(float a, float b) {
		System.out.println("plus(float a, float b)");

		return a + b;
	}

	public double plus(double a, double b) {
		System.out.println("plus(double a, double b)");

		return a + b;
	}

	public int plus(int ... a) {
		System.out.println("plus(int a, int b)");
		int r = 0;
		for (int i = 0; i < a.length; i++) {
			r += a[i];
		}

		return r;
	}
	
	public int plusInt(int[] v) {
		int r = 0;
		for (int i = 0; i < v.length; i++) {
			r += v[i];
		}
		
		return r;
	}
}
