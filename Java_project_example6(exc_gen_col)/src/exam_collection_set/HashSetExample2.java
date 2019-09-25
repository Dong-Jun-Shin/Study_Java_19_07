package exam_collection_set;

import exam_api_object.exam02_hashcode.Member;
import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();

		//hash 코드 값이 달라서 다르다고 판단.
//		set.add(new Member("홍길동", 33));
//		set.add(new Member("홍길동", 33));
//		set.add(new Member("김철수", 36));

		//이름과 나이 동일한지 판단 (add로  재정의된 equals()를 호출해서 판단)
		//List에 add를 사용시 제한을 주고 싶다면 equals()를 재정의하면서 작성
		set.add(new Member("홍길동", 33));
		set.add(new Member("이진희", 33));
		set.add(new Member("김철수", 36));

		System.out.println("총 객체수 : " + set.size());
		
		//hashCode() 호출
		System.out.println("\t" + set.toString());
	}
}
