package exam_generic_method;

class GenericMethod {
	//제네릭 메소드 선언
	//접근제어(제한자) 키워드 <타입 매개 변수> 반환형 메소드명(자료형 변수){ }
	//접근제어(제한자) 키워드 <타입 매개 변수> 타입 매개 변수 메소드명(타입 매개 변수){ }
	public static <T> T getLast(T[] arr) {
		return arr[arr.length - 1];
	}
}

public class GenericMethodExample {
	public static void main(String[] args) {
		String[] language = { "C++", "C#", "JAVA" };
		String last = GenericMethod.<String>getLast(language);
		System.out.println("배열의 마지막 원소: " + last);
		last = GenericMethod.getLast(language);
		System.out.println("배열의 마지막 원소: " + last);
		
//		Integer[] num = 
//		{new Integer(70),
//		new Integer(67),
//		new Integer(88),
//		new Integer(90)}
		Integer[] num = {70, 67, 88, 90};
		int lastNum = GenericMethod.<Integer>getLast(num);
		System.out.println("배열의 마지막 원소: "+lastNum);
		lastNum = GenericMethod.getLast(num);
		System.out.println("배열의 마지막 원소: "+lastNum);
		
	}
}
