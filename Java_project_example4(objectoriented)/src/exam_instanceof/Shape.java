package exam_instanceof;

abstract class Shape {
	protected int x, y;

	public void draw() {
		System.out.println("Shape Draw");
	}

	public abstract void getArea();
}

class Rectangle extends Shape {
	private int width, height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.println("Rectangle Draw");
	}
	@Override
	public void getArea() {
		System.out.println("Rectangle Area : " + (width*height));
	}
}

class Triangle extends Shape {
	private int base, height;

	public Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("Triangle Draw");
	}
	@Override
	public void getArea() {
		System.out.println("Triangle Area : " + (base*height/2));
	}
}

class Circle extends Shape {
	private final double pi = 3.14;
	private int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("Circle Draw");
	}
	@Override
	public void getArea() {
		System.out.println("Circle Area : " + (radius*radius*pi));
	}
}
