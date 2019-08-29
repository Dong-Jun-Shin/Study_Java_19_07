package exam_class_basic;
//같은 패키지 내의 클래스는 별도의 연결구문 없이 사용할 수 있다.

public class CarTest {
		public static void main(String[] args) {
			Car myCar = new Car();
			Car yourCar = new Car();
			

//			System.out.println(myCar.speed);
//			System.out.println(myCar.gear);
//			System.out.println(myCar.color);
			myCar.printData();
			System.out.println();
			
//			myCar.speed = 10;
//			myCar.gear = 1;
//			myCar.color = "Red";
			myCar.inputData(10, 1, "Red");
			
//			System.out.println(myCar.speed);
//			System.out.println(myCar.gear);
//			System.out.println(myCar.color);
			myCar.printData();
			System.out.println();
			
			myCar.speedUp(10);
			System.out.println(myCar.speed);
			
			myCar.speedUp(10);
			System.out.println(myCar.speed);
			
			myCar.speedDown(10);
			System.out.println(myCar.speed+"\n");
			
//			System.out.println(myCar.speed);
//			System.out.println(myCar.gear);
//			System.out.println(myCar.color);
			myCar.printData();
			System.out.println(myCar.toString());
			
			
			System.out.println("----------------------");
			
//			System.out.println(yourCar.speed);
//			System.out.println(yourCar.gear);
//			System.out.println(yourCar.color);
			yourCar.printData();
			System.out.println();
			
//			yourCar.speed = 5;
//			yourCar.gear = 2;
//			yourCar.color = "Yellow";
			yourCar.inputData(5, 2, "Yellow");

//			System.out.println(yourCar.speed);
//			System.out.println(yourCar.gear);
//			System.out.println(yourCar.color);
			yourCar.printData();
			yourCar.speedUp(10);
			System.out.println(yourCar.speed);
			
			yourCar.speedUp(10);
			System.out.println(yourCar.speed);
			
			yourCar.speedDown(10);
			System.out.println(yourCar.speed+"\n");
			
//			System.out.println(yourCar.speed);
//			System.out.println(yourCar.gear);
//			System.out.println(yourCar.color);
			yourCar.printData();
			System.out.println(yourCar.toString());
		}
}
