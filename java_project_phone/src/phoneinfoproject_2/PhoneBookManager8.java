package phoneinfoproject_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookManager8 {
	private static PhoneBookManager8 instance = null;

	public static final PhoneBookManager8 getInstance() {
		if (instance == null) {
			instance = new PhoneBookManager8();
		}
		return instance;
	}

	private PhoneBookManager8() {
	}

	public void insertData(int selNum, Scanner scan, Set<PhoneInfo> pBook) throws MenuChoiceException {
		if (selNum < INPUT_SELECT.DEFAULT_DATA || selNum > INPUT_SELECT.COMPANY_DATA) {
			throw new MenuChoiceException(selNum);
		}

		switch (selNum) {
		case INPUT_SELECT.DEFAULT_DATA:
			if (!pBook.add(PhoneBookManager8.dftInsData(scan))) {
				System.out.println("전화번호부에 같은 이름이 존재합니다.\n");
				return;
			}
//			pBook = PhoneBookManager.dftInsData(scan, pBook);
			break;
		case INPUT_SELECT.UNIVERSITY_DATA:
			if (!pBook.add(PhoneBookManager8.univInsData(scan))) {
				System.out.println("전화번호부에 같은 이름이 존재합니다.\n");
				return;
			}
			break;
		case INPUT_SELECT.COMPANY_DATA:
			if (!pBook.add(PhoneBookManager8.compInsData(scan))) {
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
			if (pi.getName().equals(selName)) {
				PhoneInfo.showPhoneInfo(pi);
				return;
			}
		}
		System.out.println("일치하는 데이터가 없습니다.\n");
	}

	public void deleteData(Set<PhoneInfo> pBook, String selName) {
		Iterator<PhoneInfo> it = pBook.iterator();
		while (it.hasNext()) {
			PhoneInfo pi = it.next();
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
	
	public void saveFile(Set<PhoneInfo> pBook) {
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("PhoneBook.dat")))){
			Iterator<PhoneInfo> it = pBook.iterator();
			while(it.hasNext()) {
				oos.writeObject(it.next());
			}
			oos.flush();
			oos.close();
			
			System.out.println("\n...\n\n저장을 완료했습니다.");
		}catch(IOException io) {
			System.out.println("저장을 실패했습니다.\n");
		}
	}
	
	public void readFile(Set<PhoneInfo> pBook) {
		try(ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("PhoneBook.dat")))){
			
			while(true){
				pBook.add((PhoneInfo)ois.readObject());				
			}
		}catch(ClassNotFoundException cnf) {
			System.out.println("읽는 중 문제가 생겼습니다.\n");
		}catch(EOFException eof) {
			System.out.println("읽기 완료\n");
		}catch(IOException io) {
			System.out.println("읽어올 기록 파일이 없어 초기값으로 시작합니다.\n");
		}
	}
}