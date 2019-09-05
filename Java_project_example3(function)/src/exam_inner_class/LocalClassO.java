package exam_inner_class;

//외부 클래스
class LocalClassO {
	int num;
	static int number;
	
	LocalClassO(){
		System.out.println("O 객체가 생성됨");
	}
	
	//LocalClass exam
	void method(){
		//정의
		class D{
			int field3;
			D(){
				System.out.println("D 객체가 생성됨");
			}
			void method1() {
				System.out.println("field3 : " + field3);
			}
		}
		//LocalClass의 객체 생성 및 사용
		D d = new D();
		d.field3 = 1;
		d.method1();
	}
}
