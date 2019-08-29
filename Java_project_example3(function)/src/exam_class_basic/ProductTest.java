package exam_class_basic;

public class ProductTest {
	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();

		p1.getData(1, "감자", 30);
		System.out.println(p1.toString());

		p1.stockPlus(10);
		System.out.println(p1.toString());

		p1.stockMinus(15);
		System.out.println(p1.toString());

		p1.stockPlus(5);
		System.out.println(p1.toString());
		System.out.println("-------------------------");

		p2.getData(2, "당근", 10);
		System.out.println(p2.toString());

		p2.stockPlus(3);
		System.out.println(p2.toString());

		p2.pStock = p2.stockMinus(100);
		if(p2.pStock == 0) {
			System.out.println("재고량보다 감소가 더 큽니다.");	
		}
		

		p2.stockPlus(5);
		System.out.println(p2.toString());

	}
}
