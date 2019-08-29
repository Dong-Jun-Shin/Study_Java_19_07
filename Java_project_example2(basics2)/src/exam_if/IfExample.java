package exam_if;

import java.util.Scanner;

public class IfExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("절댓값을 알려드린 후 절댓값의 홀짝 여부를 알려드립니다. 입력해주세요.");
		int number = scan.nextInt();
		
		//절대값
		System.out.println("\n입력한 수의 초기값 : " + number);

		System.out.println(number + "의 절대값은 ");

		if (number < 0) {
			number = -number;
		}
		System.out.println(number + "입니다.");

		//홀짝
		System.out.println("\n입력한 수의 초기값 : " + number);

		if (number % 2 == 0) {
			System.out.println("입력한 " + number + "는 짝수입니다.");
		}else {
			System.out.println("입력한 " + number + "는 홀수입니다.");
		}
		
		scan.close();
		
	}
}
