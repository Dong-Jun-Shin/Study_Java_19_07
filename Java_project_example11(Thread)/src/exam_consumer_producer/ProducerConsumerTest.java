package exam_consumer_producer;

class CakeBox{
	private String data;
	
	//wait() 메소드 : 어떤 일이 일어나기를 기다릴 때 사용하는 메소드.
	//스레드를 실행하는 중에 이 메소드를 만나면 가지고 있는 잠금을 양보하고
	//대기 상태로 들어간다.
	public synchronized String getDate() {
		if(this.data == null) {
			try {
				wait();
			} catch (InterruptedException ie) {
				//Interrupt는 하나의 스레드가 실행하고 있는 작업을 중지하도록 하는 원리.
				ie.printStackTrace();
			}
		}
		//변수에 data를 담아준다.
		String rValue = data;
		//담아준 후의 data를 비워준다.
		data = null;
		
		//notify()는 어떤 일이 일어났을 때 이를 알려주는 메소드
		//대기 상태인 스레드 중에서 하나의 스레드르 ㄹ깨운다.
		notify();
			
		return rValue;
	}
}

public class ProducerConsumerTest {
	public static void main(String[] args) {
		
	}
}
