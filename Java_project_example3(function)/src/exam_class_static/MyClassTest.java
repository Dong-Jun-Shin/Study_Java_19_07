package exam_class_static;

class MyClass{
//	static int sValue;
//	int insValue;
	
	//초기화할 경우, 생성자() > 초기화 블록(클래스, 인스턴스) = 일반적인 변수초기화
	
	static int sValue = 100; //클래스 변수
	int insValue = 200;
	
	//클래스 변수(정적 멤버) 초기화 블록 - static은 static으로 초기화
	static {
		sValue = 300;
//		insValue = 600;  //Non-static 오류
	}
	
	//인스턴스 변수 초기화 블록 - 인스턴스 변수는 (Non-static, static) 가능
	{
		sValue = 500;
		insValue = 500;
	}
	
	public MyClass() {
		sValue = 600;    //생성자에서는 static 없이 가능
		insValue = 600;
	}
	
	public void display() {
		System.out.println("sValue : " + sValue);
		System.out.println("insValue : " + insValue);
	}
}

public class MyClassTest {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		obj.display();
	}
}
