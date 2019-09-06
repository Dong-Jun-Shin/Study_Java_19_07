package exam_interface_TV;

public interface RemoteControl {
	//상수
	public static final int MAX_VOLUME = 32;
	/*		생략가능	 */ int MIN_VOLUME = 0;
	
	//추상 메소드
	public abstract void turnOn(); 
	public abstract void turnOff();
	/*	  생략가능	 */ void setVolume(int volume);
	
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리 합니다.");
		}else{
			System.out.println("무음 해제 합니다.");
		}
	}
}
