import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		// �Ҽ� �Ǻ�
		Scanner scan = new Scanner(System.in);
		int num;

		// num = scan.nextInt();
		// p^2 > �ش� ��������
		
		for (num = 1; num <= 100; num++) {
			if (num < 10) {
				if (num == 2 || num == 3 || num == 5  || num == 7) {
					System.out.println(num + "= �Ҽ�");
					System.out.println();
				} else {
					System.out.println(num + "= �Ҽ��� �ƴմϴ�.");
				}
			}else {
				if (!(num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0)) {
					System.out.println(num + "= �Ҽ�");
					System.out.println();
				} else {
					System.out.println(num + "= �Ҽ��� �ƴմϴ�.");
				}
			}
		}
		scan.close();
	}
}
