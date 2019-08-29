package exam_class_array;

public class Phone {
	private String name;
	private String comp;
	
	public Phone() {
		
	}
	
	public Phone(String name, String comp) {
		this.name = name;
		this.comp = comp;
	}
	
	public void printData() {
		System.out.println("Phone Nmae : "+ name + " Comp : "+comp);
	}
}
