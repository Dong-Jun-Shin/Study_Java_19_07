package exam_array;

/*
 * 8개의 정수를 a{2, 4, 6, 8, 10, 12, 14, 16}와 b{1, 1, 2, 3, 5, 8, 13, 21}에 입력한 후
 * a의 첫번째 인덱스에서 마지막 인덱스로, b의 마지막 인덱스에서 첫번째 인덱스로 크로스하면서 합을 구하여 a에 대입한 후 출력하시오.
 */
public class CrossArray {
	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 10, 12, 14, 16 };
		int[] b = { 1, 1, 2, 3, 5, 8, 13, 21 };
		
		for(int i = 0; i<a.length; i++) {
			a[i] = a[i] + b[b.length-(i+1)];
		}
		for(int value: a) {
			System.out.print(value+" ");
		}
	}
}
