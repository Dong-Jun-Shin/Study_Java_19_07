package exam_object_stream;

import java.io.Serializable;

//object.dat 파일에 Person 데이터를 저장 : output 메소드 생성
//object.dat 파일에서 데이터로 읽어서 Person 복원하여 출력 : input 메소드 생성

//NotSerializableException : Serializable 구현하지 않을 시, 오류
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	
	public Person() {
	}
	
	public Person(String name, int age) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
