package exam_while;

import java.util.Scanner;

/* 사용자로부터 수를 입력받아
 * while문을 이용한 구구단 출력 프로그램
 */
public class GugudanExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num, i=1;
		
		while (true) {
			System.out.print("구구단 중에서 출력하고 싶은 단을 입력하시오: ");
			num = scan.nextInt();

			if (num > 0 && num < 10) {
				while (i < 10) {
					System.out.println(num + "*" + i + " = " + num * i);
					i++;
				}
				break;
			} else {
				System.out.println("구구단은 1 ~ 9까지입니다. 다시 입력해주세요.");
				System.out.println("--------------------------------");
			}
		}
		scan.close();
	}
}