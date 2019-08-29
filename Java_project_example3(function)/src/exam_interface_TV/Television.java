package exam_interface_TV;

public class Television implements RemoteControl {
	private int volume;
	private int channel;

	@Override
	public void turnOn() {
		//실제로 TV의 전원을 켜기 위한 코드 작성
		System.out.println("TV 켜기");
	}

	@Override
	public void turnOff() {
		//실제로 TV의 전원을 끄기 위한 코드 작성
		System.out.println("TV 끄기");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}

	}

	public void setChannel(int channel) {
		if(channel > 0 ) {
			this.channel = channel;			
		}else {
			this.channel = 0;
		}
	}
	
	public void setFrequency(double Frequency) {
		System.out.println("해당 기능이 없습니다.");
	}

	public void printChannel() {
		System.out.println("현재 채널 선택은" + channel + "번 입니다.");
	}

	public String toString() {
		return "현재 TV 볼륨: " + volume;
	}

	

}
