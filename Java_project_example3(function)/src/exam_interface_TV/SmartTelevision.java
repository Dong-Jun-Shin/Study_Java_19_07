package exam_interface_TV;

//구현 클래스
public class SmartTelevision implements RemoteControl, Searchable {
	private int volume;

	@Override
	public void search(String url) {
		System.out.println("구글에 \"" + url + "\" 검색합니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("SmartTelevision 켜기");
	}

	@Override
	public void turnOff() {
		System.out.println("SmartTelevision 끄기");
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

	@Override
	public String toString() {
		return "SmartTelevision [volume=" + volume + "]";
	}
	
	

}
