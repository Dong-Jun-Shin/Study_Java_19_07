package exam_abstract_class;

/*
 * Car 클래스를 생성하여 drive()와 stop() 추상 메서드와 3개의 메서드 startCar(), 
 * turnOff(), run()을 가진다.
 * 자동차 시동을 켜고 끄는 방법은 어느 차나 동일하다. 그래서 startCar(), turnOff()는 
 * 미리 코드를 정의해 둔다.
 * drive()와 stop()은 차종에 따라 다른 방식으로 움직일 수 있다. 그래서 추상 메소드로 선언한다.
 * run() 메소드는 다른 클래스에서 오버라이딩이 불가능하게 선언하고 위의 모든 메소드를 호출할 수 
 * 있도록 정의한다.
 * Car를 상속받는 두 클래스는 자율 주행 자동차(AICar)와 일반 자동차(ManualCar)이다.
 */
abstract class Car {
	public abstract void drive();

	public abstract void stop();

	public void startCar() {
		System.out.println("시동을 켭니다.");
	}

	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}

	public final void run() {
		startCar();
		drive();
		stop();
		turnOff();
	}

	//다형성
	public final static void run(Car car, String sel) {
		switch (sel) {
		case "AI":
			if (car instanceof AICar) {
				//다운캐스팅
				((AICar) car).stop();
				break;
			} else {
				System.out.println("사용할 수 없습니다.");
			}
		case "Manual":
			while (true) {
				if (car instanceof ManualCar) {
					//다운캐스팅
					((ManualCar) car).stop();
					break;
				} else {
					System.out.println("사용할 수 없습니다.");
					car = new ManualCar();
					System.out.println("(ManualCar를 업캐스팅 합니다.)");
				}
			}
		}

	}

	public final static void run(Car car) {
		if (car instanceof AICar) {
			car.stop();
		} else {
			System.out.println("사용할 수 없습니다.");
		}
	}
}

class AICar extends Car {
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("자율 주행합니다.");
		System.out.println("자동차가 스스로 방향을 전환합니다.");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("스스로 멈춥니다.");
	}

}

class ManualCar extends Car {
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("사람이 운전합니다.");
		System.out.println("사람이 핸들을 조작합니다.");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("브레이크로 정지합니다.");
	}

}

public class CarTest {
	public static void main(String[] args) {
		AICar car1 = new AICar();
		ManualCar car2 = new ManualCar();

		System.out.println("===== 자율주행 하는 자동차 =====");
		car1.run();
		System.out.println("===== 사람이 운전하는 자동차 =====");
		car2.run();

		System.out.println("구분선~~~~~~~~~~~~~~~~~~~~~~~~~~");

		//객체배열(업캐스팅)

		Car[] carArr = new Car[2];
		carArr[0] = new AICar();
		carArr[1] = new ManualCar();
		
		System.out.println("===== 자율주행 하는 자동차 =====");
		carArr[0].run();
		System.out.println("===== 사람이 운전하는 자동차 =====");
		carArr[1].run();

		System.out.println("구분선~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//다형성
		Car car = new AICar();

		System.out.println("-----------업캐스팅으로 AICar를 준 run()");
		Car.run(car);
		System.out.println("-----------AICar로 다운 캐스팅");
		Car.run(car, "AI");
		System.out.println("-----------ManualCar로 다운 캐스팅");
		Car.run(car, "Manual");
	}
}
