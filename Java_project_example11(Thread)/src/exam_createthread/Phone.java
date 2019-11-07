package exam_createthread;

class Food extends Thread{
	private String myName;
	
	public Food(String name) {
		myName = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(myName + i);
			try {
				System.out.println((10-i)+"초 경과");
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}


public class Phone extends Thread{
	private String myName;
	
	public Phone(String name) {
		myName = name;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(myName + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}

		}
	}
}
