package exam_array_2Dimension;

import java.util.Scanner;

public class Rainfall {
	public static void main(String[] args) {
		final int YEARS = 3; // 3��
		final int QUARTERS = 5; // 4�б� + ����

		// 2���� �迭 ���� �⵵ �б�
		double[][] rain = new double[YEARS][QUARTERS];
		Scanner scan = new Scanner(System.in);

		for (int y = 0; y < YEARS; y++) {
			// -1�� ������ ������ ���� �ึ�� ������ ��� ���� ��
			for (int q = 0; q < QUARTERS - 1; q++) {
				System.out.print((y + 1) + "���� " + (q + 1) + "�б� ������: ");
				rain[y][q] = scan.nextDouble();

			}
		}

		//���� �� ���� ���� ����ؼ� �ִ� �������� Ȱ��
		for (int y = 0; y < YEARS; y++) {
			for (int q = 0; q < QUARTERS - 1; q++) {
				rain[y][QUARTERS - 1] += rain[y][q];
			}
		}
		
		System.out.println("----------------------------");
		for (int y = 0; y < YEARS; y++) {
			System.out.println((y+1) + "�⵵\t1�б�\t2�б�\t3�б�\t4�б�\t����");
			System.out.print("������ |");
			for (int q = 0; q < QUARTERS; q++) {
				System.out.printf("\t%.1f", rain[y][q]);
				System.out.print(" |");
			}
			System.out.printf("\n");
		}
		scan.close();
	}
}
