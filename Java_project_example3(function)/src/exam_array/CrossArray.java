package exam_array;

/*
 * 8���� ������ a{2, 4, 6, 8, 10, 12, 14, 16}�� b{1, 1, 2, 3, 5, 8, 13, 21}�� �Է��� ��
 * a�� ù��° �ε������� ������ �ε�����, b�� ������ �ε������� ù��° �ε����� ũ�ν��ϸ鼭 ���� ���Ͽ� a�� ������ �� ����Ͻÿ�.
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
