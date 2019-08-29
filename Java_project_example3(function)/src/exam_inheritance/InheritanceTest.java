package exam_inheritance;

public class InheritanceTest {
	public static void main(String[] args) {
		Employee e = new Employee();
		Professor p = new Professor();
		Student s = new Student();

		e.setName("홍길동");
		e.setAge(47);
		e.setDept("영업부");
		
		p.setName("김푸름");
		p.setAge(52);
		p.setSubject("빅데이터");
		
		s.setName("김유빈");
		s.setAge(20);
		s.setMajor("컴퓨터과학학과");
		
		System.out.println(e.toString() + e.getDept());
		System.out.println(p.toString() + p.getSubject());
		System.out.println(s.toString() + s.getMajor());
	}
}
