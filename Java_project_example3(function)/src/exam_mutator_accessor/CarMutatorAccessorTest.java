package exam_mutator_accessor;

public class CarMutatorAccessorTest {
	public static void main(String[] args) {
		CarMutatorAccessor myCar = new CarMutatorAccessor();

		//������ �޼ҵ� ȣ��
		myCar.setColor("red");
		//myCar.color = "red";
		
		myCar.setSpeed(100);
		myCar.setGear(1);

		//myCar.setSpeed(-80);

		//������ �޼ҵ� ȣ��
		System.out.println("========= ������ �޼ҵ� ȣ��� �ʵ� ��� ========");
		System.out.println("���� �ڵ����� ���� : " + myCar.getColor());
		System.out.println("���� �ڵ����� �ӵ� : " + myCar.getSpeed());
		System.out.println("���� �ڵ����� ��� : " + myCar.getGear());
		System.out.println();
		
		System.out.println("======== toString() �޼ҵ�� ��ü �ʵ� ��� =======");
		System.out.println(myCar.toString());
	}
}
