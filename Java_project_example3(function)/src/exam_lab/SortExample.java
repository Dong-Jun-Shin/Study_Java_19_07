package exam_lab;

import java.util.Scanner;

/*
   1. 사용자로 하여금 10개의 숫자를 입력 받아서 오름차순으로 정렬하여 출력하도록 프로그램을 작성해 보세요.

	[출력 결과]
	
	정수 10개를 입력하시오&gt;&gt;90 23 45 78 95 88 55 79 59 81
	정렬 후 결과=======================================
	23 , 45 , 55 , 59 , 78 , 79 , 81 , 88 , 90 , 95
 */
public class SortExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 여러개 입력하시오 >>");
//		String str = "90 23 45 78 95 88 55 79 59 81";
		String str = scan.nextLine();
		String[] sStr= str.split(" ");
		int[] iStr = new int[sStr.length];
		
		
		for (int i = 0; i < iStr.length; i++) {
			iStr[i] = Integer.parseInt(sStr[i]);
		}
		
		for (int i = 0; i < iStr.length-1; i++) {
			for (int j = 0; j < iStr.length-(i+1); j++) {
				if(iStr[j] > iStr[j+1]) {
					int temp;
					temp = iStr[j];
					iStr[j] = iStr[j+1];
					iStr[j+1] = temp;
				}
			}			
		}
		System.out.println("정렬 후 결과 ===============================");
		
		for (int i = 0; i < iStr.length; i++) {
			System.out.print(iStr[i] + ((i != iStr.length-1)? "\n": ", "));
			/*
			    같은 방법
				(i != iStr.length-1)? "\n": ", ")
				-----------------------------------
				if(i != iStr.length-1) {
					System.out.print(", ");
				}
			*/
		}
		scan.close();
	}
}
