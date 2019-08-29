package exam_class_constructor;

public class Fruit {
	private String fname;
	private int price;

	//getter, setter�� �̿��� ����
	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFname() {
		return fname;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	
	//����Ʈ �����ڿ� ������
	public Fruit() {
		this("", 0);
	}

	public Fruit(String fname) {
		this(fname, 0);
	}

	public Fruit(int price) {
		this("", price);
	}

	public Fruit(String fname, int price) {
		this.fname = fname;
		this.price = price;
	}

	//������ ���� �޼ҵ�
	public int total(int total) {
		total += price;

		return total;
	}

	public String toString() {
		return fname + " : " + price;
	}

	
	//����� ���� �޼ҵ�
	public static void printFrontFrame() {
		System.out.println("============== ���ϱ��� ��� =============");
	}

	public static void printBackFrame() {
		System.out.println("-------------------------------------");
	}

	public static void printFrame(int total, double dcPrice) {
		System.out.println("�ѱݾ� : " + total + "��");
		System.out.println("���� �� ���� �ݾ� : " + (int)dcPrice + "��");
	}
	
	public static double dcOper(int total, double dcPrice) {
		return dcPrice = (double) total * 0.85;
	}
}
