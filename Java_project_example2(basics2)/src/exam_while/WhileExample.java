package exam_while;

public class WhileExample {
	public static void main(String[] args) {

		// while문을 이용한 5번 출력과 증가를 반복하기
		// 1번째 방법 (식에서 조건이 틀릴 때, 멈추기)
		int i = 1;
		System.out.println("정수");
		while (i <= 5) {
			System.out.println(i + " ");
			i++;
		}
		System.out.println();

		// 2번째 방법 (식에 true를 넣고, break로 멈추기)
		i = 1;
		System.out.println("정수: ");
		while (true) {
			System.out.println(i + " ");
			i++;
			if (i > 5)
				break;
		}
		System.out.println();

		// 1부터 100까지의 합
		int num = 1, sum = 0;
		while (num <= 100) {
			sum += num;
			num++;
		}
		System.out.println("1부터 100까지의 합 = " + sum + "입니다.");
		System.out.println();

		// 10부터 1까지의 출력
		num = 10;
		sum = 0;

		System.out.println("10부터 1까지의 출력");
		while (num > 0) {
			System.out.println(num);
			num--;
		}
		System.out.println();

		// 1에서 100까지 수 중에서 짝수의 합과 홀수의 합을 출력하기
		num = 1;
		int even = 0, odd = 0;

		while (num < 101) {
			if (num % 2 == 0) {
				even += num;
				num++;
			} else {
				odd += num;
				num++;
			}

		}
		System.out.println("1부터 100까지의 홀수합 = " + odd + "입니다.");
		System.out.println("1부터 100까지의 짝수합 = " + even + "입니다.");
		System.out.println();

		
		// 1부터 30까지의 7의 배수를 출력, 7의 배수의 합, 7의 배수의 개수를 출력하기
		int print = 1, cnt = 0;
		sum = 0;

		while (print < 31) {
			if (print % 7 == 0) {
				System.out.println("7의 " + (cnt+1) + "번째 수 : " + print);
				sum += print;
				cnt++;
			}
			print++;
		}
		System.out.println("-------------------");
		System.out.println("7의 배수의 합 : " + sum);
		System.out.println("7의 배수의 개수 : " + cnt);
	}
}
