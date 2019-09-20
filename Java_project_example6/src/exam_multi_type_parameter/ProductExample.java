package exam_multi_type_parameter;

public class ProductExample {
	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<Tv, String>();
		product1.setKind(new Tv(48));
		product1.setModel("스마트 TV");
		System.out.println(product1.toString()+" ");
		System.out.println(product1.getKind().toString());
		
		Product<Car, String> product2 = new Product<Car, String>();
		product2.setKind(new Car());
		product2.getKind().setColor("RED");
		product2.setModel("디젤");
		System.out.println(product2.toString() + " [color : " + product2.getKind().getColor()+"]");
		
		Product<SmartPhone, String> product3 = new Product<SmartPhone, String>();
		product3.setKind(new SmartPhone("애플", "IOS"));
		product3.setModel("아이폰 6S");
		System.out.print(product3.toString() + " " + product3.getKind().toString());

	}
}
