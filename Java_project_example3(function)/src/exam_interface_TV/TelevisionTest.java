package exam_interface_TV;

public class TelevisionTest {
	public static void main(String[] args) {
		Television tv = new Television();

		tv.turnOn();
		
		tv.printChannel();
		System.out.println(tv.toString());
		
		tv.setChannel(5);
		tv.setVolume(-1);
		tv.printChannel();
		System.out.println(tv.toString());
		
		tv.setChannel(-1);
		tv.setVolume(33);
		tv.printChannel();
		System.out.println(tv.toString());
		
		tv.turnOff();
	}
}
