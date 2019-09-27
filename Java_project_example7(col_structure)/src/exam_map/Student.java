package exam_map;

public class Student {
	private int sno;	//학번
	private String name;//이름
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
			return (sno==student.sno);	//&& (name.equals(student.name));
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return sno; // + name.hashCode();
	}
	
	@Override
	public String toString() {
		return " 이름 : " + name + " 학번 : " + sno;
	}
}
