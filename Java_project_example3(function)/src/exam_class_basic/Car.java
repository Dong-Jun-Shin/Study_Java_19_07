package exam_class_basic;

//public은 선택가능, 사용시 파일명과 동일하게 작성해야 한다.
public class Car {
	public int speed;
	public int gear;
	public String color;

	public void inputData(int s, int g, String c){
		speed = s;
		gear = g;
		color = c;
	}
	
	public void speedUp(int s) {
		speed += s;
	}

	public void speedDown(int s) {
		speed -= s;
	}

	//출력 두가지 (후자를 더 많이 사용한다.)
	public void printData() {
		System.out.println("속도: " + speed + " 기어: " + gear + " 색상: " + color);
	}

	public String toString() {
		return "속도: " + speed + " 기어: " + gear + " 색상: " + color;
	}
}