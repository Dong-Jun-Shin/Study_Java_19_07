package exam_inner_class;

class A {
	int num; //public 생략
	private int pNum;
	static int number;

	//외부 A클래스 생성자 
	public A() {
		System.out.println("A객체가 생성됨");
	}

	//인스턴스 멤버 클래스
	class B {
		int field1;
		//static int value; //인스턴스 멤버 클래스는 static 멤버를 가질 수 없다.

		//내부 B클래스 생성자
		B() {
			num = 5;
			number = 3;
			pNum = 0;
			System.out.println("B 객체가 생성됨");
		}

		void method1() {
			System.out.println("num : " + num);
			System.out.println("number : " + number);
			System.out.println("field1 :" + field1);
			System.out.println("pNum : " + pNum);
		}
	}
}
