package simplephoneinfo;

import java.util.Scanner;

public class PhoneBookManager3{
	private static int arrLeng = 1;
	
	public static void insertData(Scanner scan, PhoneInfo user) {
		System.out.print("이름 : ");
		user.setName(scan.nextLine());

		System.out.print("전화번호 : ");
		user.setPhoneNumber(scan.nextLine());

		System.out.print("생년월일 : ");
		user.setBirthday(scan.nextLine());
		//생일을 받지 않을 경우를 정의
		if (user.getBirthday().equals(""))
			user.setBirthday(null);
		
		System.out.println("데이터의 입력이 완료되었습니다.");
//		System.out.println("\n입력된 정보 출력...");
//		user.showPhoneInfo();

		arrLeng++;
	}
	
	public static void selectData(PhoneInfo[] user, String selName) {
		for (int i = 0; i < user.length; i++) {
			if(user[i].getName() == null) {
				break;
			}else if(user[i].getName().equals(selName)) {
				user[i].showPhoneInfo();		
				System.out.println("데이터의 검색이 완료되었습니다.");
				return;
			}
		}
		System.out.println("일치하는 데이터가 없습니다.");
	}
	
	public static PhoneInfo[] deleteData(PhoneInfo[] user, String selName) {
		for (int i = 0; i < user.length; i++) {
			//배열의 끝을 확인
			if(user[i].getName() == null) {
				break;
				
			}else if(user[i].getName().equals(selName)) {
				
				//이름이 같으면 삭제
				user[i] = new PhoneInfo();
				
				//배열 정렬
				user = sortArr(user);
				
				arrLeng--;
				System.out.println("데이터의 삭제가 완료되었습니다.");
				return user;
			}
		}
		System.out.println("일치하는 데이터가 없습니다.");
		return user;
	}
	
	public static PhoneInfo[] sortArr(PhoneInfo[] user) {
		//배열정리를 위한 임시 공간 선언 및 생성
		PhoneInfo[] temp = new PhoneInfo[100];
		
		for (int i = 0; i < user.length; i++) {
			temp[i] = new PhoneInfo();
		}
		
		//카운트해둔 생성된 목록만큼 검색
		for (int i = 0, k=0; i < arrLeng; i++) {
			//삭제된 곳을 만나면 증가해서 사용
			if(user[k] == null) {
				k++;
				
			}
			temp[i] = user[k];
		}
		return temp;
	}
	
	
}