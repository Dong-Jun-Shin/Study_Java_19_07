package exam_instanceof;

public class instanceofExample {
	//형변환 전 검사O
	public static void method1(Parent parent) { //Parent parent = parentA
		if(parent instanceof Child) {
			Child child = (Child) parent;
			child.field2 = "Chile로 변환 성공";
			System.out.println("method1 - " + child.field2);
		}else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
	}
	
	//형변환 전 검사X
	public static void method2(Parent parent) {
		Child child = (Child) parent;
		child.field2 = "Child로 변환 성공";
		System.out.println("method2 - " + child.field2);
	}
	
	public static void main(String[] args) {
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA); 
		
		Parent parentB = new Parent();
		method1(parentB);
		
		//Parent instanceof Child == False
		//(업캐스팅 하지 않은 걸, 다운캐스팅 해서 오류)
		//형이 달라서 오류 -> 그래서 검증이 필요
		//method2(parentB); 
		
	}
}
