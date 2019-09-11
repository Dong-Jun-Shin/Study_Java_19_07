package exam_api_system.exam03_systemtime;

public class SystemTimeExample {
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();

		int sum = 0;
		for (int i = 0; i < 1000000; i++) {
			sum += i;
		}

		long time2 = System.currentTimeMillis();

		System.out.println("1~1000000까지의 합: " + sum);
		System.out.println("계산에 " + (time2 - time1) + " 밀리초가 소요되었습니다.");
		int minute = (int)(time2 - time1)/100*60;
		System.out.println(minute);
	}
}
