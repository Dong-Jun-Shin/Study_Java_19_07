package exam_collection_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 장기 자랑 프로그램에 사용될 수 있는 심사 위원들의 점수를 집계하는 프로그램을 작성하라.
 * 점수는 0.0에서 10.0까지 가능하다. 10명의 점수 입력받아 그 중에서
 * 최고 점수(Collections.max(리스트의 참조변수))와 최저 점수(Collections.min(리스트의 참조변수))
 * 는 제외된다. Double 타입의 ArrayList를 사용하라.
 * [실행결과]
 * 	심사위원의 점수: 1
 *  심사위원의 점수: 2
 *  심사위원의 점수: 3
 *  심사위원의 점수: 4
 *  심사위원의 점수: 5
 *  심사위원의 점수: 6
 *  심사위원의 점수: 7
 *  심사위원의 점수: 8
 *  심사위원의 점수: 9
 *  심사위원의 점수: 10
 *  -----------------
 *  총합 : 55점
 */
public class ArrayListExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<Double>(); //wrapper
		double dnum = 0.0; 

		for (int i = 0; i < 10; i++) {
			System.out.print("(" + (i+1) + "번째)심사위원의 점수: ");
			double dTemp = scan.nextDouble();
			if(dTemp <= 0 || dTemp > 10) {
				i--;
				continue;
			}
//			list.add(new Double(dTemp));
			list.add(dTemp);			
		}

		//1번째 방법(if로 필터해서 더하기)
		for (int i = 0; i < 10; i++) {
			if(list.get(i) != Collections.max(list) && list.get(i) != Collections.min(list)) {
			dnum += list.get(i);
			}
		}
		
		//2번째 방법(for)(다 더하고 빼기)
//		for (int i = 0; i < list.size(); i++) {
//			dnum += list.get(i);
//		}
//		dnum = dnum - Collections.max(list) - Collections.min(list);

		//3번째 방법(for~each)(다 더하고 빼기)
//		for (Double double1 : list) {
//			dnum += double1.doubleValue();
//		}
//		dnum = dnum - Collections.max(list) - Collections.min(list);
		
		System.out.println("-------------------------------");
		System.out.println("총합 : " + dnum);
				
		scan.close();
	}
}
