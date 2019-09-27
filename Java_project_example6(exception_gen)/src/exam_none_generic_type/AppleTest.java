package exam_none_generic_type;

public class AppleTest {
	public static void main(String[] args) {
		Box box = new Box();
		box.set(new Apple("Red"));
		Apple apple = (Apple) box.get();
		System.out.println(apple.toString());
		
		Character ch = new Character('잠');
		box.set(ch);
		Character c = (Character) box.get();
		System.out.println(c.charValue());
		
		box.set(new Character('잠'));
		box.set('잠');
		char cValue = (Character)box.get();
		System.out.println(cValue);
		
		//실행 결과는?
		//컴파일러는 타입을 정확하게 검사 안해서 (Object와 다형성 사용시), 실행오류가 발생한다.
		String str = "java";
		box.set(str);
		System.out.println("값: " + (Integer)box.get());
	}
}
