package phoneinfoproject_2;

import java.util.Scanner;

import simplephoneinfo_1.MenuViewer;
import phoneinfoproject_2.PhoneBookManager5_6;

public class PhoneBookVer06 {
	public static void main(String[] args) throws MenuChoiceException {
		Scanner scan = new Scanner(System.in);
		PhoneInfo[] pBook = new PhoneInfo[100];
		String selName;
		int selNum;

		//싱글톤
		PhoneBookManager5_6 manage = PhoneBookManager5_6.getInstance();
		try {
			while (true) {
				//메뉴선택
				MenuViewer.showFrame();
				selNum = scan.nextInt();
				scan.nextLine();

				if (selNum < MENU_SELECT.INSERT_DATA || selNum > MENU_SELECT.EXIT) {
					throw new MenuChoiceException(selNum);
				}

				switch (selNum) {
				case MENU_SELECT.INSERT_DATA:
					//입력 종류 선택
					MenuViewer.showInsertFrame();
					selNum = scan.nextInt();
					scan.nextLine();

					int cnt = manage.getArrLeng();
					pBook[cnt] = manage.insertData(selNum, scan, pBook[cnt]);

					break;
				case MENU_SELECT.SELECT_DATA:
					//조회 선택
					MenuViewer.showSelectFrame();
					selName = scan.nextLine();

					manage.selectData(pBook, selName);

					break;
				case MENU_SELECT.DELETE_DATA:
					//삭제 선택
					MenuViewer.showDeleteFrame();
					selName = scan.nextLine();

					pBook = manage.deleteData(pBook, selName);

					break;
				case MENU_SELECT.VIEW_LIST:
					//전체 조회
					System.out.println("-----------------------------------------");
					System.out.println("이름\t번호\t전공\t학년\t회사");
					manage.viewList(pBook);
					System.out.println("-----------------------------------------");
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					scan.close();
					return;
				}
			}
		} catch (MenuChoiceException e) {
			e.showWrongChoice();
			System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
		}

	}
}