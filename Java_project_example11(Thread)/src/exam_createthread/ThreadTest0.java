package exam_createthread;

//Thread 클래스의 상속을 이용한 Thread(스레드) 생성
class Counting extends Thread {
	public Counting(String name) {
		super(name);
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + " : " + i);
		}
	}
}

public class ThreadTest0 {
	public static void main(String[] args) {
		Thread t1 = new Counting("First Thread");
		Thread t2 = new Counting("Second Thread");
		
		t1.start();
		t2.start();
	}
}
