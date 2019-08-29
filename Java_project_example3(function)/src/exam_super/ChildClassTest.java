﻿package exam_super;

class ParentClass{
	//부모와 자식만 쓸 수 있는 접근제한자
	protected int data; 	

	public ParentClass() {
		data=100;
	}
	
	public void print() {
		System.out.println("슈퍼 클래스의 print() 메소드");
	}
}

class ChildClass extends ParentClass{
	protected int data;
	
	public ChildClass() {
		data = 200;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("서브 클래스의 print() 메소드");
		System.out.println("data : " + data);
		System.out.println("this.data : " + this.data);
		System.out.println("super.data : " + super.data);
	}
}

public class ChildClassTest {
	public static void main(String[] args) {
		ChildClass obj = new ChildClass();
		obj.print();
	}
}
