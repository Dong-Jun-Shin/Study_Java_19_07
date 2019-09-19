package exam_class_relation;

public class Circle {
	private int radius;
	private Point center;

	//생성자
	public Circle() {
		radius = 5;
		center = new Point(10, 10);
	}

	public Circle(int r) {
		radius = r;
		center = new Point(10, 10);
	}

	public Circle(int r, Point p) {
		radius = r;
		center = p;
	}
	
	public Circle(int r, int x, int y) {
		radius = r;
		center = new Point(x, y);
	}

	public String toString() {
		return "Circle [radius=" + radius + ", center=" + center.toString() + "]";
	}

}
