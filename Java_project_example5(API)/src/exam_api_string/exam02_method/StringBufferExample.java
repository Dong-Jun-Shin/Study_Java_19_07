package exam_api_string.exam02_method;

public class StringBufferExample {
	public static void stringPrint() {
		String resultStr = "";
		//String pool, 힙의 같은 주소를 가리키고 있다.
		String str = "JAVA";
		String str1 = "JAVA";
		
		System.out.println("str = " + str.hashCode());
		System.out.println("str1 = " + str1.hashCode());
		System.out.println();
		
		resultStr += str; //JAVA
		System.out.println("resultStr="+resultStr.hashCode());		
		resultStr += str; //JAVAJAVA
		System.out.println("resultStr="+resultStr.hashCode());

		System.out.println("String 타입의 resultStr = " + resultStr);
		System.out.println();
	}
	
	public static void stringBufferPrint(StringBuffer resultStr) {
		String str = "JAVA";
		
		resultStr.append(str); //JAVA
		System.out.println("resultStr="+resultStr.hashCode());		
		resultStr.append(str); //JAVAJAVA
		System.out.println("resultStr="+resultStr.hashCode());
		System.out.println("StringBuffer 타입의 resultStr = " + resultStr);
		System.out.println();
	}
	
	public static void main(String[] args) {
		stringPrint();
		
		StringBuffer resultStr = new StringBuffer("");
		stringBufferPrint(resultStr);
		
		//버퍼 내 문자열 전체 삭제
		resultStr.delete(0, resultStr.length());
		
		//버퍼내 문자열 두번에 걸쳐서 추가
		resultStr.append("힘내자구요~~아자");
		resultStr.append("!!");
		System.out.println(resultStr.toString());
		
		//문자열 앞에 삽입
		resultStr.insert(0, "다들 ");
		System.out.println(resultStr.toString());
		
		resultStr.replace(10, 12, "화이팅");
		System.out.println(resultStr.toString());
		
		System.out.println(resultStr.reverse());
	}
}
