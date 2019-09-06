package exam_abstract_class;

abstract class Shape {
	int x, y;

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//추상메소드(메소드의 선언부분만 존재하고 정의 부분을 가지고 있지 않은 메소드)
	public abstract void draw();
}

class Rectangle extends Shape {
	int width, height;

	public void draw() {
		System.out.println("사각형 그리기 메소드");
	}
}

class Circle extends Shape {
	int radius;

	public void draw() {
		System.out.println("원 그리기 메소드");
	}
}

public class AbstractShapeTest {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		Circle c = new Circle();

		r.x = 0;
		r.y = 0;
		r.move(0,0);
		
		System.out.println("abstract 클래스 구현");
		System.out.print("Shape-Rectangle : ");
		r.draw();
		System.out.print("Shape-Circle : ");
		c.draw();
	}
}
