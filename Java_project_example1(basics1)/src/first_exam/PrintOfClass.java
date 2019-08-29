package first_exam;

/**
 * P.47 예제(도전)
 * Class 활용
 */

public class PrintOfClass {
	public static void main(String[] args) {
		My.name("신동준");
		My.add("대한민국 산 속");
		My.phone("010-1234-1234");
		My.work("무직");
	}
}

class My {
	public static void name(String n) {
		System.out.println("이름은 " + n + "이고요..");
	}

	public static void add(String n) {
		System.out.println("주소는 " + n + "이고요..");
	}

	public static void phone(String n) {
		System.out.println("번호는 " + n + "이고요..");
	}

	public static void work(String n) {
		System.out.println("직장은 " + n + "입니다.");
	}
}
