package exam_array;

/*
 * 알파벳 소문자를 문자형 배열에 대입하여 출력하도록 프로그램을 작성해 주세요.
 */
public class CharArrayExample {
	public static void main(String[] args) {
		char[] alphabet = new char[26];

		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char)(i + 65);
		}
		
		for(char num : alphabet) {
			System.out.print(num + " ");
			System.out.print((char)(num+32) + " \n");
		}
	}
}

