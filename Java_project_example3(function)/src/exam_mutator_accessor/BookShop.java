package exam_mutator_accessor;

public class BookShop {
	
	private String bname;
	private String author; 
	private int price;
	
	public String getBname() {
		return bname;
	}
	
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return String.format("책이름 : %s\n저자 : %s\n가격 : %d", bname, author, price);
	}
}
