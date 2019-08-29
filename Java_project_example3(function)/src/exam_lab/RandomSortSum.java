package exam_lab;

/*
   2. 정수 1 ~ 10까지의 난수를 9개를 대입 받은 일차원 배열을 정렬한 후 총합을 마지막 요소에 대입한 후 출력하는 프로그램을 작성해 주세요.

	[출력 결과]
	
	[정렬전]
	
	7 8 6 2 1 9 10 7 5
	
	[정렬후]</span>
	
	1 +2 + 5 + 6 + 7 + 7 + 8 + 9 + 10 = 55
 */
public class RandomSortSum {
	public static void main(String[] args) {
		int[] ranNum = new int[10];
		
		for (int i = 0; i < ranNum.length-1; i++) {
			ranNum[i] = (int)((Math.random()*10)+1);
			ranNum[9] += ranNum[i];
		}
		
		for (int i = 0; i < ranNum.length-1; i++) {
			for (int j = 0; j < ranNum.length-(i+2); j++) {
				if(ranNum[j]>ranNum[j+1]) {
					int temp;
					temp = ranNum[j];
					ranNum[j] = ranNum[j+1];
					ranNum[j+1] = temp;					
				}
			}			
		}

		for (int i = 0; i < ranNum.length; i++) {
			System.out.print(ranNum[i]);
			if(i < ranNum.length-2) {
				System.out.print(" + ");
			}
			if(i == 8) {
				System.out.print(" = ");
			}
		}
	}}



