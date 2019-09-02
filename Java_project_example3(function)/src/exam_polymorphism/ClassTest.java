package exam_polymorphism;

class A{
	int a= 10;
	void b() {
		System.out.println("A클래스의 A");
	}
}

class AA extends A{
	int a = 20;
	void b() {
		System.out.println("AA클래스의 AA");
	}
	void c() {
		System.out.println("AA클래스의 C");
	}
}

class BB extends A{
	int a = 30;
	void b() {
		System.out.println("BB클래스의 BB");
	}
	void d() {
		System.out.println("BB클래스의 D");
	}
}
public class ClassTest {
	public static void main(String[] args) {
		//A a1 = new A();
		//AA a2 = new AA();
		
		A z = new AA(); // AA 객체를 생성해서 A타입의 레퍼런스(참조변수)에 할당한다.
		System.out.println(z.a);
		z.b();
		//z.c();  //업캐스팅 상태에서 서브를 참조해서 오류
		((AA)z).c(); //강제형변환으로 다운캐스팅 사용
		
		AA a1 = (AA)z; //다운캐스팅 한 것을 서브변수에 대입
		System.out.println(a1.a);
		a1.c();
		
		z = new BB();
		System.out.println(z.a);
		z.b();
		((BB)z).d();
		System.out.println();
		
		//다형성(업캐스팅, 배열 이용)
		A[] za = new A[2];
		za[0] = new AA();
		za[1] = new BB();
		
		//출력 (for, foreach)
		for (int i = 0; i < za.length; i++) {
			za[i].b();
		}
		
		for (A a : za) {
			a.b();
		}
	}
}



