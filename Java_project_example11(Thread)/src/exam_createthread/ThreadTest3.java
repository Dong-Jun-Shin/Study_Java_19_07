package exam_createthread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/*
 * 간단한 경마 게임
 * 난수를 매개변수로 하여 sleep()을 호출하는 스레드를 여러 개 생성한다.
 * 
 */

class Horse implements Runnable{
	private String name;
	private int sleepTime;
	private int money;
	private final static Random generator = new Random();
	private final static Random moneyGenerator = new Random();
	
	public Horse(String name) {
		this.name = name;
		sleepTime = generator.nextInt(3000);
		money = moneyGenerator.nextInt(10000000);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void run() {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println(name + "마가 경주를 도착하였습니다.");
	};
}

public class ThreadTest3 {
	public static void main(String[] args) {
		Horse[] h = {new Horse("1번"), new Horse("2번"), new Horse("3번"), new Horse("4번"), new Horse("5번")};
		
		TreeMap<String, Integer> mArrey = new TreeMap<String, Integer>();
		
		for (int i = 0; i < h.length; i++) {
			mArrey.put(h[i].getName(), h[i].getMoney());
		
		
//		Map.Entry<K, V> a = mArrey.lastEntry();
		}
		
	}
}
