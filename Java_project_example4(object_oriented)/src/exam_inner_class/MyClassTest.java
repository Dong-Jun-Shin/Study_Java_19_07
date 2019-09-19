package exam_inner_class;

interface MyInterface{
	public void print();
}

class MyClass1 implements MyInterface{
	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}

class MyClass2 implements MyInterface{
	@Override
	public void print() {
		System.out.println("MyClass2");
	}
}


public class MyClassTest {
	public static void test(MyInterface mif) {
		mif.print();
	}
	
	public static MyInterface test2() {
		MyInterface mif = new MyInterface(){
			@Override
			public void print() {
				System.out.println("메소드로 선언 및 생성");
			}
		};
		
		return mif;
	}
	
	public static void main(String[] args) {
		//인터페이스의 다형성으로 생성
		MyInterface mif = new MyClass1();
		mif.print();
		test(mif);
		
		mif = new MyClass2();
		mif.print();		
		test(mif);
		
		//무명클래스로 정의 및 생성
		mif = new MyInterface() {
			@Override
			public void print() {
				System.out.println("Anonymous");
			}
		};
		mif.print();
		test(mif);
		
		//무명클래스를 정의, 생성한 후 바로 결과물(객체)로 접근해서 호출
		(new MyInterface() {
			@Override
			public void print() {
				System.out.println("선언, 생성, 호출을 한번에 처리");
			}
		}).print();
		System.out.println();
		
		MyInterface mif2 = test2();
		mif2.print(); //test2() 메소드에서 반환된 MyInterface
		
	}
	
}
