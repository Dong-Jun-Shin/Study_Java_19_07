package exam_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* 범죄, 112 / 화재, 119 / 전화번호, 114 데이터가 HashMap에 저장되어 있다.
 * 이 값(value)을 ArrayList 자료구조에 저장할 수 있도록 toArrayList() 메소드를 
 * 정의하고 main()에서 출력하도록 프로그램 작성해 주세요.
 */



public class HashToArrayList {
	//하나씩 넣기
//	public static void toArrayList(HashMap<String, Integer> pBook, ArrayList<Integer> alist, String key) {
//		alist.add(pBook.get(key));
//	}
	
	//한번에 넣기
	public static ArrayList<String> toArrayList(HashMap<String, String> hash){
		ArrayList<String> list = new ArrayList<String>();
		//키를 세팅
		Set<String> set = hash.keySet();
		//반복자
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			list.add(hash.get(key));
		}
		return list;
	}
	
	public static void main(String[] args) {
		HashMap<String, String> pBook = new HashMap<String, String>();
		pBook.put("범죄", "112");
		pBook.put("화재", "119");
		pBook.put("전화번호", "114");
		
		//하나씩 값 넣기
//		ArrayList<String> alist = new ArrayList<String>();
//		toArrayList(pBook, alist, "범죄");
//		toArrayList(pBook, alist, "화재");
//		toArrayList(pBook, alist, "전화번호");
		
		//한번에 값 넣기
		ArrayList<String> alist = toArrayList(pBook);
		
		for (String integer : alist) {
			System.out.println(integer);			
		}
		System.out.println(alist);
		
		
		
	}
}

