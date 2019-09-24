package exam_collection_list;

public class Apple {
	private String kind;
	private String color;
	
	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Apple(String kind, String color) {
		super();
		this.kind = kind;
		this.color = color;
	}
	
	public final String getKind() {
		return kind;
	}
	
	public final void setKind(String kind) {
		this.kind = kind;
	}
	
	public final String getColor() {
		return color;
	}
	
	public final void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Apple [품종=" + kind + ", 색상=" + color + "]";
	}
	
	
}