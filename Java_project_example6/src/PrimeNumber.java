import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		// 소수 판별
		Scanner scan = new Scanner(System.in);
		int num;

		// num = scan.nextInt();
		// p^2 > 해당 정수까지
		
		for (num = 1; num <= 100; num++) {
			if (num < 10) {
				if (num == 2 || num == 3 || num == 5  || num == 7) {
					System.out.println(num + "= 소수");
					System.out.println();
				} else {
					System.out.println(num + "= 소수가 아닙니다.");
				}
			}else {
				if (!(num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0)) {
					System.out.println(num + "= 소수");
					System.out.println();
				} else {
					System.out.println(num + "= 소수가 아닙니다.");
				}
			}
		}
		scan.close();
	}
}