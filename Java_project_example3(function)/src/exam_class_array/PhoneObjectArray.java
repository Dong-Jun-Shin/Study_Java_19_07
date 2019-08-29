package exam_class_array;

public class PhoneObjectArray {
	public static void main(String[] args) {
		System.out.println("==========�� ��ü ����==========");
		Phone p1, p2, p3;
		p1 = new Phone("������11", "����");
		p2 = new Phone("������ S10", "�Ｚ");
		p3 = new Phone("G8", "LG");
		
		p1.printData();
		p2.printData();
		p3.printData();
		System.out.println();
				System.out.println("==========��ü �迭 ���==========");
		Phone[] p = new Phone[3];
		String[] name = {"������11", "������ S10", "G8"};
		String[] comp = {"����", "�Ｚ", "LG"};
		
		//�� �Է�
		for (int i = 0; i < p.length; i++) {
			p[i] = new Phone(name[i], comp[i]);
		}
		
		//for ~ each���� �̿��� ���
		for (Phone ph : p) {
			ph.printData();
		}
		
		//for���� �̿��� ���
		for (int i = 0; i < comp.length; i++) {
			p[i].printData();
		}
		
	}
}
