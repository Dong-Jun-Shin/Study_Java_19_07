package exam_for;

import java.util.Scanner;

/*
 * �� ������ ���� �˾Ƹ����� �����̴�.
 * ���α׷��� 1���� 10������ ������ �����ϰ� �ְ� ����ڴ� ������ ���Ͽ� �� ������ �˾Ƹ������� ����Ѵ�.
 * ����ڰ� ���� �����ϸ� ���α׷��� �ڽ��� ������ ������ ���Ͽ� ���õ� ������ 
 * �� ������ ������ ���� �˷��ش�.
 * ���α׷��� do ~ while ������ ����Ͽ� ����ڰ� ��Ȯ�ϰ� ������ �˾Ƹ��� ������ �ݺ��Ѵ�.
 * ����ڰ� ������ �˾Ƹ����� �� �� ���� �˾Ƹ��������� ȭ�鿡 ����Ѵ�. 
 */
public class NumberGame {
	public static void main(String[] args) {
		System.out.println("---------------------");
		System.out.println("	���� �˾Ƹ����� ����	 ");
		System.out.println("(�������� \"q\"�� �Է����ּ���.)");
		System.out.println("---------------------");
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			int ran = (int) ((Math.random() * 10) + 1);
			System.out.println("         ���� ���������ϴ�.");
			System.out.println("---------------------");
			System.out.println("(��Ʈ�� '����  * x * 7' �� ����Դϴ�.)");
			System.out.println("hint 1: "+ (ran*(int) ((Math.random() * 10) + 1)*7));
			System.out.println("hint 2: "+ (ran*(int) ((Math.random() * 10) + 1)*7));
			System.out.println("hint 3: "+ (ran*(int) ((Math.random() * 10) + 1)*7));
			
			while (true) {
				System.out.println("�����ϰ� ���� ���� �Է����ּ���.");
				int num = scan.nextInt();

				if (ran == num) {
					System.out.println("������ϴ�.!");
					break;
				} else {
					System.out.println("Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.");
					System.out.println("---------------------");
				}
			}
			break;
		}

		scan.close();
	}
}
