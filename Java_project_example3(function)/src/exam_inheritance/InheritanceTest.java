package exam_inheritance;

public class InheritanceTest {
	public static void main(String[] args) {
		Employee e = new Employee();
		Professor p = new Professor();
		Student s = new Student();

		e.setName("ȫ�浿");
		e.setAge(47);
		e.setDept("������");
		
		p.setName("��Ǫ��");
		p.setAge(52);
		p.setSubject("������");
		
		s.setName("������");
		s.setAge(20);
		s.setMajor("��ǻ�Ͱ����а�");
		
		System.out.println(e.toString() + e.getDept());
		System.out.println(p.toString() + p.getSubject());
		System.out.println(s.toString() + s.getMajor());
	}
}
