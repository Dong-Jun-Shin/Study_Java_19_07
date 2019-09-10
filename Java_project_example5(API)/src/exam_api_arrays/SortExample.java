package exam_api_arrays;

import java.util.Arrays;

@SuppressWarnings("rawtypes")
class Member implements Comparable{
	private String name;
	private String lang;
	private int age;
	
	public Member() {
	}
	
	public Member(String name, String lang, int age) {
		super();
		this.name = name;
		this.lang = lang;
		this.age = age;
	}
	
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getLang() {
		return lang;
	}
	public final void setLang(String lang) {
		this.lang = lang;
	}
	public final int getAge() {
		return age;
	}
	public final void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", lang=" + lang + ", age=" + age + "]";
	}

	//Arrays.sort를 사용하기 위해 compareTo가 있어야 한다. (구현과 오버라이딩)
	@Override
	public int compareTo(Object o) {
		Member m  = (Member)o;
		
		//숫자는 정의되어 있지 않기 때문에, 직접 비교해서 정의해준다.
//		이 객체가 다른 객체보다 크면 1, 같으면 0, 작으면 -1을 반환한다.
		if(this.age > m.age)
			return 1;
		else if(this.age < m.age)
			return -1;
		else
			return 0;
		
		//문자열은 String에 정의되 있는 compareTo를 사용해서 반환해준다.
//		return name.compareTo(m.name);
//		return lang.compareTo(m.lang);
	}
	
}


public class SortExample {
	public static void printArray(int[] array) {
		System.out.print("[");
		int c = 2; //시작 = 1, 끝에 출력 안해야 함 = 1
		for (int i : array) {
			System.out.print(i);
			if(c <= array.length) {
				System.out.print(", ");
			}
			c++;
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		int[] array = {9,4,5,6,2,1};
		Arrays.parallelSort(array);
		printArray(array);
		
		System.out.println(Arrays.toString(array));
		
		Arrays.fill(array, 8);
		printArray(array);
		
		String[] names = { "홍길동", "박동수", "김민수"};
		Arrays.parallelSort(names);
		System.out.println(Arrays.toString(names));
		System.out.println();
		
		Member mem1 = new Member("홍길동","java", 42);
		Member mem2 = new Member("박동수","array", 36);
		Member mem3 = new Member("김민수","html", 25);
		Member[] members = {mem1, mem2, mem3};
		
		Arrays.sort(members);
		
		for (int i = 0; i < members.length; i++) {
			System.out.println(members[i].toString());
		}
		
//		String[] name = new String[members.length];
//		for (int i = 0; i < members.length; i++) {
//			name[i] = members[i].getName();
//		}
//		
//		Arrays.sort(name);
//		
//		for (int i = 0; i < members.length; i++) {
//			for (int j = 0; j < name.length; j++) {
//				if(name[i] == members[j].getName()) {
//					System.out.println(members[j].toString());				
//				}				
//			}
//		}
		
	}
}
