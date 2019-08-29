package exam_class_basic;

/*
 * 주소록을 나타내는 Address 클래스를 만든다.
 * 주소록에는 이름(name), 주소(addr), 전화번호(tel)을 필드로 가진다.
 * 정보를 입력받아 화면에 전체 필드의 내용이 출력되도록 작성한다.
 */
public class Address {
	public String name;
	public String addr;
	public String tel;
	
	public void getData(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	
	public void printData() {
		System.out.printf("%s %-20s %s/n", name, addr, tel);
	}
	
	public String toString() {
		return "이름 : " + name + " 주소 : " + addr + " 번호 : " + tel + "\n";
	}
	
}
