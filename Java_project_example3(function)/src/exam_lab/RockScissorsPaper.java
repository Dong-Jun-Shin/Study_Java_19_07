package exam_lab;

import tool.RockScissors;
import java.util.Scanner;

/*��ǻ�Ϳ� �ϴ� ���������� �����
 * �º� �Ǻ�, ������ �ݺ�(4 �Է½� ����)
 */
public class RockScissorsPaper {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] list = { "����", "����", "��" };
		int user = 0;
	

		outer: while (true) {
			System.out.print("����(1), ����(2), ��(3), ������(4) �� �ϳ��� �����ϼ���>>");
			user = scan.nextInt();

			int com = (int) ((Math.random() * 3) + 1);
			
			//ù��°. Switch�� ����� ���� ������ ���
			//RockScissors.competeSwitch(list, user, com);
			
			//�ι�°. If�� ���� ���� �Ǻ�
			switch (user) {
			case 1:
				RockScissors.competeIf(list, user, com);
				break;
			case 2:
				RockScissors.competeIf(list, user, com);
				break;
			case 3:
				RockScissors.competeIf(list, user, com);
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				break outer;
			default:
				System.out.println("���ڸ� ����� �Է����ּ���.");
			}
		}
		scan.close();
	}
}