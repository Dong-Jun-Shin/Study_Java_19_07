package exam_generic_wildcard;

import java.util.Arrays;

//일반인
class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}

//직장인
class Worker extends Person {
	public Worker(String name) {
		super(name);
	}
}

//학생
class Student extends Person {
	public Student(String name) {
		super(name);
	}
}

//고등학생
class HighStudent extends Student {
	public HighStudent(String name) {
		super(name);
	}
}

class Course<T> {
	private String name; //강좌명
	private T[] students; //학생

	@SuppressWarnings("unchecked")
	public Course(String name, int size) {
		this.name = name;
		//제네릭 배열을 만드는 법은 Object배열을 생성해서 (T[])로 형변환 해준다.
		students = (T[]) (new Object[size]);
		//students = new T[size];
	}

	public String getName() {
		return name;
	}

	public T[] getStudents() {
		return students;
	}

	public void add(T t) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
}

public class WildCardExample {
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}

	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}

	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}

	public static void main(String[] args) {
		//일반인 과정
		Course<Person> personCourse = new Course<Person>("일반인 과정", 4);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));

		//직장인 과정
		Course<Worker> workerCourse = new Course<Worker>("직장인 과정", 1);
		workerCourse.add(new Worker("직장인"));

		//학생 과정
		Course<Student> studentCourse = new Course<Student>("학생 과정", 2);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));

		//고등학생 과정
		Course<HighStudent> highstudentCourse = new Course<HighStudent>("고등학생 과정", 1);
		highstudentCourse.add(new HighStudent("고등학생"));

		//<?> 모든 타입
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highstudentCourse);
		System.out.println();
		
		//<? extends 상위 클래스(Student)> 자신과 하위만 올 수 있다. (상위 제한)
//		registerCourseStudent(personCourse);
//		registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);		//자신
		registerCourseStudent(highstudentCourse);	//하위
		System.out.println();
		
		//<? super 하위 클래스(Worker)> 자신과 상위만 올 수 있다. (하위 제한)
		registerCourseWorker(personCourse);		//상위
		registerCourseWorker(workerCourse);		//자신
//		registerCourseWorker(studentCourse);
//		registerCourseWorker(highstudentCourse);
		System.out.println();
	}
}
