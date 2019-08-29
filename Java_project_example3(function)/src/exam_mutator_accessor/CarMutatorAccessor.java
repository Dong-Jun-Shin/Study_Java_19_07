package exam_mutator_accessor;

public class CarMutatorAccessor {
	// 필드 정의
	private int speed;
	private int gear;
	private String color;
	
	// 접근자, 설정자
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if(speed > 0) {
			this.speed = speed;			
		}else {
			this.speed = 0;
		}
	}

	// 접근자, 설정자
	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		if(speed > 0) {
			this.gear = gear;			
		}else {
			this.gear = 0;
		}
	}

	// 접근자, 설정자
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	//메소드
	public void speedUp(int speed) {
		this.speed += speed;
	}

	public void speedDown(int speed) {
		this.speed -= speed;
	}

	//출력 두가지 (후자를 더 많이 사용한다.)
	public void printData() {
		System.out.println("속도: " + speed + " 기어: " + gear + " 색상: " + color);
	}

	public String toString() {
		return "속도: " + speed + " 기어: " + gear + " 색상: " + color;
	}
}
