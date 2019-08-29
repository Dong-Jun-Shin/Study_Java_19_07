package exam_lab;

public class Page72 {
	public static void main(String[] args) {
		final double light; // velocity 속도, 빠른 속도
		double distance;

		light = 30e4;
		distance = (40e12);

		distance = distance / light;
		distance = distance / 60 / 60 / 24 / 365;
		
		System.out.printf("걸리는 시간은 %.15f광년입니다.\n", distance);
	}
}
