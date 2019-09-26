package exam_collection_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class SetInterfaceTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
//		LinkedHashSet<String> set = new LinkedHashSet<String>();
//		TreeSet<String> set = new TreeSet<String>();
		
		set.add("Milk");
		set.add("Bread");
		set.add("Butter");
		set.add("Cheese");
		System.out.println("Ham".hashCode());
		set.add("Ham");
		System.out.println("Ham".hashCode());
		set.add("Ham");
		
		System.out.println(set.toString());
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
			if(it.hasNext()) {
				System.out.print(" -> ");
			}else {
				System.out.println("]");
			}
		}
		
		
		HashSet<Integer> set1 = new HashSet<Integer>();
		set1.add(3); //add(new Integer(3));
		System.out.println(new Integer(3).hashCode());
		set1.add(5);
		System.out.println(new Integer(3).hashCode());
		set1.add(3); //중복으로 허용x
		set1.add(4);
		
		System.out.println(set1.toString());
	}
}
