package simplephoneinfo_1;

import java.util.Scanner;

public class PhoneBookVer02 {
	public static void readData(Scanner scan) {
		PhoneInfo info = new PhoneInfo();
		System.out.print("이름 : ");
		info.setName(scan.nextLine());

		System.out.print("전화번호 : ");
		info.setPhoneNumber(scan.nextLine());

		System.out.print("생년월일 : ");
		info.setBirthday(scan.nextLine());
		//생일을 받지 않을 경우를 정의
		if (info.getBirthday().equals(""))
			info.setBirthday(null);

		System.out.println("\n입력된 정보 출력...");
		info.showPhoneInfo();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PhoneInfo pInfo = new PhoneInfo();
		int inputNum;

//		outer: while (true) {
		while(true) {
			PhoneInfo.showFrame();
			
			//메뉴선택
			inputNum = scan.nextInt();
			scan.nextLine();

			switch (inputNum) {
			case 1:
			PhoneBookManager1_3.insertData(scan, pInfo);
//				readData();
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				//메소드를 강제 종료시킴. -main을 강제로 종료
				return;
//				break outer;
			default:
				System.out.println("1과 2 중에 선택해주세요.");
			}
		}
	}
}
