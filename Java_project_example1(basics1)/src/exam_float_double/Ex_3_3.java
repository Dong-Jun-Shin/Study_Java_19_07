package exam_float_double;

/**
 * ������ ���� 3-3
 */
public class Ex_3_3 {
	public static void main(String[] args) {
		int r = 5;
		final float PI = 3.14F;
		float round, area;

		round = 2 * r * PI;
		area = PI * r * r;

		System.out.println("round : " + round);
		System.out.println("area : " + area);
		
		//%2d -> ����
		//%.2f -> .���� �ڸ��� float		
		//%2c -> ������
		//%s -> ���ڿ�
		
		System.out.printf("round : %.2f\narea : %.2f\n", round, area);
	}
}