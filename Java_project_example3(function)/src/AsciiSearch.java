import java.util.Scanner;

public class AsciiSearch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = "";
		char ch;

		System.out.println("�Է��Ͻø� ASCII�� ��ȯ�ص帳�ϴ�.");
		System.out.println("(����� \"Quit\"�� �Է����ּ���.)");
		
		while (true) {
			if (!str.equals("Quit")) {
				System.out.println("���ڸ� �Է����ּ���.");
				str = scan.next();
				ch = str.charAt(0);
				
				if(!str.equals("Quit")) {
					System.out.println(ch + "�� ASCII = " + (int) ch);
					System.out.println("-------------------------------");
				}
			} else {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
		}

		scan.close();
	}
}
