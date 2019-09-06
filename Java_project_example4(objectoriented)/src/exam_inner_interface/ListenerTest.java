package exam_inner_interface;

class MessageListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("메세지를 보냅니다.");
	}
}

class CallListener implements Button.OnClickListener {
	@Override
	public void onClick() {
		System.out.println("전화를 겁니다.");
	}
}

public class ListenerTest{
	public static void main(String[] args) {
		//클래스 선언 및 생성
		//필드는 초기화되어 있는 상태(비어있음)
		Button btn = new Button();

		//인터페이스의 다형성을 이용해서 OnClickListener형의 참조변수를 정의
		//b의 필드인 listener에 매개변수를 통해 OCL형의 참조변수를 설정
		//Button.OnClickListener bi = new CallListener();
		//btn.setOnClickListener(bi);
		btn.setOnClickListener(new CallListener());

		//b.listener(=b는 bi.onClick()을 가지고 있다.)
		btn.touch();

		btn.setOnClickListener(new MessageListener());
		btn.touch();
	}
}