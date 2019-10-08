package phoneinfoproject4_8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookVer07{
	public static void main(String[] args) throws MenuChoiceException {
		Scanner scan = new Scanner(System.in);
		Set<PhoneInfo> pBook = new HashSet<PhoneInfo>();
		String selName;
		int selNum;
		
		//싱글톤
		PhoneBookManager7 manage = PhoneBookManager7.getInstance();

		while (true) {
			//메뉴선택
			MenuViewer.showFrame();
			selNum = scan.nextInt();
			scan.nextLine();

			switch (selNum) {
			case MENU_SELECT.INSERT_DATA:
				//입력 종류 선택
				MenuViewer.showInsertFrame();
				selNum = scan.nextInt();
				scan.nextLine();
				
				manage.insertData(selNum, scan, pBook);

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

				manage.deleteData(pBook, selName);

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
	}
}