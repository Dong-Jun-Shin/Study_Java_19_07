package exam_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample2 {
	public static void main(String[] args) {
		HashMap<String, Student> st = new HashMap<String, Student>();
		st.put("1", new Student(20140301, "홍길동"));
		st.put("2", new Student(20140302, "김도훈"));
		st.put("3", new Student(20140303, "윤도희"));

		//기본 형식이 {1= 설정형식, 2= 설정형식, 3=...}
		System.out.println(st.toString());

		Set<String> keySet = st.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Student sst = st.get(key);
			System.out.println(key + " " + sst.toString());
		}

		//키와 값의 한 쌍으로 구성된 객체를 Set에 담아서 리턴
		for (Map.Entry<String, Student> s : st.entrySet()) {
			String key = s.getKey();
			Student value = s.getValue();
			System.out.println(key + " " + value);
		}
		
		//중복허용 x (학번기준 = key), key값은 바뀌지 않는다. value는 마지막 입력 값으로 설정된다. 
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 95);
//		map.put(new Student(1, "홍길동"), 100); 	//value 변경 -> 변경o
//		map.put(new Student(1, "길냥"), 95);		//key 변경 -> 변경x
		System.out.println("총 Entry 수: " + map.size());
		System.out.println(map.toString());
		
	}
}
