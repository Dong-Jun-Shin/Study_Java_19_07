package exam_for;

public class ForExample {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		// 1부터 100까지의 합
		int sum = 0;
		for (int i = 1; i <= 100; i++)
			sum += i;
		System.out.printf("1부터 100까지의 정수의 합 = %d\n", sum);
		System.out.println();

		// for문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 구하는 코드를 작성해보세요.
		sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("1부터 100까지 중 3의 배수 합 : " + sum);
		System.out.println();

		// 1부터 n까지의 팩토리얼
		/*
		 * 팩토리얼 값이란 1부터 어떤 양의 정수 n까지의 정수를 모두 곱한 것을 말하며 n!로 나타낸다.
		 *  ex) n! = 1 x 2 x 3 x ... x n
		 */
		int num = 0;
		long f_sum = 1;

		for (int i = 2; i <= num; i++) {
			f_sum = f_sum * i;
		}

		System.out.println(num + "! = " + f_sum);
	}
}
