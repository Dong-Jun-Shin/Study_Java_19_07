package exam_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * List형태를 정렬하면서 사용
 */

public class Sort {
	public static void main(String[] args) {
		String[] sample = {"i", "walk", "the", "line", "apple"};
		List<String> list = Arrays.asList(sample);
		
		Collections.sort(list); //오름차순
		//toString
		System.out.println("오름차순 : " + list.toString());
		//forEach
		for (String string : list) {
			System.out.println(string);
		}
		//for
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		Collections.sort(list, Collections.reverseOrder()); //내림차순
		System.out.println("내림차순 : " + list.toString());
	}
}
