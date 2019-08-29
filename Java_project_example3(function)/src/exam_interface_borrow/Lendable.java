package exam_interface_borrow;

public interface Lendable {
	public abstract void checkOut(String borrower, String date);
	public abstract void checkIn();
}
