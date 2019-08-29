package exam_class_basic;

import java.util.Scanner;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee person1 = new Employee();
		Employee person2 = new Employee();
		Scanner scan = new Scanner(System.in);
		
		person1.getData(scan);
		person2.getData(scan);
		
		System.out.println(person1.toString());
		System.out.println(person2.toString());
		
		scan.close();
	}
}
