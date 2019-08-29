package exam_int;

public class Ex_3_5 {
	public static void main(String[] args) {
		int x, y;

		x = 5;
		y = 2;

		x = x + 1;
		y = y - 1;

		System.out.println(x + ", " + y);

		// f  -> format
		// %d -> Decimal (10진법)
		// \  -> Escape sequency (순서, 연속된 사건)
		// \n -> New Line
		System.out.printf("x = %d\ny = %d\n", x, y);
	}
}