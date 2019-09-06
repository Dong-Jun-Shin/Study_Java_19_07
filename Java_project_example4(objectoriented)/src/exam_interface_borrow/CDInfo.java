package exam_interface_borrow;

public abstract class CDInfo {
	private int registerNo;
	private String title;
	
	public CDInfo(int registerNo, String title) {
		this.registerNo = registerNo;
		this.title = title;
	}
	
	protected final int getRegisterNo() {
		return registerNo;
	}
	protected final void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}
	protected final String getTitle() {
		return title;
	}
	protected final void setTitle(String title) {
		this.title = title;
	}
}
