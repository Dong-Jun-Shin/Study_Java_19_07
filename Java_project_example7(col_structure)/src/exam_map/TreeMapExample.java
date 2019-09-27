package exam_map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		//정렬
		TreeMap<String, String> users = new TreeMap<String, String>();
		
		users.put("20080319", "김푸름");
		users.put("20070620", "김하늘");
		users.put("20050817", "오정수");
		users.put("20120728", "이영희");
		users.put("20120924", "홍길동");
		
		System.out.print("모든 사원 정보 : ");
		System.out.println(users.toString());
		System.out.println();
		
		Map.Entry<String, String> entry = null;
		
		//firstEntry() | 정렬기준, 맨 앞을 가져온다.
		entry = users.firstEntry(); 
		print("입사일자가 가장 빠른 사람 ", entry);
		
		//lastEntry() | 정렬기준, 맨 뒤를 가져온다.
		entry = users.lastEntry(); 
		print("입사일자가 가장 늦은 사람 ", entry);
		
		//lowerEntry() | 인자로 전달한 키값의 이전 위치를 찾아서 반환한다.
		entry = users.lowerEntry("20121231");
		print("2012년도에 가장 늦게 입사한 사람", entry);
		
		//higherEntry() | 인자로 전달한 키값의 다음 위치를 찾아서 반환한다.
		entry = users.higherEntry("20120101");
		print("2012년도에 가장 빠르게 입사한 사람", entry);
		
		//pollFirstEntry() | 가장 작은 키값을 가진 Entry를 삭제한다.
		//pollLastEntry() | 가장 큰 키값을 가진 Entry를 삭제한다..
		while(!users.isEmpty()) {
			entry = users.pollFirstEntry();
			print("퇴직한 사람", entry);
			System.out.println("남아있는 직원 수 : " + users.size());
		}
	}
	
	public static void print(String s, Map.Entry<String, String> entry) {
		System.out.println(s + " : " + entry.getKey() + " / " + entry.getValue());
		System.out.println();
	}
}
