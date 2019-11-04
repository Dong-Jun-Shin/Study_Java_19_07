package exam_createthread;

//Runnable 인터페이스를 이용한 Thread(스레드) 생성
class MyRunnable implements Runnable{
	String myName;
	
	public MyRunnable(String name) {
		myName = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(myName + i);
		}
	}
}

public class ThreadTest1 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable("First Thread"));
		Thread t2 = new Thread(new MyRunnable("Second Thread"));
		
		t1.start();
		t2.start();		
	}
}
