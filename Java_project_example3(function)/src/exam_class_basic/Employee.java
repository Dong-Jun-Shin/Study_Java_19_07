package exam_class_basic;

import java.util.Scanner;

public class Employee {
	public String name;
	public String phoneNumber;
	public int salary;
	
	public void getData(Scanner scan) {
		System.out.println("직원1 정보를 입력해주세요>>");
		System.out.print("이름 : ");
		name = scan.nextLine();
		
		System.out.print("번호 : ");
		phoneNumber = scan.nextLine();
		
		System.out.print("급여 : ");
		salary = scan.nextInt();
		scan.nextLine();
		
		System.out.println();
	}
	
	public String toString() {
		return String.format("직원정보[사원명: %-3s,\t 전화번호 = %-10s,\t 급여 = %5d]", name, phoneNumber, salary);
	}
}
