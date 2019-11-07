package exam_createthread;

public class ThreadTest4 {
	public static void main(String[] args) {
		Food work1 = new Food("음식 먹기 : ");
		Phone work2 = new Phone("카톡 확인 : ");
		
		System.out.println("시작");
		work1.start();
		work2.start();
		
		System.out.println("종료");
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("TV 보기: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

		}
	}
}
