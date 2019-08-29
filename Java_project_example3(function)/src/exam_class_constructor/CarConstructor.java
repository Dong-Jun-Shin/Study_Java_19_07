package exam_class_constructor;

public class CarConstructor {
	private int speed;
	private int gear;
	private String color;
	
	//����Ʈ ������
	public CarConstructor() {
		/*
		 * speed = 0;
		 * gear = 1;
		 * color = "red";
		 */
		this(0, 1, "red"); //�����ڸ� ȣ���ؼ� ������ ���� �־��ش�.
	}
	
	//������,  ȣ��� ���� ������ �ش� �����ڸ� �̿��ؼ� �������ش�.
	public CarConstructor(int speed, int gear, String color) {
		this.speed = speed;
		this.gear = gear;
		this.color = color;
	}
	
	public String toString() {
		return "�ڵ��� ���� [�ӵ�  = " + speed + ", ��� = " + gear + ", ���� = " + color + "]";
	}
}


