package exam_createthread;

class SaveFile extends Thread{
	public SaveFile(){
		setName("파일 저장");
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(this.getName() + " 작업 중...");
			try {
				Thread.sleep(1);			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

class ServerConnection extends Thread{
	public ServerConnection() {
		setName("서버 연결");
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(this.getName() + " 작업 중...");
		}
	}
}


public class MyThreadTest {
	public static void main(String[] args) {
		Thread t1  = new SaveFile();
		Thread t2  = new ServerConnection();
		
		t1.start();
		t2.start();
	}
}
