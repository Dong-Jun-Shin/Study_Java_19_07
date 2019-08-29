package exam_for;

//2단부터 9단까지 출력
public class ForMulTableExample {
	public static void main(String[] args) {
		// 세로 출력
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + " = " + i * j);
			}
			System.out.println();
		}

		// 가로 출력
		for (int j = 1; j < 10; j++) {
			for (int i = 2; i < 10; i++) {
				System.out.printf("%d * %d = %2d  ", i, j, i * j);
			}
			System.out.println();
		}
		
	}
}