package exam_method_overload;

class Person {
	private String name;
	private int age;
	private String school;
	private String hobby;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person(String name, String school) {
		super();
		this.name = name;
		this.school = school;
	}

	public Person(String name, int age, String school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}

	public Person(String name, int age, String school, String hobby) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
		this.hobby = hobby;
	}

	protected final String getName() {
		return name;
	}

	protected final void setName(String name) {
		this.name = name;
	}

	protected final int getAge() {
		return age;
	}

	protected final void setAge(int age) {
		this.age = age;
	}

	protected final String getSchool() {
		return school;
	}

	protected final void setSchool(String school) {
		this.school = school;
	}

	protected final String getHobby() {
		return hobby;
	}

	protected final void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void selfIntroduce() {
		String selfIntro = "안녕하세요. ";

		//이름
		if (name != null)
			selfIntro += String.format("제 이름은 %s입니다.", name);
		//공백   - 나이, 학교, 취미가 비어있지 않는 경우
		if (!(age == 0 && school == null && hobby == null))
			selfIntro += "\n";
		//나이
		if (age != 0 && age >= 0)
			selfIntro += String.format("현재 %d살입니다. ", age);
		//학교
		if (school != null)
			selfIntro += String.format("다니는 학교는 %s입니다. ", school);
		//공백  - 나이와 학교가 있는 경우
		if (age != 0 && age >= 0 && school != null)
			selfIntro += "\n";
		//취미
		if (hobby != null)
			selfIntro += String.format("취미로 %s를 하고 있습니다.", hobby);
		//공백  - 나이, 학교가 비어있거나 취미가 있는 경우
		if (age == 0 || school == null || hobby != null)
			selfIntro += "\n";

		selfIntro += "감사합니다.\n";

		System.out.println(selfIntro);
	}
}

public class PersonTest {
	public static void main(String[] args) {
		Person[] p = new Person[5];
		//이름
		p[0] = new Person("홍길동");
		//이름과 나이
		p[1] = new Person("김철수", 32);
		//이름과 학교
		p[2] = new Person("나영희", "대한미국 대학");
		//이름과 나이와 학교
		p[3] = new Person("삼애플", 20, "캘리포니아 대학");
		//이름과 나이와 학교와 취미
		p[4] = new Person("구고객", 13, "고구려 대학", "칼싸움");

		String[] s = new String[5];
		s[0] = "미래의 일꾼! 기호 1번";
		s[1] = "국민여러분의 발! 기호 2번";
		s[2] = "가계를 책임질 나든든! 기호 3번";
		s[3] = "애플이 국력이다! 기호 4번";
		s[4] = "새나라의 기상! 기호 5번";

		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
			p[i].selfIntroduce();
		}

	}
}
