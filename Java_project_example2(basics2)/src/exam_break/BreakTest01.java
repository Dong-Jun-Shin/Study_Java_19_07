package exam_break;

public class BreakTest01 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 1)
					break;
				System.out.println("i=" + i + " j=" + j);
			}
		}
		System.out.println();

		outer: for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 1) {
					break outer;
				}
				System.out.println("i=" + i + " j=" + j);
			}
		}
	}
}
