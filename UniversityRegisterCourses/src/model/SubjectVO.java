package model;

/*
 * VO(Value Object)클래스는 데이터를 담는 컨테이너 역할을 하는 클래스로 데이터 전달을 목적으로 만들어진 클래스이다.
 * VO클래스는 어플리케이션 구조에서 각 단계의 입출력 정보를 전달하는 역할을 수행하며,
 * 속성(attribute: 필드), setter(설정자)와 getter(접근자)로 구성된다.
 */
public class SubjectVO {
	private int no; // 번호
	private String s_num; // 학과번호
	private String s_name; // 학과명
	private String filename = null; // 이미지 파일명

	public SubjectVO() {
	}
	
	public SubjectVO(int no, String s_num, String s_name) {
		this.no = no;
		this.s_num = s_num;
		this.s_name = s_name;
	}

	public SubjectVO(int no, String s_num, String s_name, String filename) {
		this.no = no;
		this.s_num = s_num;
		this.s_name = s_name;
		this.filename = filename;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getS_num() {
		return s_num;
	}

	public void setS_num(String s_num) {
		this.s_num = s_num;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
//		return "SubjectVO [no=" + no + ", s_num=" + s_num + ", s_name=" + s_name + ", filename=" + filename + "]";
		return getS_name();
	}

}
