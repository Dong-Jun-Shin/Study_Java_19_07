package exam_class;



public class PlaneTest {
	public static void main(String[] args) {
		//����Ʈ ������
		Plane plane0 = new Plane();
		System.out.println(plane0.toString());
		
		
		//������ (�Ű����� 3��)
		Plane plane1 = new Plane("�������", "A380", 500);
		System.out.println(plane1.toString());
		
		
		//������ (�Ű����� 2��)
		Plane plane2 = new Plane("BOEING","B737");
		System.out.println(plane2.toString());
		
		//getter, setter
		String ProductComp, model;
		int personNum;
		
		Plane plane3 = new Plane();
		plane3.setProductComp("BOMBARDIER");
		ProductComp = plane3.getProductComp();
		
		plane3.setModel("CS300");
		model = plane3.getModel();
		
		plane3.setPersonNum(150);
		personNum = plane3.getPersonNUm();
		
		System.out.printf("�װ�����[���ۻ� : %s\t, �� : %s\t, �ִ� �°��� : %3d]", ProductComp, model, personNum);
		System.out.println("\n");
		System.out.println("������ �װ��� ��: " + Plane.getPlanes());
		
		
	}
}
