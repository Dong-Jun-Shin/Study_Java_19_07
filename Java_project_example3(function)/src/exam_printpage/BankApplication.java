package exam_printpage;

import java.util.Scanner;

public class BankApplication {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Account[] person = new Account[1];
		for (int i = 0; i < person.length; i++) {
			person[i] = new Account();
		}

		while (true) {
			Account.showFrame();
			int selNum = scan.nextInt();
			scan.nextLine();

			//마지막 행에 대해 실행
			switch (selNum) {
			case 1:
				person = person[person.length - 1].createAccount(scan, person);
				break;
			case 2:
				person = person[person.length - 1].removeAccount(scan, person);
				break;
			case 3:
				person[person.length - 1].accountList(person);
				break;
			case 4:
				person[person.length - 1].deposit(scan, person);
				break;
			case 5:
				person[person.length - 1].withdraw(scan, person);
				break;
			case 6:
				System.out.println("프로그램 종료");
				scan.close();
				return;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}
}
