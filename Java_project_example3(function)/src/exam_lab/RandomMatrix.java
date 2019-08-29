package exam_lab;

import java.util.Scanner;

/*
 * 2차원 배열(4x4)이 존재한다. 그 배열에 임의의 수(1~9)를 임의의 위치에 8개를 저장하고
 * 나머지 8개는 0으로 저장되도록 배열을 처리하고 출력하는 프로그램을 작성해 보세요.
 */
public class RandomMatrix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("배열의 크기를 입력해주세요>> ");
		int input = scan.nextInt();
		int[][] mtx = new int[input][input];
		
		/* while문 사용한 방법
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
