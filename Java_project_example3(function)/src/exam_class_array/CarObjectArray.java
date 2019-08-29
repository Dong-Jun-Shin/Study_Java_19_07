package exam_class_array;

public class CarObjectArray {
	public static void main(String[] args) {

		//		Car c1, c2, c3, c4, c5;
		//		c1 = new Car();
		//		c2 = new Car();
		//		c3 = new Car();
		//		c4 = new Car();
		//		c5 = new Car();
		//		System.out.println(c1.toString());
		//		System.out.println(c2.toString());
		//		System.out.println(c3.toString());
		//		System.out.println(c4.toString());
		//		System.out.println(c5.toString());

		final int NUM_CARS = 5;
		Car[] cars = new Car[NUM_CARS];

		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car();
			//cars[i].carData();
		}

		for (int i = 0; i < cars.length; i++) {
			cars[i].speedUp();
		}

		for (int i = 0; i < cars.length; i++) {
			System.out.println("ÀÚµ¿Â÷(" + (i + 1) + ") " + cars[i].toString());
		}
	}
}
