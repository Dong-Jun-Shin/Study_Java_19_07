package exam_return;
import java.util.Scanner;

//���� 2���� ���� ��, �� ���
// ����ڷ� �Ͽ��� 2���� ���� �Է� �޾Ƽ�, �� ���
public class NumberSum {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String result = "";
		int n1 = 7;
		int n2 = 12;

		result = "ù��° ��:" + add(n1, n2) + "\n";

		System.out.print("2���� ���� �Է����ּ���.");
		n1 = scan.nextInt();
		n2 = scan.nextInt();

		result += "�ι�° ��:" + add(n1, n2);

		System.out.println(result);
		System.out.println();
		
		scan.close();
	}
	
	public static int add(int n1, int n2) {
		return n1 + n2;
	}
}
