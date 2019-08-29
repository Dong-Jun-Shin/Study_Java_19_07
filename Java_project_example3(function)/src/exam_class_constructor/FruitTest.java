package exam_class_constructor;

public class FruitTest {
	public static void main(String[] args) {
		Fruit fruit1 = new Fruit("banana", 4800);
		Fruit fruit2 = new Fruit("strawberry", 21000);
		Fruit fruit3 = new Fruit("persimmon", 19000);
		Fruit fruit4 = new Fruit("cherry", 12000);
		
		int total = 0;
		double dcPrice = 0;
		
		total = fruit1.total(total);
		total = fruit2.total(total);
		total = fruit3.total(total);
		total = fruit4.total(total);
		
		dcPrice = Fruit.dcOper(total, dcPrice);
		
		
		Fruit.printFrontFrame();
		
		System.out.println(fruit1.toString());
		System.out.println(fruit2.toString());
		System.out.println(fruit3.toString());
		System.out.println(fruit4.toString());
		
		Fruit.printBackFrame();
		
		Fruit.printFrame(total, dcPrice);
	}
}
