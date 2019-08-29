package exam_array;

public class ArrayTest0 {
	public static void main(String[] args) {
		//향상된 for문으로 입력에 사용시 예제
		int[] a  = {1, 2, 3, 4, 5, 6, 7, 8, 0};
		int[] b  = new int[9];
		
		for(int num:a) {
			// 0, 0 = 0, 2
			b[num] = a[num];
			System.out.println(b[num]);
		}
		System.out.println();	
		
		//예제
		int[] numbers = new int[3];
		numbers[0]=10;
		numbers[1]=20;
		numbers[2]=30;
		
		System.out.println("number[0] = " + numbers[0]);
		System.out.println("number[1] = " + numbers[1]);
		System.out.println("number[2] = " + numbers[2]);
	}
}
