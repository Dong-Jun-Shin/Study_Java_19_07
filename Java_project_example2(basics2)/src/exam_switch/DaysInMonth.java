package exam_switch;

import java.util.Scanner;

public class DaysInMonth {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year, month;
		int days = 0;

		while (true) {
			System.out.println("년도를 입력해주세요.");
			year = scan.nextInt();

			if(year >= 0 ) {
				break;
			}
			System.out.println("년도를 제대로 입력해주세요.");
			System.out.println("-----------------------");
		}
		
		while(true) {
			System.out.println("월을 입력해주세요.");
			month = scan.nextInt();

			if (month < 13 && month >= 0) {
				break;
			}
			System.out.println("월이 잘못 입력되었습니다.");
			System.out.println("-----------------------");
		}

		// break;가 없으면 넘어가는 특성을 이용해서 여러개의 조건을 하나의 처리로 이어준다.
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
		System.out.println("해당 " + month + "월의 일수는 " + days + "일 입니다.");
		/*
		 * if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
		 * month == 10 || month == 12) { days = 31; }else if(month == 4 || month == 6 ||
		 * month == 9 || month == 11) { days = 30; }else if(month == 2){ days = 28; }
		 * System.out.println("해당 " + month + "월의 일수는 " + days + "일 입니다.");
		 */
		System.out.println("");
		System.out.println(month + "월-------------------------");
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