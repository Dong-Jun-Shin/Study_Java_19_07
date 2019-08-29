package exam_class_relation;

// "Time"과 "AlarmClock"의 집합 관계
public class AlarmClock {
	private Time currentTime; //Time 객체 참조 변수
	private Time alarmTime; //Time 객체 참조 변수

	public AlarmClock() {
		alarmTime = new Time(5, 30, 0);
		currentTime = new Time(13, 0, 0);
	}

	public AlarmClock(Time a, Time c) {
		alarmTime = a;
		currentTime = c;
	}

	public String toString() {
		return "AlarmClock [ alarm : " + alarmTime.toString() + ", current : " + currentTime.toString() + " ]";
	}
}
