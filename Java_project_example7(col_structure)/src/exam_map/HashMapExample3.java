package exam_map;

import java.util.HashMap;

public class HashMapExample3 {
	public static void main(String[] args) {
		String word[] = {"BUMBLEBEE", "HEAVEN", "ALTHOUGH", "WONDER"};
		String meaning[] = {"꿀벌과에 속하는 호박벌", "천국", "그럼에도 불구하고", "호기심이 들다"};
		
		HashMap<String, String> dic = new HashMap<String, String>();
		
		for (int i = 0; i < word.length; i++) {
			dic.put(word[i], meaning[i]);
		}
		
		System.out.println(dic);	//toString() 사용
		System.out.println(dic.size());
		
		System.out.println(dic.keySet());	//key 출력	//toString() 사용
		System.out.println(dic.values());	//값 출력		//toString() 사용
		System.out.println(dic.entrySet());	//key, 값 출력	//toString() 사용
		
		//key에 따른 값 출력
		System.out.println("HEAVEN : " + dic.get("HEAVEN"));
		
		//키에 해당하는 값 변경
		dic.replace("HEAVEN",  "아주 행복한 감정");
		System.out.println("HEAVEN : " + dic.get("HEAVEN"));
		
		//키에 해당하는 값 변경
		dic.put("HEAVEN",  "이상적인 세상");
		System.out.println("HEAVEN : " + dic.get("HEAVEN"));
		
		//키와 값이 포함되어 있는지 여부
		System.out.println(dic.containsKey("BUMBLEBEE"));	//true
		System.out.println(dic.containsValue("자장가"));	//false
		
		//키 삭제 후, 키 포함여부
		dic.remove("HEAVEN");
		System.out.println(dic.containsKey("HEAVEN"));	//false
		
		//키와 값 전부 삭제, 비어있는지와 원소 개수
		dic.clear();
		System.out.println(dic.isEmpty());	//true
		System.out.println(dic.size());	//0
		
	}
}
