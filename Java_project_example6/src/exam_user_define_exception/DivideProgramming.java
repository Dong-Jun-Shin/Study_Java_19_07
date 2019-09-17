package exam_user_define_exception;

@SuppressWarnings("serial")
class DivideByZeroException extends ArithmeticException {
	private String msg;
	
	//첫번째 생성자를 이용한 메세지 출력
	public DivideByZeroException() {
		super("1. 0으로 나눌 수 없음.");
	}

	public DivideByZeroException(String msg) {
		this.msg = msg;
	}

	//두번째 오버라이딩 메소드를 해서 메세지 출력
	@Override
	public String getMessage() {
		if (msg == null) {
			return "2. 0으로 나눌 수 없음.";
		} else {
			return msg;
		}
	}
}

public class DivideProgramming{
	public static void main(String[] args) {
		double result;
		try {
			result = quotient(1, 0);
			System.out.println(result);
		} catch (DivideByZeroException e) {
			System.out.println(e.getMessage());
			//			System.out.println(e.toString());
		}
	}
	
	public static double quotient(int n, int d) throws DivideByZeroException{
		if (d == 0)
			throw new DivideByZeroException();
		return (double) n / d;
	}
}