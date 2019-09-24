package exam_collection_list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		//프로그래밍 언어(문자열)명을 저장하도록 인스턴스 생성
		ArrayList<String> list = new ArrayList<String>();

		list.add("Java");
		list.add("Java");
		list.add("JSP");
		list.add("SPRING");

		int size = list.size();
		System.out.println("총 객체수: " + size);
		System.out.println();

		list.add(1, "ORACLE");
		list.set(2, "Client programming");
		list.remove(3);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println();
		
		//정수값을 저장하도록 인스턴스 생성
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(new Integer(23));
		list1.add(new Integer(94));
		list1.add(new Integer(62));
		list1.add(new Integer(45));
		
		System.out.println(list1.toString());
		
		list1.add(2, new Integer(78));
		System.out.println(list1.toString());
		System.out.println();
		
		//여러 사과(Apple)를 저장하도록 인스턴스 생성
		ArrayList<Apple> list2 = new ArrayList<Apple>();
		list2.add(new Apple("부사", "빨강"));
		list2.add(new Apple("아오리", "청색"));
		list2.add(new Apple("썸머킹", "황금"));
		list2.add(new Apple("홍로", "빨강"));
		
		//출력 - 1
		for (int i = 0; i < list2.size(); i++) {
			Apple app = list2.get(i);
			System.out.print("품종: " + app.getKind());
			System.out.println(", 색상: " + app.getColor());
			System.out.println(app.toString());
		}
		
		//출력 - 2
		for (int i = 0; i < list2.size(); i++) {
			System.out.print("품종: " + list2.get(i).getKind());
			System.out.println(", 색상: " + list2.get(i).getColor());
			System.out.println(list2.get(i).toString());
		}
		
		//출력 - 3 : for ~ each문으로 출력.
		for (Apple apple : list2) {
			System.out.println(apple.toString());
		}
		
		//여러 영화(Movie) 정보를 저장하도록 인스턴스 생성
		List<Movie> list3 = new ArrayList<Movie>();
		list3.add(new Movie("나쁜 녀석들: 더무비", "8.44", "손용호", "2019.09.11"));
		list3.add(new Movie("아쿠아맨", "0", "", "2019.09.11"));
		list3.add(new Movie("보헤미안 랩소디", "9.25", "브라이언 싱어", "2019.09.11"));
		
		
	}
}
