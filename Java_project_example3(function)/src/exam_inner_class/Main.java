package exam_inner_class;

public class Main {
	//Main of MemberClass
	//	public static void main(String[] args) {
	//		A a = new A();
	//		
	//		A.B b = a.new B();
	//		b.field1 = 3;
	//		b.method1();
	//		
	//		System.out.println();
	//		
	//		//직접접근 가능
	//		System.out.println(a.num);
	//		System.out.println(A.number);
	//		System.out.println(b.field1);
	//	}

	//Main of OuterToInner
	//	public static void main(String[] args) {
	//		OuterClass oc = new OuterClass();
	//		oc.outerMethod();
	//		
	//		OuterClass.InnerClass ic = oc.new InnerClass();
	//		ic.innerMethod();
	//	}

	//Main of OverMemberO
	//	public static void main(String[] args) {
	//		
	//		//OverMemberO o = new OverMemberO();
	//		//OverMemberO.OverMemberI i = o.new OverMemberI();
	//		OverMemberO.OverMemberI i = new OverMemberO().new OverMemberI();
	//		
	//		
	//		i.method();
	//		System.out.println(i.num);
	//		System.out.println(o.num);
	//		
	//	}
	
	
	//Main of StaticMemberO
//	public static void main(String[] args) {
//		StaticMemberO o = new StaticMemberO();
//		
//		StaticMemberO.StaticMemberII ii = o.new StaticMemberII();
//		ii.field1 = 3;	//일반 필드
//		ii.method1();	//일반 메소드
//		System.out.println();
//
//		//static은 다이렉트라서 생성자를 '외부클래스.정적 내부 생성자'로 만든다.
//		StaticMemberO.StaticMemberSI si =new StaticMemberO.StaticMemberSI();
//		si.field1 = 3;	//일반 필드
//		si.method1();	//일반 메소드 접근
//		StaticMemberO.StaticMemberSI.field2 = 5;	//정적 필드
//		StaticMemberO.StaticMemberSI.method2();		//정적 메소드 접근
//		System.out.println();
//		
//	}
	
	//Main of LocalClass
	public static void main(String[] args) {
		LocalClassO o = new LocalClassO();
		o.method();
	}
}
