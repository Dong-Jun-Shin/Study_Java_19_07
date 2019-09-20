package exam_generic_method;

//제네릭 클래스 선언
public class Box<T> {
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}