package phoneinfoproject_2;

import java.io.Serializable;

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



public class PhoneInfo implements Serializable{
	private static final long serialVersionUID = 2781738383141296420L;
	
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
		System.out.println();
	}
	
	@Override
	public int hashCode() {
		//String타입의 name으로 중복되지 않게 기준 설정
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		//hashCode를 토대로 이름이 같은지 비교한다.
		if(obj instanceof PhoneInfo) {
			PhoneInfo cmp = (PhoneInfo)obj;
			//String에 정의된 compareTo로, 같으면 0을 반환
			if(name.compareTo(cmp.name)==0) {
				return true;
			}
		}
		return false;
	}
}
