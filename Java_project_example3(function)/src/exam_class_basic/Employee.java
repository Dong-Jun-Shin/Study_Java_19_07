package exam_class_basic;

import java.util.Scanner;

public class Employee {
	public String name;
	public String phoneNumber;
	public int salary;
	
	public void getData(Scanner scan) {
		System.out.println("����1 ������ �Է����ּ���>>");
		System.out.print("�̸� : ");
		name = scan.nextLine();
		
		System.out.print("��ȣ : ");
		phoneNumber = scan.nextLine();
		
		System.out.print("�޿� : ");
		salary = scan.nextInt();
		scan.nextLine();
		
		System.out.println();
	}
	
	public String toString() {
		return String.format("��������[�����: %-3s,\t ��ȭ��ȣ = %-10s,\t �޿� = %5d]", name, phoneNumber, salary);
	}
}
