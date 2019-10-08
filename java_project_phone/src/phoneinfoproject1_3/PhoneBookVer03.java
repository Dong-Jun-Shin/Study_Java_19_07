package phoneinfoproject1_3;

import java.util.Scanner;

public class PhoneBookVer03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PhoneInfo3[] user = new PhoneInfo3[100];
		int cnt = 0;
		String selName = "";
		
		//user[0] = new PhoneInfo("홍길동", "123-1234", "2000년 11월 22일");
		for (int i = 0; i < user.length; i++) {
			user[i] = new PhoneInfo3();
		}
		
		while(true) {
			MenuViewer.showFrame();
			int selNum = scan.nextInt();
			scan.nextLine();
			
			switch(selNum) {
			case 1:
				MenuViewer.showInsertFrame();
				selNum = scan.nextInt();
				scan.nextLine();
				
				PhoneBookManager3.insertData(selNum, scan, user[cnt++]);
				break;
			case 2:
				System.out.print("데이터 검색을 시작합니다.\n이름 : ");
				selName = scan.nextLine();
				PhoneBookManager3.selectData(user, selName);
				break;
			case 3:
				System.out.print("데이터 삭제를 시작합니다.\n이름 : ");
				selName = scan.nextLine();
				PhoneBookManager3.deleteData(user, selName);
				break;
			case 4:
				System.out.println("프로그램 종료");
				scan.close();
				return;
			}
			
			System.out.println();
		}
	}
}
