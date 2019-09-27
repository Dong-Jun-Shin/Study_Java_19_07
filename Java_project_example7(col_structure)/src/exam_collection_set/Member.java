package exam_collection_set;

public class Member implements Comparable<Member>{
	private String name;
	private int age;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Member o) {
		if(this.age > o.age)
			return 1;
		else if(this.age == o.age)
			return 0;
		else
			return -1;
//		이름 비교, String의 compareTo() 사용
//		return this.name.compareTo(o.name); 
	}
}
