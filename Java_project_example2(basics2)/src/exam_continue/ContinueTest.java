package exam_continue;

public class ContinueTest {
	public static void main(String[] args) {
		// 1~10까지 중 홀수를 출력
		int a = 0;
		do {
			a++;
			if (a % 2 == 0) {
				continue;
			}
			System.out.printf("%5d", a);
		} while (a < 10);
		System.out.println();

		// 1~10까지 중 짝수를 출력
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.printf("%5d", i);
		}
	}
}
