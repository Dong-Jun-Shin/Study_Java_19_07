package exam_array;

/*
 * ���ĺ� �ҹ��ڸ� ������ �迭�� �����Ͽ� ����ϵ��� ���α׷��� �ۼ��� �ּ���.
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

