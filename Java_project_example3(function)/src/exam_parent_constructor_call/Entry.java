package exam_parent_constructor_call;

public class Entry {
	public String word;

	public Entry() {
		System.out.println("****��� ����****");
	}

	public Entry(String word) {
		
		this(); //�� Ŭ������ �����ڸ� ����
		this.word = word; //�� Ŭ������ ���� �Ӽ��� ����
	}

	public void writeView() {
		System.out.println("��� : " + word);
	}
}
