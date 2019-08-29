package exam_abstract_class;

abstract class MessageSender {
	private String title;
	protected String senderName;

	public MessageSender() {
	}

	public MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}

	protected final String getTitle() {
		return title;
	}

	protected final void setTitle(String title) {
		this.title = title;
	}

	protected final String getSenderName() {
		return senderName;
	}

	protected final void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public abstract void sendMessage(String receiver);
}

class EMailSender extends MessageSender {
	private String senderAddr;
	private String emailBody;

	public EMailSender() {
	}

	public EMailSender(String title, String senderName, String senderAddr, String emailBody) {
		super(title, senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}

	protected final String getSenderAddr() {
		return senderAddr;
	}

	protected final void setSenderAddr(String senderAddr) {
		this.senderAddr = senderAddr;
	}

	protected final String getEmailBody() {
		return emailBody;
	}

	protected final void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public void sendMessage(String receiver) {
		System.out.println("------------------------------");
		//상위 필드 private 사용 시, get으로 가져오기
		System.out.println("제목: " + getTitle());
		
		//상위 필드 protected 사용 시, 상속받아 직접 접근
		System.out.println("보내는 사람: " + senderName + " " + senderAddr);
		System.out.println("받는 사람: " + receiver);
		System.out.println("내용: " + emailBody);
	}
}

class SMSSender extends MessageSender {
	private String returnPhoneNo;
	private String message;

	public SMSSender() {
	}

	public SMSSender(String title, String senderName, String returnPhoneNo, String message) {
		super(title, senderName);
		this.returnPhoneNo = returnPhoneNo;
		this.message = message;
	}

	protected final String getReturnPhoneNo() {
		return returnPhoneNo;
	}

	protected final void setReturnPhoneNo(String returnPhoneNo) {
		this.returnPhoneNo = returnPhoneNo;
	}

	protected final String getMessage() {
		return message;
	}

	protected final void setMessage(String message) {
		this.message = message;
	}

	public void sendMessage(String receiver) {
		System.out.println("------------------------------");
		System.out.println("제목: " + getTitle());
		System.out.println("보내는 사람: " + senderName);
		System.out.println("전화번호: " + returnPhoneNo);
		System.out.println("받는 사람: " + receiver);
		System.out.println("내용: " + message);
	}
}

public class MessageSenderTest {
	public static void main(String[] args) {
		EMailSender e = new EMailSender("생일을 축하합니다.", "고객센터", "admin@dukeeshop.co.kr", "10% 할인쿠폰이 발행되었습니다.");
		SMSSender s = new SMSSender("생일을 축하합니다.", "고객센터", "010-000-0000", "10% 할인쿠폰이 발행되었습니다.");
		
		e.sendMessage("javaone@naver.com");
		s.sendMessage("02-000-0000");		
	}
}
