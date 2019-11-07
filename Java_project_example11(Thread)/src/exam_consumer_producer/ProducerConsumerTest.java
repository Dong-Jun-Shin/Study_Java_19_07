package exam_consumer_producer;

class CakeBox {
	private String data;

	// wait() 메소드 : 어떤 일이 일어나기를 기다릴 때 사용하는 메소드.
	// 스레드를 실행하는 중에 이 메소드를 만나면 가지고 있는 잠금을 양보하고
	// 대기 상태로 들어간다.
	public synchronized String getData() {
		//data 비어있으면 getData를 사용하는 소비자가 wait()
		//다른 곳에서 notify()가 들어오면 다음 코드 실행
		if (this.data == null) {
			try {
				wait();
			} catch (InterruptedException ie) {
				// Interrupt는 하나의 스레드가 실행하고 있는 작업을 중지하도록 하는 원리.
				ie.printStackTrace();
			}
		}
		
		// 변수에 data를 담아준다.
		String rValue = data;
		// 담아준 후의 data를 비워준다.
		data = null;

		// notify()는 어떤 일이 일어났을 때 이를 알려주는 메소드
		// 대기 상태인 스레드 중에서 하나의 스레드르 ㄹ깨운다.
		notify();

		return rValue;
	}

	public synchronized void setData(String data) {
		// 물건은 있지만, 소비하지 않은 경우를 표현한 참
		// data가 값을 가지고 있으면 setData를 사용하는 생산자가 wait()
		// 다른 곳에서 notify()가 들어오면 다음 코드 실행
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		this.data = data;
		notify();
	}
}

class Producer implements Runnable {
	private CakeBox cake;

	public Producer(CakeBox cake) {
		this.cake = cake;
	}

	// (CakeBox)에 케익을 가져다 놓는다.
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			cake.setData("케익" + i);
			System.out.println("생산자: 케익" + i + "를 생산하였습니다.");
			try {
				// 소비하는 걸 기다림
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	}
}

class Consumer implements Runnable {
	private CakeBox cake;

	// CakeBox 참조 변수를 저장한다.
	public Consumer(CakeBox cake) {
		// (CakeBox)에서 케익을 가져온다.
		this.cake = cake;
	}

	// (CakeBox)에 케익을 소비한다.
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			String data = cake.getData();
			System.out.println("소비자: " + data + "을(를) 소비하였습니다.");
			try {
				// 생산하는 걸 기다림
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	}
}

public class ProducerConsumerTest {
	public static void main(String[] args) {
		CakeBox cb = new CakeBox();
		new Thread(new Producer(cb)).start();
		new Thread(new Consumer(cb)).start();

	}
}
