package exam_if;

import java.util.Scanner;

/*
 * 사용자로부터 키를 입력받아서 표준 체중을 계산한 후에
 * 사용자의 체중과 비교하여 저체중인지, 표준인지, 과체중인지를 판단하는 프로그램을 작성하라.
 * 표준 체중 계산식은 다음을 사용하라.
 * 표준체중 = (키 - 100) x 0.9
 * 
 * 
 * stature : 사람이 섰을 때의 높이
 * height : 바닥, 발 밑에서 정상까지의 거리
 */
public class WeightExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double u_height, u_weight, weight;
		
		System.out.println("키를 입력해주세요.");
		u_height = scan.nextDouble();

		System.out.println("체중을 입력해주세요.");
		u_weight = scan.nextDouble();

		weight = (u_height - 100) * 0.9;

		System.out.println("표준체중 = " + (int)weight);
		
		if((int)u_weight == (int)weight) {
			System.out.println("당신은 표준체중입니다.");
		}else if((int)u_weight > (int)weight) {
			System.out.println("당신은 과체중입니다.");
		}else {
			System.out.println("당신은 저체중입니다.");
		}
		
		scan.close();
	}
}
