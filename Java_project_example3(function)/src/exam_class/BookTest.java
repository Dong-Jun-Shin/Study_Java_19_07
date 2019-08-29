package exam_class;

class Book {
	private String title;
	private int page;
	private String author;

	public Book() {

	}

	public Book(String title, int page, String author) {
		this.title = title;
		this.page = page;
		this.author = author;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final int getPage() {
		return page;
	}

	public final void setPage(int page) {
		this.page = page;
	}

	public final String getAuthor() {
		return author;
	}

	public final void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "[title=" + title + ", page=" + page + ", author=" + author + "]";
	}
	
}

class Magazine extends Book {
	private String issueDate;

	public Magazine() {

	}

	public Magazine(String title, int page, String author, String issueDate) {
		super(title, page, author);
		this.issueDate = issueDate;
	}

	public final String getIssueDate() {
		return issueDate;
	}

	public final void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	@Override
	public String toString() {
		String sData = "[issueDate=" + issueDate + "]";
		return super.toString() + sData;
	}

	
}

public class BookTest {
	public static void main(String[] args) {
		Magazine[] m = new Magazine[10];
		for (int i = 0; i < m.length; i++) {
			m[i] = new Magazine(Character.toString((char)(65 + i)), i*10, "작가"+String.format("%d", i), String.format("2019년 1월 %d일", i+1));
		}
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i].toString());
		}
		
		
		
	}
}
