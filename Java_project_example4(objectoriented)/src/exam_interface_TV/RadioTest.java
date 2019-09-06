package exam_interface_TV;

public class RadioTest {
	public static void main(String[] args) {
		Radio radio = new Radio();
		radio.turnOn();
		
		radio.setFrequency(150);
		radio.setVolume(50);
		radio.printRF();
		System.out.println(radio.toString());
		
		radio.setFrequency(50);
		radio.setVolume(-1);
		radio.printRF();
		System.out.println(radio.toString());
		
		radio.setFrequency(97.1);
		radio.setVolume(5);
		radio.printRF();
		System.out.println(radio.toString());
		
		radio.turnOff();
	}
}
