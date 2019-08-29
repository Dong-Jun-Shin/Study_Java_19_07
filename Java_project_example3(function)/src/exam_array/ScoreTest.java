package exam_array;

import java.util.Scanner;

/*
 * 학생 수를 입력 받고, 그 수 만큼 점수를 입력받아 평균을 구하도록 프로그램을 작성
 */
public class ScoreTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int s_num;
		double avg = 0;

		System.out.print("학생 수를 입력해주세요. ");
		s_num = scan.nextInt();

		int[] score = new int[s_num];

		for (int i = 0; i < s_num; i++) {
			System.out.print((i + 1) + "번째 학생의 점수를 입력해주세요. ");
			score[i] = scan.nextInt();
			avg += score[i];
		}

		avg /= score.length;

		System.out.println("---------------------");
		System.out.println("학생 수 : " + score.length);
		System.out.printf("평균 : %.2f", avg);
		
		scan.close();
	}
}