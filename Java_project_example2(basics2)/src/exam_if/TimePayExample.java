package exam_if;

import java.util.Scanner;

public class TimePayExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String u_num;
		int u_work_time, u_hour_pay;
		int pay;

		while (true) {
			System.out.print("�����ȣ�� �Է����ּ���. ");
			u_num = scan.next();

			System.out.print("�ٹ��ð��� �Է����ּ���. ");
			u_work_time = scan.nextInt();

			System.out.print("�ð��� �ݾ��� �Է����ּ���. ");
			u_hour_pay = scan.nextInt();
			System.out.println("----------------------------");

			if (u_work_time >= 0) {
				break;
			} else {
				System.out.println("�ð��� �ٽ� �Է����ּ���. (0�̻�)");
				System.out.println("\n----------------------------");
			}
		}
		pay = u_work_time * u_hour_pay;
		if (u_work_time > 40) {
			//pay = pay + (u_work_time - 40) * (u_hour_pay / 2);
			pay = pay + (u_work_time - 40) * (int)(u_hour_pay * 0.5);
			
		}
		System.out.println("�����ȣ : " + u_num + "\n�޿� : " + pay);
		
		scan.close();
	}
}
