package exam_if;

import java.util.Scanner;

/*
 * ����ڷκ��� Ű�� �Է¹޾Ƽ� ǥ�� ü���� ����� �Ŀ�
 * ������� ü�߰� ���Ͽ� ��ü������, ǥ������, ��ü�������� �Ǵ��ϴ� ���α׷��� �ۼ��϶�.
 * ǥ�� ü�� ������ ������ ����϶�.
 * ǥ��ü�� = (Ű - 100) x 0.9
 * 
 * 
 * stature : ����� ���� ���� ����
 * height : �ٴ�, �� �ؿ��� ��������� �Ÿ�
 */
public class WeightExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double u_height, u_weight, weight;
		
		System.out.println("Ű�� �Է����ּ���.");
		u_height = scan.nextDouble();

		System.out.println("ü���� �Է����ּ���.");
		u_weight = scan.nextDouble();

		weight = (u_height - 100) * 0.9;

		System.out.println("ǥ��ü�� = " + (int)weight);
		
		if((int)u_weight == (int)weight) {
			System.out.println("����� ǥ��ü���Դϴ�.");
		}else if((int)u_weight > (int)weight) {
			System.out.println("����� ��ü���Դϴ�.");
		}else {
			System.out.println("����� ��ü���Դϴ�.");
		}
		
		scan.close();
	}
}
