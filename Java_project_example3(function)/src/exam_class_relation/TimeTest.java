package exam_class_relation;

//import java.time.LocalTime;

public class TimeTest {
	public static void main(String[] args) {
//		while(true) {
//			LocalTime tok = LocalTime.now();
//			Time t = new Time(tok.getHour(), tok.getMinute(), tok.getSecond());
//			
//			System.out.println(t.toString());			
//		}
		
		//Time ��ü�� �����ϰ� �ʱ�ȭ�Ѵ�.
		Time time = new Time();
		System.out.println("�⺻ ������ ȣ�� �� �ð�: ");
		System.out.println(time.toString());
		
		//�ι�° ������ ȣ��
		Time time2 = new Time(13, 27, 6);
		System.out.println("�ι�° ȣ�� �� �ð�: ");
		System.out.println(time2.toString());
		
		//�ùٸ��� ���� �ð����� �����غ���.
		Time time3 = new Time(99, 66, 77);
		System.out.println("�ùٸ��� ���� �ð� ���� �� �ð�: ");
		System.out.println(time3.toString());
	}
}
