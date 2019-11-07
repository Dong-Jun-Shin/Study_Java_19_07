package exam_check_synchronized;


public class MyAccount {
	// 계좌 소유자
	private String owner;
	// 계좌 보유 금액
	private int money;

	// 생성자
	public MyAccount(String owner, int money) {
		this.owner = owner;
		this.money = money;
	}

	public String getOwner() {
		return owner;
	}

	// 예금, 하나 이상의 객체가 메소드를 사용할 수 없다.
	public synchronized void deposit(int amount, String user) {
		if (amount > 0) {
			money += amount;
			System.out.println("[" + user + "] 입금 : " + amount);
		} else {
			System.out.println("입금액이 올바르지 않습니다.");
		}
		System.out.println("["+user+"] 님이 요청한 계좌의 잔액 : " + money);
	}

	// 출금
	public synchronized void withdraw(int amount, String user) {
		if (money - amount > 0) {
			money -= amount;
			System.out.println("[" + user + "] 출금 : " + amount);
		}else {
			System.out.println("금액이 부족합니다.");
		}
		System.out.println("["+user+"] 님이 요청한 계좌의 잔액 : " + money);
	}
	
}
