package exam_class_constructor;

public class CarConstructor {
	private int speed;
	private int gear;
	private String color;
	
	//디폴트 생성자
	public CarConstructor() {
		/*
		 * speed = 0;
		 * gear = 1;
		 * color = "red";
		 */
		this(0, 1, "red"); //생성자를 호출해서 설정된 값을 넣어준다.
	}
	
	//생성자,  호출시 값을 받으면 해당 생성자를 이용해서 생성해준다.
	public CarConstructor(int speed, int gear, String color) {
		this.speed = speed;
		this.gear = gear;
		this.color = color;
	}
	
	public String toString() {
		return "자동차 정보 [속도  = " + speed + ", 기어 = " + gear + ", 색상 = " + color + "]";
	}
}


