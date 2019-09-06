package exam_api_string.exam02_method;

public class StringEqualsExample {
	public static void main(String[] args) {
		//같은 리터럴의 주소를 가리킴
		String str1 = "Java";
		String str2 = "Java";
		
		//주소값 같음
		if(str1 == str2) {
			System.out.println("동일 객체");
		}else {
			System.out.println("서로 다른 객체");
		}
		
		//기본적으로 == 연산자와 동일한 결과 리턴(주소값 비교)
		//서로 각각의 객체를 생성해서 각 주소를 가리킴
		String strData1 = new String("Java");
		String strData2 = new String ("Java");
		
		//주소값 다름
		if(strData1 == strData2) {
			System.out.println("동일 객체");
		}else {
			System.out.println("서로 다른 객체");
		}
		
		//논리적 동등이란? 저장된 데이터가 동일한 것(같은 객체이건 다른 객체이건 상관없이)
		//equals() 메소드를 사용한다.
		//데이터 같음
		if(strData1.equals(strData2)) {
			System.out.println("동일 객체");
		}else {
			System.out.println("서로 다른 객체");
		}
	}
}
