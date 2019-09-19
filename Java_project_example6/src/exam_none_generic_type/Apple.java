package exam_none_generic_type;

public class Apple {
	private Object color;

	public Apple(Object color) {
		super();
		this.color = color;
	}

	public final Object getColor() {
		return color;
	}

	public final void setColor(Object color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + "]";
	}
	
	
}