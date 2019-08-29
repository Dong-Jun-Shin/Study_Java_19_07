package exam_class;



public class PlaneTest {
	public static void main(String[] args) {
		//디폴트 생성자
		Plane plane0 = new Plane();
		System.out.println(plane0.toString());
		
		
		//생성자 (매개변수 3개)
		Plane plane1 = new Plane("에어버스", "A380", 500);
		System.out.println(plane1.toString());
		
		
		//생성자 (매개변수 2개)
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
		
		System.out.printf("항공정보[제작사 : %s\t, 모델 : %s\t, 최대 승객수 : %3d]", ProductComp, model, personNum);
		System.out.println("\n");
		System.out.println("생성된 항공기 수: " + Plane.getPlanes());
		
		
	}
}
