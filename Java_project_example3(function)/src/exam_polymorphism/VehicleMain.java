package exam_polymorphism;

interface Vehicle{
	public abstract void run();
}

class Bus implements Vehicle{
	@Override
	public void run() {
		System.out.println("버스 운행 중입니다.");
	}

	public void checkFare() {
		System.out.println("승차요금을 체크합니다.");
	}
}

class Taxi implements Vehicle{
	@Override
	public void run() {
		System.out.println("택시 운행 중입니다.");
	}
}



public class VehicleMain {
	public static void main(String[] args) {
		//Vehicle v = new Vehicle();
		Vehicle vehicle = new Bus(); //인터페이스형 참조변수에 Bus형태를 대입 
		vehicle.run(); //Bus run
		
		//vehicle.checkFare(); (x) //택시에 있는 것이기 때문에 안됨
		((Bus)vehicle).checkFare();
		
//		----------------------------------------------------------
		Bus bus = (Bus) vehicle;
		bus.run();
		bus.checkFare();
		
		//vehicle = bus 같다
	}
}
