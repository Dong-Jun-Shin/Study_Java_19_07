package exam_generic_type;


import exam_none_generic_type.*;

//제네릭 클래스 선언
class Box<T> {
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}

public class BoxTest {
	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		box1.set(new String("hello"));
		String str = box1.get();
		System.out.println(str);
		
		//정수 자료형으로 설정 후 6을 대입
//		Box<int> box2 = new Box<int>(); //기초자료형을 넣을 수 없다.
		Box<Integer> box2 = new Box<Integer>();
		//box2.set(new Integer(6));
		box2.set(6);
		int value = box2.get().intValue();
		//int value = box2.get();
		System.out.println(value);
		
		//생성한 Apple 클래스를 설정 후 청색 사과를 대입
		Box<Apple> box3 = new Box<Apple>();
		box3.set(new Apple("Green"));
		Apple app = box3.get();
		System.out.println(app.toString());
		
		//Box<double> box4 = new Box<double>();
		Box<Double> box4 = new Box<Double>();
		//box4.set(new Double(3.6));
		box4.set(3.6);
		//double data = box4.get().doubleValue();
		double data = box4.get();
		System.out.println(data);
		
		Box<String> box5 = new Box<String>();
//		box5.set(new Integer(5));
	}
}
