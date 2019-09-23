package exam_multi_type_parameter;

class Tv{
	private int inch;
	
	public Tv() {
	}

	public Tv(int inch) {
		super();
		this.inch = inch;
	}

	public final int getInch() {
		return inch;
	}

	public final void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "Tv [inch=" + inch + "]";
	}
	
}

class SmartPhone{
	private String brand;
	private String os;
	
	public SmartPhone(String brand, String os) {
		super();
		this.brand = brand;
		this.os = os;
	}
	
	public final String getBrand() {
		return brand;
	}
	public final void setBrand(String brand) {
		this.brand = brand;
	}
	public final String getOs() {
		return os;
	}
	public final void setOs(String os) {
		this.os = os;
	}
	
	@Override
	public String toString() {
		return "SmartPhone [brand=" + brand + ", os=" + os + "]";
	}
	
	
}

public class Car {
	private String color;
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}