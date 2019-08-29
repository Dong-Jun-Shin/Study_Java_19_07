package exam_return;
import java.util.Scanner;

//변수 2개를 선언 후, 합 출력
// 사용자로 하여금 2개의 수를 입력 받아서, 합 출력
public class NumberSum {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String result = "";
		int n1 = 7;
		int n2 = 12;

		result = "첫번째 합:" + add(n1, n2) + "\n";

		System.out.print("2개의 수를 입력해주세요.");
		n1 = scan.nextInt();
		n2 = scan.nextInt();

		result += "두번째 합:" + add(n1, n2);

		System.out.println(result);
		System.out.println();
		
		scan.close();
	}
	
	public static int add(int n1, int n2) {
		return n1 + n2;
	}
}
