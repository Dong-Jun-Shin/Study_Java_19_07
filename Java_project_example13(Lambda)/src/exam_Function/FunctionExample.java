package exam_Function;

import java.util.function.Function;

public class FunctionExample {
	public static void main(String[] args) {
		//재정의의 매개변수가 1개라면 괄호 생략 가능
		Function<String, Integer> func = s -> {
			int cnt = 0;
			String[] word = s.split(" ");
			cnt = word.length;
			return cnt;
		};
		
		int wordCnt = func.apply("고개를 들어 별들을 보라 당신 발만 내다 보지 말고...");
		System.out.println("단어 수 : " + wordCnt);
	}
}
