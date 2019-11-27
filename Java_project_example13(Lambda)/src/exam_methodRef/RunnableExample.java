package exam_methodRef;

//1초 간격으로 콘솔 영역에 10~1를 출력할 수 있도록 정의
//람다식으로 정의
//메서드 참조로 정의
//프린트 p.13 참조
public class RunnableExample {

	public static void execute() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Runnable ra = () -> {
			for (int i = 10; i > 0; i--) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread th = new Thread(ra);
		th.start();

		new Thread(() -> {
			for (int i = 10; i > 0; i--) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(RunnableExample::execute).start();
	}
}
