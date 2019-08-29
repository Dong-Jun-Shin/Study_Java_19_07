package exam_lab;

import java.util.Scanner;

/*
 * 다음 문제 조건을 만족하여, 무작위로 주어진 N개의 1이상 10이하의 수 중에서 각 수의 개수를 세어
 * 출력하는 프로그램을 작성하세요.
 * 
 * [규칙]
 * - 1 ~ 10의 수 N개가 띄어쓰기로 구분되어 입력된다.
 * - 입력된 수들 중에서 1, 2, 3..., 10의 개수를 각각 세어서 출력한다.
 */
public class ArrayExample2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("여러 수들을 입력해 주세요 : ");
		//String str = scan.nextLine();
		String str = "1 5 4 6 8 1 3 9 4 10 6 9 8 1 3";
		String[] array = str.split(" ");
		int[] num = new int[array.length];
		int[] qty = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			num[i] = Integer.parseInt(array[i]);
		}
		

		for (int i = 0; i < qty.length; i++) {
			for (int j = 0; j < qty.length; j++) {
				if (num[i] == j+1) {
					qty[i] += 1;
				}
			}
		}

		for (int i = 0; i < qty.length; i++) {
			System.out.printf("%d의 개수 : %d\n", i, qty[i]);
		}
		
		scan.close();
	}
}
