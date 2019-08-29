package exam_main_argument;

/*
 * ������
 * Run > Run Configurations���� �ι�° ��(Arguments)�� �����Ͽ�
 * Program arguments�� ���� �Է��ϰ� Run ��ư�� Ŭ���ϸ� �ȴ�.
 */
public class Greeting {
	public static void main(String[] args) {
		System.out.print("�ȳ��ϼ���. ");
		System.out.print("�ڹ� ���� �ð��� ");
		System.out.println("���� �����Դϴ�.");

		if (args.length == 0) {
			System.out.println("�ƹ��͵� �Է����� �ʾҽ��ϴ�.");
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println("���� �̸��� " + args[i] + "�Դϴ�.");
		}
	}
}
