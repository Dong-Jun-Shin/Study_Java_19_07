package exam_lab;

import java.util.Scanner;

/*
 * <n x n ���> �Ʒ��� ���� ��Ģ�� ���� n�� n���� 2���� �迭�� ����ϴ� ���α׷��� �ۼ��ϼ���.
 * 
 * [������]
 * enter the number : 3
 * 1	6	7
 * 2	5	8
 * 3	4	9
 * 
 * enter the number : 5
 * 1	10	11	20	21
 * 2	9	12	19	22
 * 3	8	13	18	23
 * 4	7	14	17	24
 * 5	6	15	16	25
 */
public class ArrayExample4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input;
		int num = 1;
		int plusMinus = 1;

		System.out.print("enter the number : ");
		input = scan.nextInt();

		int[][] array = new int[input][input];

		for (int j = 0; j < array.length; j++) {
			if (input == 0) {
				for (int i = input; i < array[j].length; i += plusMinus, num++) {
					array[i][j] = num;

					if (i == array[j].length - 1) {
						input = i;
					}
				}
			} else if (input == array[j].length - 1) {
				for (int i = input; i >= 0; i += plusMinus) {
					array[i][j] = num;

					if (i == 0) {
						input = i;
					}
				}
			}
			plusMinus *= -1;
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.printf("%6d", array[i][j]);
			}
			System.out.println();
		}
		scan.close();
	}
}
