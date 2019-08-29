﻿package exam_class_relation;

public class CircleTest {
	public static void main(String[] args) {

		//기본 생성자
		Circle c1 = new Circle();
		System.out.println("기본: \t\t" + c1.toString());
		
		//매개변수 int r제공
		Circle c2 = new Circle(5);
		System.out.println("r: \t\t" + c2.toString());
		
		//매개변수 int r제공, Point p제공
		Point p = new Point(10, 10);
		Circle c3 = new Circle(5, p);
		System.out.println("r, p: \t\t" + c3.toString());
		
		//매개변수 int r제공, int x제공, int y제공
		Circle c4 = new Circle(5, 10, 10);
		System.out.println("r, x, y: \t" + c4.toString());
	}
}
