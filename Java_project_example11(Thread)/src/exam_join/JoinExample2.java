package exam_join;

import exam_createthread.Phone;

public class JoinExample2 {
	public static void main(String[] args) {
		Phone calling = new Phone("전화 받기 : ");
		calling.start();
		
		try {
			calling.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("음식 먹기 : " + i);
		}
	}
}
