package exam_lab;

import java.util.Scanner;

/*
 * ���� ���� ������ �����Ͽ�, �������� �־��� N���� 1�̻� 10������ �� �߿��� �� ���� ������ ����
 * ����ϴ� ���α׷��� �ۼ��ϼ���.
 * 
 * [��Ģ]
 * - 1 ~ 10�� �� N���� ����� ���еǾ� �Էµȴ�.
 * - �Էµ� ���� �߿��� 1, 2, 3..., 10�� ������ ���� ��� ����Ѵ�.
 */
public class ArrayExample2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("���� ������ �Է��� �ּ��� : ");
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
			System.out.printf("%d�� ���� : %d\n", i, qty[i]);
		}
		
		scan.close();
	}
}
