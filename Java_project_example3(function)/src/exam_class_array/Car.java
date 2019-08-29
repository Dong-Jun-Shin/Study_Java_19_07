package exam_class_array;

public class Car {
	private int speed;
	private int gear;
	private String color;

	//디폴트 생성자로 한 값 설정
	public Car() {
		speed = 80;
		gear = 1;
		color = "red";
	}

	//메소드를 이용한 값 설정
	//	public void carData(){
	//		speed = 80;
	//  	gear = 1;
	//  	color = "red";

	public void speedUp() {
		speed += 10;
	}

	public String toString() {
		return "속도: " + speed + " 기어 : " + gear + " 색상: " + color;
	}
}
