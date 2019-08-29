package exam_parent_constructor_call;

public class Entry {
	public String word;

	public Entry() {
		System.out.println("****약어 사전****");
	}

	public Entry(String word) {
		
		this(); //이 클래스의 생성자를 참조
		this.word = word; //이 클래스가 가진 속성을 접근
	}

	public void writeView() {
		System.out.println("약어 : " + word);
	}
}
