﻿package exam_class_extends;

/*
 * 직원(Employee)과 매니저(Manager)의 예를 들어보자.
 * 직원은 이름(name), 주소(address), 전화번호(phoneNumber), 월급(salary) 필드가 필요하고
 * 매니저는 이름, 주소, 전화번호, 월급, 보너스(bonus), 객체(job)을 필드로 갖는다.
 * 생성자, 설정자, 접근자를 생성하여 보자.
 */

class Employee{
	private String name;
	private String address;
	private int salary;
	private String phoneNumber;
	
	public Employee() {
		
	}
	
	public Employee(String name, String address, String phoneNumber, int salary) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", salary=" + salary + ", phoneNumber=" + phoneNumber + "]\n";
	}
	
	
}

class Manager extends Employee{
	private int bonus;
	private String job;
	
	public Manager() {
		
	}

	public Manager(String name, String address, String phoneNumber, int salary, int bonus, String job) {
		super(name, address, phoneNumber, salary);
		this.bonus = bonus;
		this.job = job;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		String sData = "\nManager [bonus=" + bonus + ", job=" + job + "]\n";
		return super.toString() + sData;
	}
	
}

public class EmployeeTest {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee("홍길동", "한국", "010-1111-1111", 100);
		Manager m1 = new Manager();
		Manager m2 = new Manager("홍길동", "한국", "010-1111-1111", 100, 20, "대리");
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
		System.out.println("---------------------------------");
		
		Employee[] e = new Employee[2];
		e[0] = new Employee();
		e[1] = new Employee("홍길동", "한국", "010-1111-1111", 100);
		
		Manager[] m = new Manager[2];
		m[0] = new Manager();
		m[1] = new Manager("홍길동", "한국", "010-1111-1111", 100, 20, "대리");
		
		for (int i = 0; i < m.length; i++) {
			System.out.println(e[i].toString());
			System.out.println();
			System.out.println(m[i].toString());
			System.out.println();
		}
	}
}
