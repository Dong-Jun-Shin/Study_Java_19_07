package exam_character_string;

public class CharacterStringExample {
	public static void main(String[] args) {
		char c1 = 'A';		//문자를 직접 저장 (char)
		char c2 = 65;		//십진수로 저장 (int)
		char c3 = 0x41;		//16진수로 저장 (int)
		char c4 = '\u0041';	//16진수로 저장 (char)
	
		char c5 = '가';		//문자를 직접 저장 (char)
		char c6 = 44032;	//십진수로 저장 (int)
		char c7 = '\uac00';	//16진수로 저장 (char)

		int uniCode = c1;	//유니코드 얻기		
		
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

