package phoneinfoproject_2;

import java.util.Scanner;
import java.util.Set;

import phoneinfoproject_2.PhoneBookManager7;

public class PhoneBookManager7{
	private static int arrLeng = 0;
	static final int MAX_CNT=100;
	
	//선언o, 초기화x
	PhoneInfo[] infoStorage;
	int curCnt;
	
	//필드명 및 생성자 구현 - 싱글톤, 객체 한개만 만들기
	private static PhoneBookManager7 instance = null;
	public static final PhoneBookManager7 getInstance() {
		if(instance == null) {
			instance = new PhoneBookManager7();
		}
		return instance;
	}
	
	//현재 생성자 접근 제어자를 private로 설정 - 싱글톤
	//외부에서 접근을 막고 getInstance메소드를 이용해 1번만 생성되도록 하기 위해 private 설정
	private PhoneBookManager7() {
		curCnt = 0;
		infoStorage = new PhoneInfo[MAX_CNT];
	}
	
	
	public final int getArrLeng() {
		return arrLeng;
	}

	public void insertData(int selNum, Scanner scan, Set<PhoneInfo> pBook) throws MenuChoiceException {
		if(selNum < INPUT_SELECT.DEFAULT_DATA || selNum > INPUT_SELECT.COMPANY_DATA) {
			throw new MenuChoiceException(selNum);
		}
		
		switch (selNum) {
		case INPUT_SELECT.DEFAULT_DATA:
			pBook.add(PhoneBookManager7.dftInsData(scan));
//			pBook = PhoneBookManager.dftInsData(scan, pBook);
			break;
		case INPUT_SELECT.UNIVERSITY_DATA:
			pBook.add(PhoneBookManager7.univInsData(scan));
			break;
		case INPUT_SELECT.COMPANY_DATA:
			pBook.add(PhoneBookManager7.compInsData(scan));
			break;
		}
		
		arrLeng++;
		
		System.out.println("데이터의 입력이 완료되었습니다.");
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

		return new PhoneUnivInfo(name, pNum, major, year);
	}

	public static PhoneInfo compInsData(Scanner scan) {
		System.out.print("이름 : ");
		String name = scan.nextLine();

		System.out.print("전화번호 : ");
		String pNum = scan.nextLine();

		System.out.print("회사 : ");
		String company = scan.nextLine();

		return new PhoneCompanyInfo(name, pNum, company);
	}

	public void selectData(Set<PhoneInfo> pBook, String selName) {
		//반복자 사용
		for (int i = 0; i < pBook.size(); i++) {
			if (pBook[i] == null) {
				break;
			} else if (pBook[i].getName().equals(selName)) {
				//pBook[i]는 변수에 넣어서 매개변수로 전달해주기
				PhoneInfo.showPhoneInfo(pBook[i]);
				System.out.println("데이터의 검색이 완료되었습니다.");
				return;
			}
		}
		System.out.println("일치하는 데이터가 없습니다.");
	}

	public void deleteData(Set<PhoneInfo> pBook, String selName) {
		for (int i = 0; i < pBook.size(); i++) {
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
			}
		}
		System.out.println("일치하는 데이터가 없습니다.");
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