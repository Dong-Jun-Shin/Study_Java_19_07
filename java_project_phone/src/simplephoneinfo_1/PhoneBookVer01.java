package simplephoneinfo_1;

/*
 * 전화번호 관리 프로그램 구현 프로젝트
 * Version 0.1
 * 
 * [출력 결과 예시]
 * name: 임미경
 * phone: 010-2345-6573
 * birth: 1965.03.28
 * 
 * name: 김현수
 * phone: 011-6435-1249
 * 
 */
public class PhoneBookVer01 {
	public static void main(String[] args) {
		//생성자 (매개변수 3개)
		PhoneInfo pInfo1 = new PhoneInfo("임미경","010-2345-6573","1965.03.28");
		//생성자 (매개변수 2개)
		PhoneInfo pInfo2 = new PhoneInfo("김현수","011-6435-1249");
		//getter, setter
		PhoneInfo pInfo3 = new PhoneInfo();
		pInfo3.setName("Jane");
		pInfo3.setPhoneNumber("322-3333-3333");
		
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
		pInfo3.showPhoneInfo();
	}
}
