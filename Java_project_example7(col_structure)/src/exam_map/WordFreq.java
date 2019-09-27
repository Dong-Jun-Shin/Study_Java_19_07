package exam_map;

import java.util.HashMap;
import java.util.Map;

/*
 * 클래스명 : WordFreq
 * 문자열에 포함된 단어의 빈도를 계산하여
 * 단어를 Key로, 빈도를 Value로 저장하여 출력해 보세요.
 * String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
 * 
 * [실행결과]
 * 총 단어 수 : 7개
 * {a=1, not=1 , be=2, or=1, problem=1, is=1, to=2}
 */
public class WordFreq {
	public static void main(String[] args) {
		String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
		Map<String, Integer> wFreq = new HashMap<String, Integer>();
		
		//방법1
		for (String a : sample) {
			System.out.println(wFreq.get(a));
			Integer freq = wFreq.get(a); //값을 가져온다. | 해당 키나 값이 없으면 null, 있으면 해당 값 반환
			wFreq.put(a, (freq == null)? 1 : freq + 1);
		}
				
		//방법2
//		Integer[] freq = new Integer[sample.length];
//		for (int i = 0; i < sample.length; i++) {
//			freq[i] = 0;
//			for (int j = 0; j < freq.length; j++) {
//				if(sample[i].equals(sample[j])) {
//					freq[i]++;
//				}			
//			}
//		}
//		
//		for (int i = 0; i < sample.length; i++) {
//			wFreq.put(sample[i], freq[i]);			
//		}
		
		System.out.println("총 단어 수 : " + wFreq.size() + "개");
		System.out.println(wFreq);
	}
}
