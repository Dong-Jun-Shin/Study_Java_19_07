package exam_interface_TV;

public class Radio implements RemoteControl{
	private double radioFrequency;
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("라디오의 전원이 켜졌습니다.");
	}
	@Override
	public void turnOff() {
		System.out.println("라디오의 전원이 꺼졌습니다.");
	}
	@Override
	public void setVolume(int volume) {
		if(volume > MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		}else if(volume < MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		}else {
			this.volume = volume;
		}
	}
	public void setChannel(int channel) {
		System.out.println("해당 기능이 없습니다.");
	}
	
	public void setFrequency(double Frequency) {
		if(Frequency <80) {
			this.radioFrequency = 80;
		}else if(Frequency > 140) {
			this.radioFrequency = 140;
		}else {
			this.radioFrequency = Frequency;
		}
	}
	
	public void printRF() {
		System.out.println("현재 주파수는 " + radioFrequency + "(hz) 입니다.");
	}
	
	public String toString() {
		return  "현재 라디오 볼륨: " + volume;
	}
}
