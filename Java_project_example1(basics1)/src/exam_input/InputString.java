package exam_input;

import java.util.Scanner;

/*
 * ������ �̸�, ����, �ּҸ� ����� �� �ַ� �ۼ��� �ּ���.
 * 
 * -------------��¹�---------------
 * ȫ�浿�� �ȳ��ϼ���! 50���̽ó׿�.
 * �ּҴ� ����� ������ ���з� 2��
 */
public class InputString {
	public static void main(String[] args) {
		String name, address;
		int age;

		Scanner scan = new Scanner(System.in);

		System.out.println("�̸��� �Է����ּ���.");
		name = scan.next();

		System.out.println("���̸� �Է����ּ���.");
		age = scan.nextInt();
		
		//�Է��ϸ鼭 ���� ���๮�ڸ� �����ش�.
		scan.nextLine();
		
		System.out.println("�ּҸ� �Է����ּ���.");
		address = scan.nextLine();
	
		System.out.println("-------------------------");
		System.out.println(name + "�� �ȳ��ϼ���! " + age + "���̽ó׿�.");
		System.out.println("�ּҴ� " + address);
		
		scan.close();
	}
}