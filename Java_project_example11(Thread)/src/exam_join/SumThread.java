package exam_join;

public class SumThread extends Thread{
	private int first, last;
	private int sum;
	
	public SumThread(int first, int last) {
		this.first = first;
		this.last = last;
	}
	
	@Override
	public void run() {
		for (int i = first; i <= last; i++) {
			sum += i;
		}
	}

	public int getSum() {
		return sum;
	}	
	
	public static void main(String[] args) {
//		Thread t1 = new SumThread(1, 5);
//		Thread t2 = new SumThread(6, 10);
		SumThread t1 = new SumThread(1, 5);
		SumThread t2 = new SumThread(6, 10);
		int t1s, t2s, tot;
		
		t1.start();
		t2.start();

		//계산에서 출력 사이에 계산이 끝날 시간을 주어야 한다.
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		t1s = ((SumThread)t1).getSum();
//		t2s = ((SumThread)t2).getSum();
		t1s = t1.getSum();
		t2s = t2.getSum();
		tot = t1s + t2s;
				
		System.out.println("Thread1(1, 5) sum :" + t1s);
		System.out.println("Thread2(6, 10) sum :" + t2s);
		System.out.println("Total sum : " + tot);
	}
}
