package exam_inner_class;

//외부 클래스
class StaticMemberO {
	int num;
	static int number;
	
	StaticMemberO(){
		System.out.println("O 객체가 생성됨");
	}
	
	//내부 인스턴스 멤버 클래스
	class StaticMemberII{
		int field1;
//		static int value; //인스턴스 멤버 클래스는 static 멤버를 가질 수 없다.
		static final int SU = 10;
		StaticMemberII(){
			num = 5;	//정적 멤버 클래스는 인스턴스 멤버를 가질 수 없다.
			number = 3;
			System.out.println("II 객체가 생성됨");
		}
		
		//static 메소드를 가질 수 없다.
//		static int getValue() {
//			return value;
//		}
		
		void method1() {
			System.out.println("field1 : " + field1);
		}

		//static 메소드를 가질 수 없다.
//		static void method2() {
//			System.out.println("value : " + value);
//		}
	}
	
	//내부 정적 멤버 클래스
	//프로그램 실행 시 할당
	static class StaticMemberSI{
		
		//해당 내부 클래스 객체화 시 주소할당
		int field1;	
		
		//프로그램 실행 시 할당
		static int field2;	
		StaticMemberSI(){
//			num = 10;	//정적 멤버 클래스는 외부 클래스의 인스턴스 멤버를 가질 수 없다.
			number = 9;
			System.out.println("SI 객체가 생성됨");
		}
		
		//해당 내부 클래스 객체화 시 주소할당 (메소드 영역에는 올라있음)
		void method1() {
			System.out.println("field1 : " + field1);
//			method(2);	//정적 멤버 클래스틑  외부 클래스의 인스턴스 멤버를 가질 수 없다.
		}
		
		static void method2() {
			System.out.println("field2 : " + field2);
		}
	}
	
	void method(int value) {
		
	}
}
