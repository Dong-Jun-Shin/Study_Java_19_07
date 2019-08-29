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

	//연산을 위한 메소드
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

	//출력을 위한 메소드
	public static void printFrontFrame() {
		System.out.println("============== 과일구입 목록 =============");
	}

	public static void printBackFrame() {
		System.out.println("-------------------------------------");
	}

	public static void printFrame(int total, double dcPrice) {
		System.out.println("총금액 : " + total + "원");
		System.out.println("할인 후 결제 금액 : " + (int) dcPrice + "원");
	}
}
