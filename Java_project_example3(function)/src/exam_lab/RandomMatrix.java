package exam_lab;

import java.util.Scanner;

/*
 * 2���� �迭(4x4)�� �����Ѵ�. �� �迭�� ������ ��(1~9)�� ������ ��ġ�� 8���� �����ϰ�
 * ������ 8���� 0���� ����ǵ��� �迭�� ó���ϰ� ����ϴ� ���α׷��� �ۼ��� ������.
 */
public class RandomMatrix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�迭�� ũ�⸦ �Է����ּ���>> ");
		int input = scan.nextInt();
		int[][] mtx = new int[input][input];
		
		/* while�� ����� ���
		 * 
		 * while (num < 8){
		 * 		int i = (int)((Math.random()*input));
		 *		int j = (int)((Math.random()*input));
		 *
		 *		if(mtx[i][j] != 0) {
		 *			continue;
		 *		}else {
		 *			mtx[i][j] = (int)((Math.random()*9)+1);	
		 *			n++;
		 *		} 
		 * }
		 */
		
		for (int n = 0; n < (input*input)/2; n++) {
			int i = (int)((Math.random()*input));
			int j = (int)((Math.random()*input));
			
			if(mtx[i][j] == 0) {
				mtx[i][j] = (int)((Math.random()*9)+1);	
			}else {
				n--;
			}
		}
		
		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[i].length; j++) {
				System.out.print(mtx[i][j]+" ");
			}
			System.out.println();
		}
		scan.close();
	}
}
