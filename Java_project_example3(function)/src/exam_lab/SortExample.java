package exam_lab;

import java.util.Scanner;

/*
   1. ����ڷ� �Ͽ��� 10���� ���ڸ� �Է� �޾Ƽ� ������������ �����Ͽ� ����ϵ��� ���α׷��� �ۼ��� ������.

	[��� ���]
	
	���� 10���� �Է��Ͻÿ�&gt;&gt;90 23 45 78 95 88 55 79 59 81
	���� �� ���=======================================
	23 , 45 , 55 , 59 , 78 , 79 , 81 , 88 , 90 , 95
 */
public class SortExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("������ ������ �Է��Ͻÿ� >>");
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
		System.out.println("���� �� ��� ===============================");
		
		for (int i = 0; i < iStr.length; i++) {
			System.out.print(iStr[i] + ((i != iStr.length-1)? "\n": ", "));
			/*
			    ���� ���
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
