package exam_continue;

import java.util.Scanner;

/*
 * ���ڿ�"no news is good news"�� ������� �ݺ��ϸ� ���� 'n'�� ��Ÿ���� Ƚ���� ī�����Ѵ�. ���� ������ ���ڰ� 'n'��
 * �ƴϸ� continue���� ���Ͽ� ������ ������ �κ��� �����ϰ� ���� ���ڸ� ó���Ѵ�. 
 * ������ ���̴� length()�� ���ϸ� �ȴ�.
 */
public class ContinueExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sentence = "no news is good news";
		int cnt = 0;

		System.out.println("ã�� ���ڸ� �Է����ּ���.");
		char ch = scan.next().charAt(0);

		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) != ch) {
				continue;
			}
			cnt++;
		}
		System.out.println(cnt);
		System.out.println();

		scan.close();
	}
}
