package exam_polymorphism;

class Parent{
	String field1 = "10p";
	String field3 = "30p";
	
	public void method1() {
		System.out.println("Parent-method1()");
	}
	
	public void method3() {
		System.out.println("Parent-method3()");
	}
}

class Child extends Parent{
	String field2 = "20c";
	String field3 = "30c";
	
	public void method2() {
		System.out.println("Child-method2()");
	}
	
	public void method3() {
		System.out.println("Child-method3()");
	}
	
}



public class ParentTest {
	public static void main(String[] args) {
		Parent parent = new Child();

		//Parent parent;
		System.out.println(parent.field1); //10p
		System.out.println(parent.field3); //30p

		//Child parent;
		System.out.println(((Child)parent).field1); //10p
		System.out.println(((Child)parent).field2); //20c
		System.out.println(((Child)parent).field3); //30c
		
		//Parent parent;
		parent.method1(); // P 1
		parent.method3(); // C 3
		
		//Child parent;
		((Child)parent).method1(); //P 1
		((Child)parent).method2(); //C 2
		((Child)parent).method3(); //C 3
		
		
		
	}
}
