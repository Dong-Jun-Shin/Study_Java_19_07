package exam_interface;

import java.util.Arrays;

/*
 * Arrays 클래스의 sort() 메소드는 대상 객체가
 * Comparable 인터페이스를 구현하고 있는 경우에만 정렬 서비스를 제공한다.
 * Student 클래스를 작성하고 학생들의 평점을 기준으로 정렬하는 예제이다.
 */

@SuppressWarnings("rawtypes")
class Student implements Comparable{
	private String name; //이름
	private double gpa; //평점
	
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	
	//Comparable의 추상 메소드 구현
	protected final String getName() {
		return name;
	}



	protected final void setName(String name) {
		this.name = name;
	}



	protected final double getGpa() {
		return gpa;
	}



	protected final void setGpa(double gpa) {
		this.gpa = gpa;
	}


//	Comparable의 추상 메소드 구현
	public int compareTo(Object obj) {
		Student other = (Student) obj;
		//점수순 비교
		/*
		if(this.gpa < other.gpa)
			return -1;
		else if(this.gpa > other.gpa)
			return 1;
		else
			return 0;
		*/

		//this.name = 호출한 Student 객체 | .compareTo(비교할 String)
		int s = this.name.compareTo(other.name);
		
		return s;
	}
}

public class StudentSort {
	public static void main(String[] args) {
		Student[] students = new Student[3];
		students[0] = new Student("홍길동", 3.39);
		students[1] = new Student("이한솔", 4.21);
		students[2] = new Student("김희진", 2.19);
		
		Arrays.sort(students);
		
		for (Student student : students) 
			System.out.println(student.getName()+ ", " + student.getGpa());
		
	}
}
