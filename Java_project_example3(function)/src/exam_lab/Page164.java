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

			System.out.print("\n���Ͻô� �¼���ȣ�� �Է��ϼ��� (����� -1): ");
			input_seat = scan.nextInt();

			if (input_seat > 0 && input_seat < remain.length+1) {
				if (remain[input_seat - 1] == 1) {
					System.out.println("�̹� ����� �ڸ��Դϴ�. �ٸ� �ڸ��� �������ּ���.");
					System.out.println();
				} else {
					remain[input_seat - 1] = 1;
					System.out.println("����Ǿ����ϴ�.");

					System.out.println();
					menu(remain);

					System.out.print("\n��� �����Ͻðڽ��ϱ�? (y/n) ");
					confirm = scan.next().charAt(0);

					if (confirm == 'y') {
						continue;
					} else {
						System.out.println("���α׷� ����.");
						break outer;
					}
				}
			} else if (input_seat == -1) {
				System.out.println("���α׷� ����.");
				break outer;
			} else {
				System.out.println("���ڸ� �˸°� �ٽ� �Է����ּ���.");
			}
		}
		scan.close();
	}
}
