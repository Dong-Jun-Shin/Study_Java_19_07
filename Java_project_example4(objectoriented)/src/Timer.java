import java.time.LocalDateTime;

public class Timer {
	public static void main(String[] args) {
		int t_s = 0, t_e = 0;
		int st = 0, et = 0;
		int i = 1;
		int second;
		/*
		 * // 1초 타이머 LocalDateTime s = LocalDateTime.now(); while (t_s != 1) {
		 * LocalDateTime ms = LocalDateTime.now(); t_s = s.getSecond(); t_e =
		 * ms.getSecond();
		 * 
		 * t_s = t_e - t_s;
		 * 
		 * if (i == 1) { st = (int) System.nanoTime(); } } et = (int) System.nanoTime();
		 * second = et - st;
		 * 
		 * System.out.println("1초가 지났습니다.");
		 */
		
		// 시간초 출력
		for (i = 0; i < 10000000; i++) {
			// 시작 시간
			LocalDateTime s = LocalDateTime.now();
			//while (t_s != 1)로 설정할 경우, 
			//(s와 ms의 차)t_s의 값은 0->1로 향한다.
			// 이 때, 오차에 의해서 1이상의 값으로 점점 커지게 되고,
			//2를 넘게 되어, 초가 출력되지 않고 while문에 갇히게 된다.
			//그래서 (t_s == 0)로 설정해서 차가 0이면 반복하고, 그 이외면
			//끝내도록 만든다. 이 경우, 오차로 점점 늘어지더라도 t_s는 다시 잡히게 된다.
			while (t_s == 0) {
				// 현재 시간
				LocalDateTime ms = LocalDateTime.now();
				// 초단위(byte)로 변환
				t_s = s.getSecond();
				t_e = ms.getSecond();

				// 경과 시간(초)
				t_s = t_e - t_s;

				if (i == 100) {
					st = (int) System.nanoTime();
				}

			} // 시간초 차이를 초기화, 안할 경우 반복 조건문이 계속 참인 상태여서 다 넘어간다.
			t_s = 0;
					
			//시간을 출력
			System.out.println((i + 1) + "초");	
			
		}
		et = (int) System.nanoTime();

		second = et - st;

		System.out.println("--------------------");
		System.out.println(st);
		System.out.println(et);
		System.out.println("--------------------");
		System.out.println(second);
	}
}
