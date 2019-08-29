package exam_class_constructor;

public class FruitExTest {
	public static void main(String[] args) {
		FruitEx fruit = new FruitEx();
		fruit.setFruitEx1("banana", "strawberry", "persimmon", "cherry");
		fruit.setFruitEx1(4800, 21000, 19000, 12000);
		
		int total = 0;
		double dcPrice = 0;
		
		total = fruit.total(total);
		
		dcPrice = Fruit.dcOper(total, dcPrice);
		
		
		Fruit.printFrontFrame();
		
		System.out.println(fruit.toString());
		
		Fruit.printBackFrame();
		
		Fruit.printFrame(total, dcPrice);
	}
}
