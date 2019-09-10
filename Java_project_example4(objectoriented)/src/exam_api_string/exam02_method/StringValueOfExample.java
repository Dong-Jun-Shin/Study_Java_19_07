package exam_api_string.exam02_method;

public class StringValueOfExample {
	public static void main(String[] args) {
		//기초형을 문자열로 반환
		String s1 = String.valueOf(true);
		String s2 = String.valueOf('A');
		String s3 = String.valueOf(3.14);
		String s4 = String.valueOf(123);
//		String s5 = String.valueOf(new MyObject(123));
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
//		System.out.println(s5);
	}
}
