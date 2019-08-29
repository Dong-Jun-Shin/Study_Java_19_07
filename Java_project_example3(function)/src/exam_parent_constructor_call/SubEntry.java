package exam_parent_constructor_call;

public class SubEntry extends Entry {
	public String definition;
	public int year;

	//생성자
	public SubEntry(String word) {
		super(word); // 슈퍼클래스의 생성자 호출
	}

	public SubEntry(String word, String definition, int year) {
		this(word);
		this.definition = definition;
		this.year = year;
	}

	public void printView() {
		super.writeView();
		System.out.println("원어 : " + this.definition);
		System.out.println("시기 : " + year);
	}
}
