package phoneinfoproject;

class PhoneUnivInfo extends PhoneInfo{
	private String major;
	private int year;
	
	public PhoneUnivInfo() {
	}

	public PhoneUnivInfo(String name, String phoneNumber) {
		super(name, phoneNumber);
	}

	public PhoneUnivInfo(String name, String phoneNumber, String major, int year) {
		super(name, phoneNumber);
		this.major = major;
		this.year = year;
	}
	
	public final String getMajor() {
		return major;
	}
	public final void setMajor(String major) {
		this.major = major;
	}
	public final int getYear() {
		return year;
	}
	public final void setYear(int year) {
		this.year = year;
	}
	
	
}

class PhoneCompanyInfo extends PhoneInfo{
	private String company;
	
	public PhoneCompanyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhoneCompanyInfo(String name, String phoneNumber) {
		super(name, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}

	public final String getCompany() {
		return company;
	}

	public final void setCompany(String company) {
		this.company = company;
	}
	
}



public class PhoneInfo {
	private String name;
	private String phoneNumber;

	//생성자
	public PhoneInfo() {

	}	

	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	//getter, setter
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public static void showPhoneInfo(PhoneInfo pBook) {
		System.out.println("name: " + pBook.name);
		System.out.println("phone: " + pBook.phoneNumber);
		if(pBook instanceof PhoneUnivInfo) {			
			System.out.println("major: " + ((PhoneUnivInfo)pBook).getMajor());
			System.out.println("year: " + ((PhoneUnivInfo)pBook).getYear());
		}
		if(pBook instanceof PhoneCompanyInfo) {
			System.out.println("company:" + ((PhoneCompanyInfo)pBook).getCompany());
		}
	}
}
