package exam_array_2Dimension;

import java.util.Scanner;

public class Rainfall {
	public static void main(String[] args) {
		final int YEARS = 3; // 3년
		final int QUARTERS = 5; // 4분기 + 총합

		// 2차원 배열 선언 년도 분기
		double[][] rain = new double[YEARS][QUARTERS];
		Scanner scan = new Scanner(System.in);

		for (int y = 0; y < YEARS; y++) {
			// -1인 이유는 총합을 위한 행마다 끝열을 비워 놓은 것
			for (int q = 0; q < QUARTERS - 1; q++) {
				System.out.print((y + 1) + "년차 " + (q + 1) + "분기 강수량: ");
				rain[y][q] = scan.nextDouble();

			}
		}

		//행의 끝 열을 총합 계산해서 넣는 공간으로 활용
		for (int y = 0; y < YEARS; y++) {
			for (int q = 0; q < QUARTERS - 1; q++) {
				rain[y][QUARTERS - 1] += rain[y][q];
			}
		}
		
		System.out.println("----------------------------");
		for (int y = 0; y < YEARS; y++) {
			System.out.println((y+1) + "년도\t1분기\t2분기\t3분기\t4분기\t총합");
			System.out.print("강수량 |");
			for (int q = 0; q < QUARTERS; q++) {
				System.out.printf("\t%.1f", rain[y][q]);
				System.out.print(" |");
			}
			System.out.printf("\n");
		}
		scan.close();
	}
}
