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
		// %d -> Decimal (10����)
		// \  -> Escape sequency (����, ���ӵ� ���)
		// \n -> New Line
		System.out.printf("x = %d\ny = %d\n", x, y);
	}
}