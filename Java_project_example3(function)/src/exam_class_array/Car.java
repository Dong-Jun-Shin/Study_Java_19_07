package exam_class_array;

public class Car {
	private int speed;
	private int gear;
	private String color;

	//����Ʈ �����ڷ� �� �� ����
	public Car() {
		speed = 80;
		gear = 1;
		color = "red";
	}

	//�޼ҵ带 �̿��� �� ����
	//	public void carData(){
	//		speed = 80;
	//  	gear = 1;
	//  	color = "red";

	public void speedUp() {
		speed += 10;
	}

	public String toString() {
		return "�ӵ�: " + speed + " ��� : " + gear + " ����: " + color;
	}
}
