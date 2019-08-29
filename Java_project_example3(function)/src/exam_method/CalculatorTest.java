package exam_method;

public class CalculatorTest {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		int[] arr = { 2, 5, 6, 7, 7, 5, 3, 3, 45, 5 };

		int x = 10;
		int y = 7;

		System.out.println("\t+\t" + cal.plus(x, y));
		System.out.println("\t-\t" + cal.minus(x, y));
		System.out.println("\t*\t" + cal.multiply(x, y));
		System.out.println("\t/\t" + cal.divide(x, y));
		System.out.println("\tarrSum\t" + cal.add(arr));
	
	}
}
