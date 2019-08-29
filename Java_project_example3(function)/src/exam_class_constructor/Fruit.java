package exam_class_constructor;

public class Fruit {
	private String fname;
	private int price;

	//getter, setter를 이용한 설정
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

	
	//디폴트 생성자와 생성자
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

	//연산을 위한 메소드
	public int total(int total) {
		total += price;

		return total;
	}

	public String toString() {
		return fname + " : " + price;
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
		System.out.println("할인 후 결제 금액 : " + (int)dcPrice + "원");
	}
	
	public static double dcOper(int total, double dcPrice) {
		return dcPrice = (double) total * 0.85;
	}
}
