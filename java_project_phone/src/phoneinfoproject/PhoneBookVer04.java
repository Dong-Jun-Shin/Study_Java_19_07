package phoneinfoproject;

import simplephoneinfo.MenuViewer;
import java.util.Scanner;

public class PhoneBookVer04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PhoneInfo[] pBook = new PhoneInfo[100];
		String selName;
		int selNum;

		while (true) {
			//메뉴선택
			MenuViewer.showFrame();
			selNum = scan.nextInt();
			scan.nextLine();

			switch (selNum) {
			case 1:
				//입력 종류 선택
				MenuViewer.showInsertFrame();
				selNum = scan.nextInt();
				scan.nextLine();

				int cnt = PhoneBookManager.getArrLeng();
				pBook[cnt] = PhoneBookManager.insertData(selNum, scan, pBook[cnt]);

				break;
			case 2:
				//조회 선택
				MenuViewer.showSelectFrame();
				selName = scan.nextLine();

				PhoneBookManager.selectData(pBook, selName);

				break;
			case 3:
				//삭제 선택
				MenuViewer.showDeleteFrame();
				selName = scan.nextLine();

				pBook = PhoneBookManager.deleteData(pBook, selName);

				break;
			case 4:
				//전체 조회
				System.out.println("-----------------------------------------");
				System.out.println("이름\t번호\t전공\t학년\t회사");
				PhoneBookManager.viewList(pBook);
				System.out.println("-----------------------------------------");
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				return;
			}
		}
	}
}
