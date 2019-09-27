package exam_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample0 {
	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("고진감래", "고생 끝에 즐거움이 옴");
		dic.put("분골쇄신", "몸이 부서질 정도로 노력을 다함");
		dic.put("권토중래", "실패를 발판삼아 재기함");
		dic.put("교학상자", "가르치고 배우면서 서로 성장함");
		dic.put(null, null); //HashMap은 null 값 저장 가능
		
		//방법1 (반복자-Iterator 사용)
		Set<String> keySet = dic.keySet();
		Iterator<String> keys = keySet.iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("%s : %s",  key, dic.get(key)));
		}
		System.out.println();
		
		//방법2 (Map.Entry형 elem변수에 넣어서 사용)
		// entrySet() 사용, Set<Map.Entry<K,V>> 형태의 객체를 반환.
		// 하나씩 가져다 쓰는데, 원소의 타입이 Map.Entry<K, V>이어서 해당 변수를 만들고 대입
		for (Map.Entry<String, String> elem : dic.entrySet()) {
			System.out.println(String.format("%s : %s",  elem.getKey(), elem.getValue()));
		}
		System.out.println();
		
		//방법3
		// keySet() 사용
		// 키만 가져온다.
		for (String key : dic.keySet()) {
			System.out.println(String.format("%s : %s",  key, dic.get(key)));
		}
	}
}
