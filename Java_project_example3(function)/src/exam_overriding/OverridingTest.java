package exam_overriding;

class EmployeeOverriding {
	protected String name;
	private int salary;

	public EmployeeOverriding(String name, int salary) {
		this.name= name;
		this.salary = salary;
	}

	public String getDetails() {
		return "Name : " + name + "\n" + "Salary : " + salary;
	}

	public void display() {
		System.out.println("I'm is Employee");
	}
}

class ManagerOverriding extends EmployeeOverriding{
	private String department;
	
	public ManagerOverriding(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}
	
	@Override
	public String getDetails() {
		return "Name : " + name + "\n" + "Manager of " + department;
	}
	
	@Override
	public void display() {
		System.out.println("I'm Manager");
	}
}
public class OverridingTest {
	public static void main(String[] args) {
		EmployeeOverriding e = new EmployeeOverriding("±èÃ¶¼ö", 50);
		System.out.println(e.getDetails());
		e.display();
		System.out.println();
		
		ManagerOverriding m = new ManagerOverriding("¾Æ¹«°³", 100, "¿µ¾÷");
		System.out.println(m.getDetails());
		m.display();
	}
}
