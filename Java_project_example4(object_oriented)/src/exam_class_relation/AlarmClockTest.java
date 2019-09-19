package exam_class_relation;

public class AlarmClockTest {
	public static void main(String[] args) {
		//기본 생성자
		AlarmClock defaultAT = new AlarmClock();
		System.out.println(defaultAT.toString());
		
		//매개변수 이용 생성자
		Time a = new Time();			//Time 기본 생성자
		Time t = new Time(17, 57, 17);	//매개변수 이용 생성자
		
		AlarmClock userAT = new AlarmClock(a, t);
		System.out.println(userAT.toString());
	}
}
