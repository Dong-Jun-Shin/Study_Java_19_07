package phoneinfoproject4_8;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookManager7 {
	static final int MAX_CNT = 100;

	// 선언o, 초기화x
	PhoneInfo[] infoStorage;
	int curCnt;

	// 필드명 및 생성자 구현 - 싱글톤, 객체 한개만 만들기
	private static PhoneBookManager7 instance = null;

	public static final PhoneBookManager7 getInstance() {
		if (instance == null) {
			instance = new PhoneBookManager7();
		}
		return instance;
	}

	// 현재 생성자 접근 제어자를 private로 설정 - 싱글톤
	// 외부에서 접근을 막고 getInstance메소드를 이용해 1번만 생성되도록 하기 위해 private 설정
	private PhoneBookManager7() {
		curCnt = 0;
		infoStorage = new PhoneInfo[MAX_CNT];
	}

	public void insertData(int selNum, Scanner scan, Set<PhoneInfo> pBook) throws MenuChoiceException {
		if (selNum < INPUT_SELECT.DEFAULT_DATA || selNum > INPUT_SELECT.COMPANY_DATA) {
			throw new MenuChoiceException(selNum);
		}

		switch (selNum) {
		case INPUT_SELECT.DEFAULT_DATA:
			if (!pBook.add(PhoneBookManager7.dftInsData(scan))) {
				System.out.println("전화번호부에 같은 이름이 존재합니다.\n");
				return;
			}
//			pBook = PhoneBookManager.dftInsData(scan, pBook);
			break;
		case INPUT_SELECT.UNIVERSITY_DATA:
			if (!pBook.add(PhoneBookManager7.univInsData(scan))) {
				System.out.println("전화번호부에 같은 이름이 존재합니다.\n");
				return;
			}
			break;
		case INPUT_SELECT.COMPANY_DATA:
			if (!pBook.add(PhoneBookManager7.compInsData(scan))) {
				System.out.println("전화번호부에 같은 이름이 존재합니다.\n");
				return;
			}
			break;
		}

		System.out.println("데이터의 입력이 완료되었습니다.\n");
		System.out.println();
	}

	private static PhoneInfo dftInsData(Scanner scan) {
		System.out.print("이름 : ");
		String name = scan.nextLine();

		System.out.print("전화번호 : ");
		String phone = scan.nextLine();

		return new PhoneInfo(name, phone);
	}

	public static PhoneInfo univInsData(Scanner scan) {
		System.out.print("이름 : ");
		String name = scan.nextLine();

		System.out.print("전화번호 : ");
		String pNum = scan.nextLine();

		System.out.print("전공 : ");
		String major = scan.nextLine();

		System.out.print("학년 : ");
		int year = scan.nextInt();

		return (PhoneInfo) new PhoneUnivInfo(name, pNum, major, year);
	}

	public static PhoneInfo compInsData(Scanner scan) {
		System.out.print("이름 : ");
		String name = scan.nextLine();

		System.out.print("전화번호 : ");
		String pNum = scan.nextLine();

		System.out.print("회사 : ");
		String company = scan.nextLine();

		return (PhoneInfo) new PhoneCompanyInfo(name, pNum, company);
	}

	public void selectData(Set<PhoneInfo> pBook, String selName) {
		// 반복자 사용
		Iterator<PhoneInfo> it = pBook.iterator();
		while (it.hasNext()) {
			PhoneInfo pi = it.next();
//			if (selName.compareTo(pi.getName())==0) {
			if (pi.getName().equals(selName)) {
				PhoneInfo.showPhoneInfo(pi);
				return;
			}
		}

//		for (int i = 0; i < pBook.size(); i++) {
//			if (pBook[i] == null) {
//				break;
//			} else if (pBook[i].getName().equals(selName)) {
//				//pBook[i]는 변수에 넣어서 매개변수로 전달해주기
//				PhoneInfo.showPhoneInfo(pBook[i]);
//				System.out.println("데이터의 검색이 완료되었습니다.");
//				return;
//			}
//		}
		System.out.println("일치하는 데이터가 없습니다.\n");
	}

	public void deleteData(Set<PhoneInfo> pBook, String selName) {
		Iterator<PhoneInfo> it = pBook.iterator();
		while (it.hasNext()) {
			PhoneInfo pi = it.next();
//			if (selName.compareTo(pi.getName())==0) {
			if (pi.getName().equals(selName)) {
				pBook.remove(pi);
				System.out.println("데이터를 삭제했습니다.\n");
				return;
			}
		}
		System.out.println("일치하는 데이터가 없습니다.\n");
	}

	public void viewList(Set<PhoneInfo> pBook) {
		Iterator<PhoneInfo> it = pBook.iterator();
		while (it.hasNext()) {
			viewElement(it.next());
		}

		// foreach
//		PhoneInfo pi = it.next();
	}

	public void viewElement(PhoneInfo pBook) {
		if (pBook != null) {
			System.out.printf("%s\t", pBook.getName());
			System.out.printf("%s\t", pBook.getPhoneNumber());
			if (pBook instanceof PhoneUnivInfo) {
				System.out.printf("%s\t", ((PhoneUnivInfo) pBook).getMajor());
				System.out.printf("%s\t", ((PhoneUnivInfo) pBook).getYear());
			}
			if (pBook instanceof PhoneCompanyInfo) {
				System.out.printf("\t\t%s\t", ((PhoneCompanyInfo) pBook).getCompany());
			}
			System.out.println();
		}
	}
}