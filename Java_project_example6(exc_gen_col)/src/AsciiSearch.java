import java.util.Scanner;

public class AsciiSearch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = "";
		char ch;

		System.out.println("입력하시면 ASCII로 변환해드립니다.");
		System.out.println("(종료는 \"Quit\"를 입력해주세요.)");
		
		while (true) {
			if (!str.equals("Quit")) {
				System.out.println("한자리 입력해주세요.");
				str = scan.next();
				ch = str.charAt(0);
				
				if(!str.equals("Quit")) {
					System.out.println(ch + "의 ASCII = " + (int) ch);
					System.out.println("-------------------------------");
				}
			} else {
				System.out.println("종료되었습니다.");
				break;
			}
		}

		scan.close();
	}
}