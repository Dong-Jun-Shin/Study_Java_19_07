package exam_if;

import java.util.Scanner;

public class TimePayExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String u_num;
		int u_work_time, u_hour_pay;
		int pay;

		while (true) {
			System.out.print("사원번호를 입력해주세요. ");
			u_num = scan.next();

			System.out.print("근무시간을 입력해주세요. ");
			u_work_time = scan.nextInt();

			System.out.print("시간당 금액을 입력해주세요. ");
			u_hour_pay = scan.nextInt();
			System.out.println("----------------------------");

			if (u_work_time >= 0) {
				break;
			} else {
				System.out.println("시간을 다시 입력해주세요. (0이상)");
				System.out.println("\n----------------------------");
			}
		}
		pay = u_work_time * u_hour_pay;
		if (u_work_time > 40) {
			//pay = pay + (u_work_time - 40) * (u_hour_pay / 2);
			pay = pay + (u_work_time - 40) * (int)(u_hour_pay * 0.5);
			
		}
		System.out.println("사원번호 : " + u_num + "\n급여 : " + pay);
		
		scan.close();
	}
}
