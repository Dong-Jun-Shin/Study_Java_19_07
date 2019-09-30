package exam_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/*
 * 클래스 : Fruit
 * 필드 : 과일명(name), 가격(price)
 * 
 * 1.객체배열을 선언하여 "포도"-3000, "수박"-20000, "딸기"-11900 저장한다.
 * 1-1. 그 값을 리스트 타입으로 변환하여 Collecctions.sort()를 사용하여 정렬한다.
 * Fruit array[] = {new Fruit("포도", 5000), Fruit("수박", 20000), new Fruit("딸기", 11900)};
 * 
 * List<Fruit> list = Arrays.asList(array);
 * 
 * 2.리스트 타입에 저장하여 Collections.sort()를 사용하여 정렬한다.
 */

//implements 할 때, 제네릭 타입을 명시함으로써, 타입을 알려주고 체크할 수 있게 해준다.
class Fruit implements Comparable<Fruit>{
	private String name;
	private int price;

	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int compareTo(Fruit o) {
//		if(this.getPrice() > o.getPrice()) {
//			return 1;
//		}else if(this.getPrice() == o.getPrice()) {
//			return 0;
//		}else {
//			return -1;
//		}
		
		return this.getName().compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + "]";
	}
}

public class SortTest {
	public static void main(String[] args) {
		//방법 1 - ArrayList로 만들어서 넣기
		List<Fruit> list1 = new ArrayList<Fruit>();
		list1.add(new Fruit("포도", 3000));
		list1.add(new Fruit("수박", 20000));
		list1.add(new Fruit("딸기", 11900));
		
//		for (int i = 0; i < list1.size(); i++) {
//			System.out.println(list1.get(i));
//		}
//			System.out.println();
//		for (Fruit fruit : list1) {
//			System.out.println(fruit);
//		}
//		System.out.println();
		
		//오름차순 : [딸기, 딸기, 수박]
		Collections.sort(list1);
		System.out.println("오름차순 : " + list1.toString());
		
		
		
		//방법 2 - 배열로 생성해서 만든 후, List로 변환
		Fruit[] array = {new Fruit("포도", 3000), new Fruit("수박", 20000), new Fruit("딸기", 11900)};
		List<Fruit> list2 = Arrays.asList(array);
		
//		for (int i = 0; i < list2.size(); i++) {
//			System.out.println(list2.get(i));
//		}
//		System.out.println();
//		for (Fruit fruit : list2) {
//			System.out.println(fruit);
//		}

		//내림차순 : [수박, 딸기, 포도]
		Collections.sort(list2, Collections.reverseOrder()); 
		System.out.println("내림차순 : " + list2.toString());
		
		
		
		//방법 3 - TreeSet으로 생성해서 저장 후, 출력
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>();
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 20000));
		treeSet.add(new Fruit("딸기", 11900));

		//출력방법 1 - forEach
		for (Fruit fruit : treeSet) {
			System.out.println(fruit);
		}
		System.out.println();
		
		//출력방법 2 - Iterator로 하나씩 원소 가져오기
		Iterator<Fruit> it = treeSet.iterator();
		while(it.hasNext()) {
			Fruit fruit = it.next();
			System.out.println(fruit);
		}
	}
}
