package exam_array;

import java.util.Scanner;

/*
 * �л� ���� �Է� �ް�, �� �� ��ŭ ������ �Է¹޾� ����� ���ϵ��� ���α׷��� �ۼ�
 */
public class ScoreTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int s_num;
		double avg = 0;

		System.out.print("�л� ���� �Է����ּ���. ");
		s_num = scan.nextInt();

		int[] score = new int[s_num];

		for (int i = 0; i < s_num; i++) {
			System.out.print((i + 1) + "��° �л��� ������ �Է����ּ���. ");
			score[i] = scan.nextInt();
			avg += score[i];
		}

		avg /= score.length;

		System.out.println("---------------------");
		System.out.println("�л� �� : " + score.length);
		System.out.printf("��� : %.2f", avg);
		
		scan.close();
	}
}