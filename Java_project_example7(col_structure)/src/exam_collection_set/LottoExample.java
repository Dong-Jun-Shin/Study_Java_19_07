package exam_collection_set;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/*
 * 로또 번호를 생성하는 프로그램을 작성하여 보자.
 * 로또는 1부터 45까지의 숫자 중에서 6개를 선택한다. 로또 번호는 중복되면 안 된다.
 * Math.random()을 사용하면 0부터 1사이의 난수를 생성할 수 있다.
 * 0부터 1사이의 난수가 생성되면 여기에 45를 곱하고 1을 더하면 1부터 45사이의 정수를 생성할 수 있다.
 * 생성된 정수는 HashSet의 contains() 메소드를 이용하여서 이미 선택된 정수인지를 검사한다.
 * 
 * [출력결과]
 * Lotto 번호 [17, 18, 5, 23, 25, 43]
 */
@SuppressWarnings("unused")
public class LottoExample {
	public static void main(String[] args) {
		Set<Integer> num = new HashSet<Integer>(); //비정렬, 비순차
//		Set<Integer> num = new LinkedHashSet<Integer>(); //비정렬, 순차
//		Set<Integer> num = new TreeSet<Integer>(); //정렬, 순차

		for (int i = 0; i < 6; i++) {
			int lnum = (int)(Math.random()*45 + 1);
			if(num.contains(lnum)) {
				i--;
				continue;
			}
			num.add(lnum);
		}
				
		for (Integer integer : num) {
			System.out.print(integer + "\t");
		}
	}
}
