package exam_collection_set;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(new Integer(20));
		set.add(new Integer(90));
		set.add(new Integer(75));
		set.add(new Integer(92));
		set.add(new Integer(50));
		
		//toString과 descendingSet
		System.out.println("Sorting(오름차순) : " + set.toString());
		System.out.println("Sorting(내림차순) : " + set.descendingSet());
		
		//first와 last
		System.out.println("가장 낮은 점수: " + set.first());
		System.out.println("가장 높은 점수: " + set.last());
		
		//주어진 객체보다 바로 아래 객체 리턴
		System.out.println("90점 아래 점수: " + set.lower(new Integer(90)));
//		System.out.println("90점 아래 점수: " + set.lower(90));
		//주어진 객체보다 바로 위 객체 리턴
		System.out.println("90점 위 점수: " + set.higher(new Integer(90)));
		System.out.println("90점 위 점수: " + set.higher(90));
		System.out.println();
		
		/* TreeSet 클래스는 NavigableSet<E>인터페이스를 구현한 구현 클래스.
		 * NavigableSet<E> 인터페이스는 SortedSet<E> 인터페이스를 상속받은 인터페이스 
		 */
		SortedSet<Member> mSet = new TreeSet<Member>();
		mSet.add(new Member("홍길동", 30));
		mSet.add(new Member("김철수", 34));
		mSet.add(new Member("이민수", 29));
		mSet.add(new Member("김희진", 45));
		
//		System.out.println("Member Sorting: " + mSet.toString());
		
		//Score 클래스는 국어, 수학 점수를 필드로 갖는 클래스로, 인스턴스 생성시 초기값 설정되도록 코딩.
		//TreeSet은 원소가 추가될 때마다, 정의된 compareTo()로 원소끼리 비교해서 정렬한다.
		TreeSet<Score> tSet = new TreeSet<Score>();
		tSet.add(new Score(21, 22));
		tSet.add(new Score(71, 78));
		tSet.add(new Score(11, 12));
		tSet.add(new Score(31, 32));
		
		System.out.println("\n반복자를 이용하여 출력 - 오름차순");
		Iterator<Score> it = tSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("\n반복자를 이용하여 출력 - 내림차순");
		SortedSet<Score> sSet = tSet.descendingSet();
		Iterator<Score> sIt = sSet.iterator();
		while(sIt.hasNext()) {
			System.out.println(sIt.next());
		}
		
	}
}
