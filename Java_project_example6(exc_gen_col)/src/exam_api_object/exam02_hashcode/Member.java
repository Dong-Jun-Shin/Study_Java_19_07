package exam_api_object.exam02_hashcode;

public class Member {
	private String name;
	private int age;
	
	public Member() {
	}

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final int getAge() {
		return age;
	}

	public final void setAge(int age) {
		this.age = age;
	}
	
//	중복값 제어를 위한 오버라이딩(equals())
//	toString()으로 필드값 접근을 위한 (hashCode())
	
//	나이만 판단
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Member) {
//			Member member = (Member) obj;
//			if(this.age == member.age) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	@Override
//	public int hashCode() {
//		return age;
//	}
	
//	이름만 판단
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Member) {
//			Member member = (Member) obj;
//			if(member.name.equals(name)) {
//				return true;
//			}
//		}
//		return false;
//	}	
//	
//	@Override
//	public int hashCode() {
//		return name.hashCode();
//	}
	
//	이름과 나이 판단
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age == age);
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
}
