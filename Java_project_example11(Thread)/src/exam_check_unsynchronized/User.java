package exam_check_unsynchronized;


//사용자는 동시에 account에 접근할 수 있으므로 thread로 생성
public class User extends Thread{
	//사용자명
	private String userName; 
	//사용자가 사용하는 계좌
	private MyAccount account; 

	public User(String userName, MyAccount account) {
		this.userName = userName;
		this.account = account;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			//200 ~ 400
			int m = (((int)(Math.random()*3)*100)+200); 
			if(i%2==0) {
				account.withdraw(m, userName);
			}else {
				account.deposit(m,  userName);
			}
			//시간간격을 두고 실행을 시키기 위해
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
