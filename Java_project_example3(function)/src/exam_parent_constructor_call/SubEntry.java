package exam_parent_constructor_call;

public class SubEntry extends Entry {
	public String definition;
	public int year;

	//������
	public SubEntry(String word) {
		super(word); // ����Ŭ������ ������ ȣ��
	}

	public SubEntry(String word, String definition, int year) {
		this(word);
		this.definition = definition;
		this.year = year;
	}

	public void printView() {
		super.writeView();
		System.out.println("���� : " + this.definition);
		System.out.println("�ñ� : " + year);
	}
}
