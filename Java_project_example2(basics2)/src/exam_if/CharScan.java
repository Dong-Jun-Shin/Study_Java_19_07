package exam_if;

import java.util.Scanner;

public class CharScan {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//char������ �� �� �ֱ�.
		//char ch = null; - �� �� ����.
		//char ch = ''; - �� �� ����.
		char ch = '\0'; // �ƽ�Ű �ڵ� ������ - : NUL(NULL)
		
		//String������ �� �� �ֱ�.
		//String str = null; - ����
		String str = ""; // - ����
		
		System.out.println("�ѹ��ڸ� �Է��ϼ��� : ");
		//charAt(index) - char���·� 'index'��° ���ڸ� �����´�.
		ch = scan.next().charAt(0);
		
		System.out.println(ch+"�� �����Դϴ�. ^^");
		scan.close();
	}
}
