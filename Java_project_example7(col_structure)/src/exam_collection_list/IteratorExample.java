package exam_collection_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("트랜스포머");
		list.add("스타워즈");
		list.add("매트릭스");
		list.add(0, "터미네이터");
		list.add(2, "아바타");
		
		Collections.sort(list);
		System.out.println("원소 정렬 후(오름차순): ");
		printList(list);
		
		Collections.reverse(list);
		System.out.println("원소 정렬 후 거꾸로(내림차순): ");
		printList(list);
	}
	
	public static void printList(List<String> list) {
		String str, separator;
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			str = it.next();
			if(it.hasNext()) {
				separator = " -> ";
			}else {
				separator = "\n";
			}
			System.out.print(str + separator);
		}
	}
}
