package exam_inner_class;

import exam_interface_TV.RemoteControl;
/* 
 * 무명 클래스 예제
 */
public class AnonymousClassTest1 {
	public static void main(String[] args) {
//		RemoteControl ac = new RemoteControl(); //객체 생성 불가능
		RemoteControl ac = new RemoteControl() {//무명 클래스 정의
			@Override
			public void turnOn() {
				System.out.println("TV 전원 켜기");
			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("TV 전원 끄기");
			}

			@Override
			public void setVolume(int volume) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setMute(boolean mute) {
				// TODO Auto-generated method stub
				RemoteControl.super.setMute(mute);
			}
		}; 
		ac.turnOn();
		ac.turnOff();
	}
}
