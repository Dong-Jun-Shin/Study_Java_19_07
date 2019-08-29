package exam_class_basic;

/*
 * �ּҷ��� ��Ÿ���� Address Ŭ������ �����.
 * �ּҷϿ��� �̸�(name), �ּ�(addr), ��ȭ��ȣ(tel)�� �ʵ�� ������.
 * ������ �Է¹޾� ȭ�鿡 ��ü �ʵ��� ������ ��µǵ��� �ۼ��Ѵ�.
 */
public class Address {
	public String name;
	public String addr;
	public String tel;
	
	public void getData(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	
	public void printData() {
		System.out.printf("%s %-20s %s/n", name, addr, tel);
	}
	
	public String toString() {
		return "�̸� : " + name + " �ּ� : " + addr + " ��ȣ : " + tel + "\n";
	}
	
}
