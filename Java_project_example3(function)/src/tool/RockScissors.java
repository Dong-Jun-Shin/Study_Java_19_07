package tool;

public class RockScissors {
	public static void competeIf(String[] list, int user, int com) {
		System.out.println("��ǻ�ʹ� " + list[com - 1] + "�� �½��ϴ�.");
		if (user == 3){
			if (com == user) {
				System.out.println("�����ϴ�.");
			} else if (com == 1) {
				System.out.println("�����ϴ�.");
			} else {
				System.out.println("�̰���ϴ�.");
			}
		} else {
			if (com == user) {
				System.out.println("�����ϴ�.");
			} else if (com == user+1) {
				System.out.println("�����ϴ�.");
			} else {
				System.out.println("�̰���ϴ�.");
			}
		}	
	}
	
	public static void competeSwitch(String[] list, int user, int com){
		int diff = 0;
		
		System.out.println("��ǻ�ʹ� " + list[com - 1] + "�� �½��ϴ�.");
		diff = user - com;
		
		switch(diff) {
		case 0:
			System.out.println("�����ϴ�.");
			break;
		case -1:	//����� ����, ��ǻ�� ���� or ����� ����, ��ǻ�� ����
		case 2:		//����� ��, ��ǻ�� ����
			System.out.println("�����ϴ�.");
			break;
		case 1:
		case -2: 
			System.out.println("�̰���ϴ�.");
			break;
		default:
			System.out.println("���ڸ� �ٽ� �Է����ּ���.");
		}
	}
}
