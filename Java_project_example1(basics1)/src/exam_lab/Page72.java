package exam_lab;

public class Page72 {
	public static void main(String[] args) {
		final double light; // velocity �ӵ�, ���� �ӵ�
		double distance;

		light = 30e4;
		distance = (40e12);

		distance = distance / light;
		distance = distance / 60 / 60 / 24 / 365;
		
		System.out.printf("�ɸ��� �ð��� %.15f�����Դϴ�.\n", distance);
	}
}
