package exam_character_string;

public class CharacterStringExample {
	public static void main(String[] args) {
		char c1 = 'A';		//���ڸ� ���� ���� (char)
		char c2 = 65;		//�������� ���� (int)
		char c3 = 0x41;		//16������ ���� (int)
		char c4 = '\u0041';	//16������ ���� (char)
	
		char c5 = '��';		//���ڸ� ���� ���� (char)
		char c6 = 44032;	//�������� ���� (int)
		char c7 = '\uac00';	//16������ ���� (char)

		int uniCode = c1;	//�����ڵ� ���		
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(c7);
		System.out.println(uniCode);
	}
}

