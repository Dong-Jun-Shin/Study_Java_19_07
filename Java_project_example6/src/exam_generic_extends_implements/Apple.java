package exam_generic_extends_implements;

public class Apple implements Comparable<Apple> {
	private String color;
	private int size;

	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apple(String color, int size) {
		super();
		this.color = color;
		this.size = size;
	}

	public final String getColor() {
		return color;
	}

	public final void setColor(String color) {
		this.color = color;
	}
	
	public final int getSize() {
		return size;
	}

	public final void setSize(int size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "Apple [color=" + color + ", size=" + size + "]";
	}

	@Override
	public int compareTo(Apple o) {
		if (this.size > o.size)
			return 1;
		else if (this.size < o.size)
			return -1;
		return 0;
	}

}
