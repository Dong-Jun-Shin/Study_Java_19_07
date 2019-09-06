package exam_class_relation;

/*
 * 원을 나타낸다는 가정 하에 Circle 클래스를 작성하여 보자.
 * 원의 중심과 반지름으로 표현된다.
 * 중심을 표현하기 위해 Point 클래스를 작성하고
 * Point 객체를 Circle 클래스 안에 포함하여 정의하여 보자.
 * 
 */
public class Point {
	private int x;
	private int y;

	//생성자
	public Point(int a, int b) {
		x = a;
		y = b;
	}

	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}	
}
