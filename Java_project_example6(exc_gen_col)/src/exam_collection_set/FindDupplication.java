package exam_collection_set;

import java.util.HashSet;
import java.util.Set;

/*
 * 전체 문자에서 중복된 단어를 검출하는 프로그램을 작성하여 보자.
 * 이 예제 HashSet을 이용하여 코딩해 보세요.
 * String[] sample = { "단어", "의미", "구절", "의미", "단락"};
 * 
 * [출력 결과]
 * 중복된 단어: 의미
 * 단어 수 : 4
 * 중복되지 않은 단어: [단락, 의미, 구절, 단어]
 */

public class FindDupplication {
	public static void main(String[] args) {
		//풀이
		String[] sample = {"단어", "의미", "구절", "의미", "단락"};
		
		Set<String> s = new HashSet<String>();
		for (String a : sample) {
			//add()의 인수가 하나를 받으면 add는 boolean형을 반환한다.
			//중복을 허용하지 않기 때문에, 중복일 때 add는 false를 반환
			if(!s.add(a)) {
				System.out.println("중복된 단어: " + a);
			}
		}
		
		System.out.println("단어 수: " + s.size());
		System.out.println("중복되지 않은 단어: " + s.toString());
		
		
		//시도
//		String[] sample = { "단어", "의미", "구절", "의미", "단락"};
//		String dupli = "";
//		
//		Set<String> list = new HashSet<String>();
//		for (int i = 0; i < sample.length; i++) {
//			list.add(sample[i]);			
//		}
//		
//		Set<String> temp = new HashSet<String>();
//		for (int j = 0; j < sample.length; j++) {
//			temp.add(sample[j]);
//		}
//		
		//복사하고자 하는 Set집합객체를 매개변수로 넘겨준다.
//		Set<String> temp = new HashSet<String>(list);
//		
//		for (int i = 0; i < sample.length; i++) {
//			
//			if(temp.contains(sample[i])) {
//				temp.remove(sample[i]);
//				continue;
//			}
//			dupli = sample[i];
//		}
//		
//		System.out.println("[출력 결과]");
//		System.out.println("중복된 단어: " + dupli);
//		System.out.println("단어 수 : " + list.size());
//		System.out.println("중복되지 않은 단어: " + list);
		
	}
}
