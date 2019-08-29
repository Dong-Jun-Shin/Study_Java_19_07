package exam_class_array;

public class PhoneObjectArray {
	public static void main(String[] args) {
		System.out.println("==========각 객체 선언==========");
		Phone p1, p2, p3;
		p1 = new Phone("아이폰11", "애플");
		p2 = new Phone("갤럭시 S10", "삼성");
		p3 = new Phone("G8", "LG");
		
		p1.printData();
		p2.printData();
		p3.printData();
		System.out.println();
				System.out.println("==========객체 배열 사용==========");
		Phone[] p = new Phone[3];
		String[] name = {"아이폰11", "갤럭시 S10", "G8"};
		String[] comp = {"애플", "삼성", "LG"};
		
		//값 입력
		for (int i = 0; i < p.length; i++) {
			p[i] = new Phone(name[i], comp[i]);
		}
		
		//for ~ each문을 이용한 출력
		for (Phone ph : p) {
			ph.printData();
		}
		
		//for문을 이용한 출력
		for (int i = 0; i < comp.length; i++) {
			p[i].printData();
		}
		
	}
}
