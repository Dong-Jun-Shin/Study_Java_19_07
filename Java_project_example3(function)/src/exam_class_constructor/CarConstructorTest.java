package exam_class_constructor;

public class CarConstructorTest {
	public static void main(String[] args) {
		//����Ʈ ������
		CarConstructor car = new  CarConstructor();
		System.out.println(car.toString());

		//������
		CarConstructor car1 = new  CarConstructor(5,2,"Yellow");
		System.out.println(car1.toString());
		
	}
}
