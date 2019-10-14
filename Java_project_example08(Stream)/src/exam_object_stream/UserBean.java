package exam_object_stream;

import java.io.Serializable;

public class UserBean implements Serializable{
	/*
	 * 오류 : stream classdesc serialVersionUID = -1154398432327576550, local class serialVersionUID = 8538360452125040823
	 */
//	private static final long serialVersionUID = -1154398432327576550L;
	private static final long serialVersionUID = 8538360452125040823L;
	
	private String id;
	private String password;
	private String name;
	private String tel;
	private String address;

	public UserBean() {
	}

	public UserBean(String id, String name, String tel, String address) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", password=" + password + ", name=" + name + ", tel=" + tel + ", address="
				+ address + "]";
	}
	
}
