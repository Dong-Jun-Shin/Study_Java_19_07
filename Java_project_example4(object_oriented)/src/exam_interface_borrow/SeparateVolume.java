package exam_interface_borrow;

public class SeparateVolume implements Lendable {
	private int requestNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private boolean state;
	
	public SeparateVolume(int requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		this.state = true;
	}

	protected final int getRequestNo() {
		return requestNo;
	}

	protected final void setRequestNo(int requestNo) {
		this.requestNo = requestNo;
	}

	protected final String getBookTitle() {
		return bookTitle;
	}

	protected final void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	protected final String getWriter() {
		return writer;
	}

	protected final void setWriter(String writer) {
		this.writer = writer;
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
			System.out.println("현재 책이 없습니다.");
			return;
		}
		setBorrower(borrower);
		setCheckOutDate(date);
		setState(false);
		
		System.out.printf("*****%s(%s) 이(가) 대출되었습니다.\n", this.bookTitle, this.writer);
		System.out.printf("대출인 : %s\n대출일 : %s\n\n", this.borrower, this.checkOutDate);
	}

	@Override
	public void checkIn() {
		if(isState()) {
			System.out.println("이미 책이 반납되었습니다.");
			return;
		}
		
		setState(true);
		System.out.printf("*****%s 이(가) 반납되었습니다.\n\n", this.bookTitle);
	}

}
