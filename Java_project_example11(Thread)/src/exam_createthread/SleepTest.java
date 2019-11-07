package exam_createthread;

public class SleepTest {
	
	public static void main(String[] args){
		String messages[] = {"Pridewill have a fall.", "Power is dangerous unless you have humility.", 
				"Office changes manners.", "Empty vessels make the most sound."};
		
		for (int i = 0; i < messages.length; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(messages[i]);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		System.out.println("도착");
		Thread t1 = new Counting("TV 보기");
		Thread t2 = new Counting("음식 먹기");
		Thread t3 = new Counting("카톡 확인");
		t1.start();
		t2.start();
		t3.start();
	}
}
