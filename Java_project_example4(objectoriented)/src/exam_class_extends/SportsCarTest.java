package exam_class_extends;

public class SportsCarTest{
	public static void main(String[] args) {
		SportsCar ss = new SportsCar();
		
		ss.gear = 4;
		ss.speed = 10;
		ss.speedUp(100);
		ss.speedDown(30);
		ss.setColor("Been");
		ss.setTurbo(true);
		ss.stop();
		
		System.out.println(ss.toString());
	}
}