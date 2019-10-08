package phoneinfoproject4_8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * - 전화번호부 정보는 PhoneBook.dat파일로 저장한다.
 * - 프로그램이 종료되면 프로그램의 실행 중에 입력된 데이터를 파일에 저장한다.
 * - 프로그램이 다시 실행되면 파일에 저장된 데이터를 프로그램상으로 복원하는 기능을 추가한다.
 * 
 */
public class PhoneBookVer08 {
	public static void main(String[] args) throws MenuChoiceException {
		
		Set<PhoneInfo> pBook = new HashSet<PhoneInfo>();
		String selName;
		int selNum;

		// 싱글톤
		PhoneBookManager8 manage = PhoneBookManager8.getInstance();

		// 기록 읽기
		manage.readFile(pBook);

		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				
				// 메뉴선택
				MenuViewer.showFrame();
				selNum = scan.nextInt();
				scan.nextLine();

				switch (selNum) {
				case MENU_SELECT.INSERT_DATA:
					// 입력 종류 선택
					MenuViewer.showInsertFrame();
					selNum = scan.nextInt();
					scan.nextLine();

					manage.insertData(selNum, scan, pBook);

					break;
				case MENU_SELECT.SELECT_DATA:
					// 조회 선택
					MenuViewer.showSelectFrame();
					selName = scan.nextLine();

					manage.selectData(pBook, selName);

					break;
				case MENU_SELECT.DELETE_DATA:
					// 삭제 선택
					MenuViewer.showDeleteFrame();
					selName = scan.nextLine();

					manage.deleteData(pBook, selName);

					break;
				case MENU_SELECT.VIEW_LIST:
					// 전체 조회
					System.out.println("-----------------------------------------");
					System.out.println("이름\t번호\t전공\t학년\t회사");
					manage.viewList(pBook);
					System.out.println("-----------------------------------------");
					break;
				case 5:
					System.out.println("\n전화번호부 저장을 시작합니다.");
					manage.saveFile(pBook);

					System.out.println("프로그램을 종료합니다.");
					scan.close();
					return;
				}
			} catch (Exception e) {
				System.out.println("\n메뉴 선택 중 문제가 생겼습니다.");
				System.out.println("메뉴 선택을 다시 진행합니다.\n");
			}
		}
	}
}