package first_exam;

/**
 * P.47 ����(����)
 * Class Ȱ��
 */

public class PrintOfClass {
	public static void main(String[] args) {
		My.name("�ŵ���");
		My.add("���ѹα� �� ��");
		My.phone("010-1234-1234");
		My.work("����");
	}
}

class My {
	public static void name(String n) {
		System.out.println("�̸��� " + n + "�̰��..");
	}

	public static void add(String n) {
		System.out.println("�ּҴ� " + n + "�̰��..");
	}

	public static void phone(String n) {
		System.out.println("��ȣ�� " + n + "�̰��..");
	}

	public static void work(String n) {
		System.out.println("������ " + n + "�Դϴ�.");
	}
}
