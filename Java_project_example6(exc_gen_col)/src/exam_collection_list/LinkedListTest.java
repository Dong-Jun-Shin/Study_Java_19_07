package exam_collection_list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("Galaxy S10");
		list.add("iPhone XS");
		list.add("LG G8");
		
		System.out.println(list.toString());
		System.out.println();
		
//		get을 이용하면 결과는 같지만 시간이 더 오래 걸린다.
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		//반복자를 사용해서 검색을 한다.
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
