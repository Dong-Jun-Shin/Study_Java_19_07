package exam_inner_class;

//추상 클래스
abstract class AsInner {
	int x;
	int y;

	public AsInner(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void display(String data); //추상 메소드
}

class AsOuter {
	public void outerDisplay(AsInner obj) {
		//받은 매개변수가 가지고 있는 display메소드에 
		//"Outer.display"를 매개변수로 넘겨주고 실행.
		obj.display("Outer.display");
	}

}

class AsInnerExtend extends AsInner {
	public AsInnerExtend(int x, int y) {
		super(x, y);
	}

	public void display(String data) {
		System.out.println("display(" + data + ")" + x + " " + y);
	}
}

public class AnonymousClassTest2 {
	public static void main(String[] args) {
//		---------------------------------------------------------

//		추상클래스로 무명클래스를 정의
		AsInner ai = new AsInner(4, 5) {
			@Override
			public void display(String data) {
				System.out.println("AsInner : " + data);
			}
		};
		ai.display("추상에서 바로 재정의");
		
//		---------------------------------------------------------		

//		상속을 받은 후 서브클래스로 무명클래스를 정의 후 대입
//		(이 경우에는 클래스 생성 후, 메소드 재정의한것과 같음)
		AsInnerExtend aie = new AsInnerExtend(2, 3) {
			@Override
			public void display(String data) {
				System.out.println("AsInnerExtend : " + data);
			}
		};
		aie.display("상속 후 서브로 재정의");
		
//		---------------------------------------------------------
		
//		상속 받은 하위 클래스를 부모타입 매개변수로 주기
//		AsInnerExtend as = new AsInnerExtend(10, 20); //AsInner 하위 클래스
//		AsOuter out = new AsOuter();
//		out.outerDisplay(as);
//		------------------------------------------
//		outerDisplay(AsInner obj) 업캐스팅으로 받았다.
//		AsInner <- AsInnerExtend
//		------------------------------------------
		
//		---------------------------------------------------------

		//		outerDisplay(AsInner obj)의 매개변수 자리에
//		무명클래스 정의 및 오버라이딩을 해서 전달한 것
		AsOuter out = new AsOuter();
		out.outerDisplay(new AsInner(20, 10){
			@Override
			public void display(String data) {
				System.out.println("AsInner.display("+data+"):"+x+","+y);
			}
		});	
	}
}
