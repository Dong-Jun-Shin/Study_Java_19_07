package exam_class;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 키보드로 10개의 나라 이름과 인구를 입력받아 모두 HashMap에 삽입한 뒤, 
 * 나라 이름을 키보드로부터 입력받아 그 나라의 인구를 출력하는 프로그램을 작성하라.
 * 
 * [실행 예시 - 2개의 데이터 입력]
 * 나라 이름과 인구를 10개 입력하세요. ( 예: 대한민군 51833175)
 * 나라 이름, 인구 >> 대한민국 51833175
 * 나라 이름, 인구 >> 영국 66830229
 * 
 * 나라 이름을 입력하면 인구를 검색할 수 있습니다. 끝을 입력하면 종료합니다.
 * 나라 이름 >> 대한민국
 * 대한민국의 인구는 51,833,175
 * 나라 이름 >> 영국
 * 영국의 인구는 66,830,229
 * 나라 이름 >> 끝
 * 프로그램을 종료합니다.
 */
public class HashMapNation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> nation = new HashMap<String, Integer>();
		// 표시형식 지정
		DecimalFormat decimalFormat = new DecimalFormat("#,###");

		int count = 10;

		System.out.println("나라 이름과 인구를 10개 입력하세요.(예 : 대한민국 51833175)");
		for (int i = 0; i < count; i++) {
			System.out.print("나라 이름, 인구 >> ");
			String str = scan.nextLine();
			String[] nationStr = str.split(" ");
			nation.put(nationStr[0], Integer.valueOf(nationStr[1]));
		}

		System.out.println("나라 이름을 입력하면 인구를 검색할 수 있습니다. 끝을 입력하면 종료합니다.");
		
		while (true) {
			System.out.print("나라 이름 >> ");
			String nationName = scan.nextLine();

			if (nationName.equals("끝")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			String population = decimalFormat.format(nation.get(nationName));

			System.out.println(nationName + "의 인구는 " + population);

		}

		scan.close();
	}
}
