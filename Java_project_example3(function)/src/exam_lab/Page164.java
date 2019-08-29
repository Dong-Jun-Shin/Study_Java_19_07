package exam_lab;

import java.util.Scanner;

//TheaterReserve
public class Page164 {
	public static void menu(int[] remain) {
		System.out.println("--------------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%2d ", i+1);
		}
		System.out.println("\n--------------------------------");

		for (int i = 0; i < 10; i++) {
			System.out.printf("%2d ", remain[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] remain = new int[10];
		int input_seat;
		char confirm;

		outer: while (true) {
			menu(remain);

			System.out.print("\n원하시는 좌석번호를 입력하세요 (종료는 -1): ");
			input_seat = scan.nextInt();

			if (input_seat > 0 && input_seat < remain.length+1) {
				if (remain[input_seat - 1] == 1) {
					System.out.println("이미 예약된 자리입니다. 다른 자리를 선택해주세요.");
					System.out.println();
				} else {
					remain[input_seat - 1] = 1;
					System.out.println("예약되었습니다.");

					System.out.println();
					menu(remain);

					System.out.print("\n계속 예매하시겠습니까? (y/n) ");
					confirm = scan.next().charAt(0);

					if (confirm == 'y') {
						continue;
					} else {
						System.out.println("프로그램 종료.");
						break outer;
					}
				}
			} else if (input_seat == -1) {
				System.out.println("프로그램 종료.");
				break outer;
			} else {
				System.out.println("숫자를 알맞게 다시 입력해주세요.");
			}
		}
		scan.close();
	}
}
