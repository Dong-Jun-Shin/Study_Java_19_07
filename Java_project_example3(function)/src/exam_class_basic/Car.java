package exam_class_basic;

//public�� ���ð���, ���� ���ϸ�� �����ϰ� �ۼ��ؾ� �Ѵ�.
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

	//��� �ΰ��� (���ڸ� �� ���� ����Ѵ�.)
	public void printData() {
		System.out.println("�ӵ�: " + speed + " ���: " + gear + " ����: " + color);
	}

	public String toString() {
		return "�ӵ�: " + speed + " ���: " + gear + " ����: " + color;
	}
}