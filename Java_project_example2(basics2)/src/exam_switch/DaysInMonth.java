package exam_switch;

import java.util.Scanner;

public class DaysInMonth {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year, month;
		int days = 0;

		while (true) {
			System.out.println("�⵵�� �Է����ּ���.");
			year = scan.nextInt();

			if(year >= 0 ) {
				break;
			}
			System.out.println("�⵵�� ����� �Է����ּ���.");
			System.out.println("-----------------------");
		}
		
		while(true) {
			System.out.println("���� �Է����ּ���.");
			month = scan.nextInt();

			if (month < 13 && month >= 0) {
				break;
			}
			System.out.println("���� �߸� �ԷµǾ����ϴ�.");
			System.out.println("-----------------------");
		}

		// break;�� ������ �Ѿ�� Ư���� �̿��ؼ� �������� ������ �ϳ��� ó���� �̾��ش�.
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if((year%4==0&&year%100!=0)||year%400==0) {
				days = 29;
			}else {
				days = 28;
			}
			break;
		}
		System.out.println("�ش� " + month + "���� �ϼ��� " + days + "�� �Դϴ�.");
		/*
		 * if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
		 * month == 10 || month == 12) { days = 31; }else if(month == 4 || month == 6 ||
		 * month == 9 || month == 11) { days = 30; }else if(month == 2){ days = 28; }
		 * System.out.println("�ش� " + month + "���� �ϼ��� " + days + "�� �Դϴ�.");
		 */
		System.out.println("");
		System.out.println(month + "��-------------------------");
		for(int i = 0; i< days; i++) {
			System.out.printf("%2d ", (i+1));
			if((i+1)%7 == 0) {
				System.out.println("");
			}
		}
		System.out.println("\n---------------------------");
		
		scan.close();
	}
}