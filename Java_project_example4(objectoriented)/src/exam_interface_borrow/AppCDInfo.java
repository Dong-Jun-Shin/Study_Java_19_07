package exam_interface_borrow;

public class AppCDInfo extends CDInfo implements Lendable {
	private String borrower;
	private String checkOutDate;
	private boolean state;
	
	public AppCDInfo(int registerNo, String title) {
		super(registerNo, title);
		this.state = true;
	}

	protected final String getBorrower() {
		return borrower;
	}

	protected final void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	protected final String getCheckOutDate() {
		return checkOutDate;
	}

	protected final void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	protected final boolean isState() {
		return state;
	}

	protected final void setState(boolean state) {
		this.state = state;
	}

	@Override
	public void checkOut(String borrower, String date) {
		if(!isState()) {
			System.out.println("현재 CD가 없습니다.");
			return;
		}
		
		setBorrower(borrower);
		setCheckOutDate(date);
		setState(false);
		
		System.out.printf("*%s CD가 대출되었습니다.\n", getTitle());
		System.out.printf("대출인:%s\n대출일:%s\n\n", getBorrower(), getCheckOutDate());
	}

	@Override
	public void checkIn() {
		if(isState()) {
			System.out.println("이미 책이 반납되었습니다.");
			return;
		}
		
		setState(true);
		System.out.printf("*%s 이(가) 반납되었습니다.\n\n", getTitle());
	}

}
