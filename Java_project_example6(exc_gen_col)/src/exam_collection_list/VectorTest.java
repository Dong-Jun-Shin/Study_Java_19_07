package exam_collection_list;

import java.util.Iterator;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector<Movie> list = new Vector<Movie>();
		list.addElement(new Movie("스윙키즈","0","강형철","2018.12.19"));
		list.addElement(new Movie("나쁜 녀석들: 더 무비","8.44","손용호","2019.09.01"));
		list.addElement(new Movie("아쿠아맨", "0", "론 하워드", "2018.12.19"));
		
		printData(list);
	}
	
	private static void printData(Vector<Movie> list) {
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.elementAt(i));
//		}
		
		Iterator<Movie> e = list.iterator();
		while(e.hasNext()) {
			System.out.println(e.next());
		}
	}
}
