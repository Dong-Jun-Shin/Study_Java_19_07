package exam_for;

public class ForOverLapEx {
	public static void main(String[] args) {

		// 1 2 3 4 5 줄바꿈 해서 5줄 출력
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print((j + 1) + " ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");

		// 다음 줄 갈수록 1개씩 빼기
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print((j + 1) + " ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");

		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print((j + 1) + " ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");

		// 다음 줄 갈수록 1개씩 더하기
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((j + 1) + " ");
			}
			System.out.println("");
		}
		System.out.println("--------------------");

		// 다음 줄로 갈수록 다음 숫자를 추가해서 이동
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					System.out.print((k + j + 1) + " ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
		System.out.println("--------------------");
	}
}
