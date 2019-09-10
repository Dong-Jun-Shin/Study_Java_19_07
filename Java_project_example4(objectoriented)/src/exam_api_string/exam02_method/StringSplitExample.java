package exam_api_string.exam02_method;

public class StringSplitExample {
	public static void main(String[] args) {
		String text = "자바& 오라클,&,리눅스,HTEML-JAVASCRIPT-JQUERY";

		//구분자가 연속으로 존재시 빈문자열로 간주하여 빈문자열 반환.
		String[] names = text.split(",");
		/*
		  	배열의 수 : 4
			자바&오라클
			
			리눅스
			HTEML-JAVASCRIPT-JQUERY
		 */
		
		names = text.split("&|,|-| ");
		/*
			배열의 수 : 9
			자바
			
			오라클
			
			
			리눅스
			HTEML
			JAVASCRIPT
			JQUERY
		 */
		
		System.out.println("배열의 수 : " + names.length);
		for (String name : names) {
			System.out.println(name);
		}
	}
}
