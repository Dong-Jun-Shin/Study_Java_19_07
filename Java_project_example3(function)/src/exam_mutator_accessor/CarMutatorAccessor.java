package exam_mutator_accessor;

public class CarMutatorAccessor {
	// �ʵ� ����
	private int speed;
	private int gear;
	private String color;
	
	// ������, ������
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

	// ������, ������
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

	// ������, ������
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	//�޼ҵ�
	public void speedUp(int speed) {
		this.speed += speed;
	}

	public void speedDown(int speed) {
		this.speed -= speed;
	}

	//��� �ΰ��� (���ڸ� �� ���� ����Ѵ�.)
	public void printData() {
		System.out.println("�ӵ�: " + speed + " ���: " + gear + " ����: " + color);
	}

	public String toString() {
		return "�ӵ�: " + speed + " ���: " + gear + " ����: " + color;
	}
}
