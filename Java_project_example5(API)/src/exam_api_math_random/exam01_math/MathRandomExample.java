package exam_api_math_random.exam01_math;

import java.util.Random;

public class MathRandomExample {
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			System.out.print((random.nextInt(6) + 1) + " ");
		}
		System.out.println();

		//seed는 난수를 발생시키는 기준이다.
		//System.currentTimeMillis() (시스템의 밀리초까지 반환해준다. 코딩 소요시간 계산시 사용함)
		random = new Random(System.currentTimeMillis());
		for (int i = 0; i < 6; i++) {
			System.out.print((random.nextInt(6) + 1) + " ");
		}
		System.out.println();

	}
}