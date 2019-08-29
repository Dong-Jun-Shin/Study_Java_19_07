package exam_array;

public class TwoArray {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] b = new int[10];

		int i = 9;
		for (int value : a) {
			b[i]= value;
			i--;
		}
		for(int value : b) {
			System.out.print(value+" ");			
		}
	}
}
