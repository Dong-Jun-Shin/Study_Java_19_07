package exam_createthread;

//sleep을 이용한 유후시간 주기
class MyRunnable1 implements Runnable{
	@Override
	public void run() {
		for (int i = 10; i >= 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest2 {
	public static void main(String[] args) {		
	//	MyRunnable1 r = new MyRunnable1();
	//	Thread t = new Thread(r);
		
		Thread t = new Thread(new MyRunnable1());
		System.out.println("시작");
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("종료");
	}
	
}
