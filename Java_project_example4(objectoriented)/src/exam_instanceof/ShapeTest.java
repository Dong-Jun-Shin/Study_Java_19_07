package exam_instanceof;

public class ShapeTest {
	private static Shape arrayOfShapes[];

	public static void init() {
		arrayOfShapes = new Shape[3];
		arrayOfShapes[0] = new Rectangle(5, 5);
		arrayOfShapes[1] = new Triangle(5, 5);
		arrayOfShapes[2] = new Circle(5);
	}

	public static void drawAll() {
		for (int i = 0; i < arrayOfShapes.length; i++) {
			arrayOfShapes[i].draw();
		}
	}
	
	public static void getAreaAll() {
		for (Shape shape : arrayOfShapes) {
			shape.getArea();
		}
	}
	
	public static void main(String[] args) {
		init();
		drawAll();
		System.out.println();
		getAreaAll();
	}

}
