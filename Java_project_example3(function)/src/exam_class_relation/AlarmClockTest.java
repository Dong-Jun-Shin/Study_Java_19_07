package exam_class_relation;

public class AlarmClockTest {
	public static void main(String[] args) {
		//�⺻ ������
		AlarmClock defaultAT = new AlarmClock();
		System.out.println(defaultAT.toString());
		
		//�Ű����� �̿� ������
		Time a = new Time();			//Time �⺻ ������
		Time t = new Time(17, 57, 17);	//�Ű����� �̿� ������
		
		AlarmClock userAT = new AlarmClock(a, t);
		System.out.println(userAT.toString());
	}
}
