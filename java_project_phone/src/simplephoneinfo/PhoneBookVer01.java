package simplephoneinfo;

/*
 * ��ȭ��ȣ ���� ���α׷� ���� ������Ʈ
 * Version 0.1
 * 
 * [��� ��� ����]
 * name: �ӹ̰�
 * phone: 010-2345-6573
 * birth: 1965.03.28
 * 
 * name: ������
 * phone: 011-6435-1249
 * 
 */
public class PhoneBookVer01 {
	public static void main(String[] args) {
		//������ (�Ű����� 3��)
		PhoneInfo pInfo1 = new PhoneInfo("�ӹ̰�","010-2345-6573","1965.03.28");
		//������ (�Ű����� 2��)
		PhoneInfo pInfo2 = new PhoneInfo("������","011-6435-1249");
		//getter, setter
		PhoneInfo pInfo3 = new PhoneInfo();
		pInfo3.setName("Jane");
		pInfo3.setPhoneNumber("322-3333-3333");
		
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
		pInfo3.showPhoneInfo();
	}
}
