package exam_class_constructor;

public class FruitEx {
	private String[] fname;
	private int[] price;
	private String str = "";

	//getter, setter
	public void setFruitEx1(String... fname) {
		this.fname = fname;
	}

	public void setFruitEx1(int... price) {
		this.price = price;
	}

	//������ ���� �޼ҵ�
	public int total(int total) {
		for (int i = 0; i < price.length; i++) {
			total += price[i];
		}

		return total;
	}

	public static double dcOper(int total, double dcPrice) {
		return dcPrice = (double) total * 0.85;
	}

	public String toString() {
		for (int i = 0; i < fname.length; i++) {
			str += fname[i] + " : " + price[i] + ((i == fname.length - 1) ? "" : "\n");
		}

		return str;
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
		System.out.println("���� �� ���� �ݾ� : " + (int) dcPrice + "��");
	}
}
