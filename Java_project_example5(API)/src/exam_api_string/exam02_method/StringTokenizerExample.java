package exam_api_string.exam02_method;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String text = "홍길동/이수홍,,박연수-김민희,";
		
		//StringTokenizer(대상 문자열, 구분자) 생성자
		
		//방법1: 남아 있는 토큰을 확인하고 while문으로 반복
		//연속된 구분자도 모두 제외해서 사이 값들만 출력
		StringTokenizer st = new StringTokenizer(text, "/,-");
		int countTokens = st.countTokens(); //토큰의 개수를 반환.
		System.out.println("전체 토큰 수 : "+ countTokens);
		
		while(st.hasMoreTokens()) { //토큰이 더이상 존재하는지 여부 검
			String token = st.nextToken(); //다음 토큰을 리턴
			System.out.println(token);
		}
		
	}
}
