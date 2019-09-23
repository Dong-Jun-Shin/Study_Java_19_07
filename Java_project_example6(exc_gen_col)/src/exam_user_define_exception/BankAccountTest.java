package exam_user_define_exception;

//사용자 정의 예외 클래스 선언
@SuppressWarnings("serial")
class NegativeBalanceException extends Exception{
	public NegativeBalanceException() {}
	public NegativeBalanceException(String message) {
		super(message);
	}
}

class BankAccount{
	private int balance=0;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	public void withdraw(int amount) throws NegativeBalanceException{
		if(balance < amount)
			throw new NegativeBalanceException("잔고부족: " + (amount - balance)+"원 모자람");
		balance -= amount;
	}
}

public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		ba.deposit(10000);
		try {
			ba.withdraw(20000);			
		}catch(NegativeBalanceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
