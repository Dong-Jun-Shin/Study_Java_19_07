package phoneinfoproject_2;

import java.util.Scanner;

public class PhoneBookManager5_6{
	private static int arrLeng = 0;
	static final int MAX_CNT=100;
	
	//선언o, 초기화x
	PhoneInfo[] infoStorage;
	int curCnt;
	
	//필드명 및 생성자 구현 - 싱글톤, 객체 한개만 만들기
	private static PhoneBookManager5_6 instance = null;
	public static final PhoneBookManager5_6 getInstance() {
		if(instance == null) {
			instance = new PhoneBookManager5_6();
		}
		return instance;
	}
	
	//현재 생성자 접근 제어자를 private로 설정 - 싱글톤
	//외부에서 접근을 막고 getInstance메소드를 이용해 1번만 생성되도록 하기 위해 private 설정
	private PhoneBookManager5_6() {
		curCnt = 0;
		infoStorage = new PhoneInfo[MAX_CNT];
	}
	
	
	public final int getArrLeng() {
		return arrLeng;
	}

	public PhoneInfo insertData(int selNum, Scanner scan, PhoneInfo pBook) throws MenuChoiceException {
		if(selNum < INPUT_SELECT.DEFAULT_DATA || selNum > INPUT_SELECT.COMPANY_DATA)
			throw new MenuChoiceException(selNum);
		
		switch (selNum) {
		case INPUT_SELECT.DEFAULT_DATA:
			pBook = PhoneBookManager5_6.dftInsData(scan);
//			pBook = PhoneBookManager.dftInsData(scan, pBook);
			break;
		case INPUT_SELECT.UNIVERSITY_DATA:
			pBook = PhoneBookManager5_6.univInsData(scan, pBook);
			break;
		case INPUT_SELECT.COMPANY_DATA:
			pBook = PhoneBookManager5_6.compInsData(scan, pBook);
			break;
		}
		
		arrLeng++;
		
		System.out.println("데이터의 입력이 완료되었습니다.");
		System.out.println();
		
		return pBook;
	}

	private static PhoneInfo dftInsData(Scanner scan) {
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = scan.nextLine();
		
		return new PhoneInfo(name, phone);
	}

	public static PhoneInfo dftInsData(Scanner scan, PhoneInfo pBook) {
		pBook = new PhoneInfo();

		System.out.print("이름 : ");
		pBook.setName(scan.nextLine());

		System.out.print("전화번호 : ");
		pBook.setPhoneNumber(scan.nextLine());

		return pBook;
	}

	public static PhoneInfo univInsData(Scanner scan, PhoneInfo pBook) {
		pBook = new PhoneUnivInfo();

		System.out.print("이름 : ");
		pBook.setName(scan.nextLine());

		System.out.print("전화번호 : ");
		pBook.setPhoneNumber(scan.nextLine());

		System.out.print("전공 : ");
		((PhoneUnivInfo) pBook).setMajor(scan.nextLine());

		System.out.print("학년 : ");
		((PhoneUnivInfo) pBook).setYear(scan.nextInt());

		return pBook;
	}

	public static PhoneInfo compInsData(Scanner scan, PhoneInfo pBook) {
		pBook = new PhoneCompanyInfo();

		System.out.print("이름 : ");
		pBook.setName(scan.nextLine());

		System.out.print("전화번호 : ");
		pBook.setPhoneNumber(scan.nextLine());

		System.out.print("회사 : ");
		((PhoneCompanyInfo) pBook).setCompany(scan.nextLine());

		return pBook;
	}

	public void selectData(PhoneInfo[] pBook, String selName) {
		for (int i = 0; i < pBook.length; i++) {
			if (pBook[i] == null) {
				break;
			} else if (pBook[i].getName().equals(selName)) {
				PhoneInfo.showPhoneInfo(pBook[i]);
				System.out.println("데이터의 검색이 완료되었습니다.");
				return;
			}
		}
		System.out.println("일치하는 데이터가 없습니다.");
	}

	public PhoneInfo[] deleteData(PhoneInfo[] pBook, String selName) {
		for (int i = 0; i < pBook.length; i++) {
			//배열의 끝을 확인
			if (pBook[i] == null) {
				break;

			} else if (pBook[i].getName().equals(selName)) {
				//이름이 같으면 삭제
				pBook[i] = null;

				//배열 정렬
				pBook = sortArr(pBook);

				arrLeng--;
				System.out.println("데이터의 삭제가 완료되었습니다.");
				return pBook;
			}
		}
		System.out.println("일치하는 데이터가 없습니다.");
		return pBook;
	}

	public void viewList(PhoneInfo[] pBook) {
		for (int i = 0; i < pBook.length; i++) {
			if (pBook[i] != null) {
				System.out.printf("%s\t", pBook[i].getName());
				System.out.printf("%s\t", pBook[i].getPhoneNumber());
				if (pBook[i] instanceof PhoneUnivInfo) {
					System.out.printf("%s\t", ((PhoneUnivInfo) pBook[i]).getMajor());
					System.out.printf("%s\t", ((PhoneUnivInfo) pBook[i]).getYear());
				}
				if (pBook[i] instanceof PhoneCompanyInfo) {
					System.out.printf("\t\t%s\t", ((PhoneCompanyInfo) pBook[i]).getCompany());
				}
				System.out.println();
			} else {
				break;
			}
		}
	}
	
	public PhoneInfo[] sortArr(PhoneInfo[] pBook) {
		//배열정리를 위한 임시 공간 선언 및 생성
		PhoneInfo[] temp = new PhoneInfo[100];
		
		//카운트해둔 생성된 목록만큼 검색
		for (int i = 0, k = 0; i < arrLeng + 1; i++) {
			//삭제된 곳을 만나면 증가해서 사용
			if (pBook[k] == null) {
				k++;
			}
			temp[i] = pBook[k++];
		}
		return temp;
	}
}