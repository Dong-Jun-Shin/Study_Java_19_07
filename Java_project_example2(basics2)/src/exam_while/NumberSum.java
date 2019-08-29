package exam_while;

import java.util.Scanner;

/*
 * 사용자로부터 5개의 정수를 읽어서 합과 평균값을 계산하여 출력하는 프로그램을 작성하라.
 */
public class NumberSum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n, i;
		int sum = 0;
		float avg = 0;
		int num_amount;
		
		System.out.println("몇가지의 수를 더하겠습니까? ");
		num_amount = scan.nextInt();
		System.out.println("--------------------");
		
		for(i = 0; i < num_amount; i++) {
			System.out.println((i+1) + "번째 수를 입력해주세요. ");
			n = scan.nextInt();
			sum = sum + n;
			System.out.println("--------------------");
		}
		//계산 시, int로 계산하고 double로 바뀌면 소수점 이하는 잘린다.
		avg = (float)sum / i;
		
		System.out.printf("%d번째 수까지의 합: %d, 평균: %.2f", i, sum, avg);
		/*
		System.out.println(i+"번째 수까지의 합 : "+ sum);
		System.out.println(i+"번째 수까지의 평균 : "+ avg);
		*/
		
		scan.close();
	}
}
