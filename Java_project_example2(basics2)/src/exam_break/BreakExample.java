package exam_break;

import java.util.Scanner;

/*사용자가 입력한 점수의 총점, 평균을 내는 프로그램을 작성하시오.
 * 단 종료는 - ~ 100 사이가 아닌 값 입력하면 된다.
 */
public class BreakExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int u_score, cnt = 0;
		double  total = 0;

		while (true) {
			System.out.println((cnt + 1) + "번째 점수를 입력해주세요.");
			u_score = scan.nextInt();
			
			if(u_score>100 || u_score<0) {
				break;
			}
			total = (int)total + u_score;
			cnt++;
			
		}
		System.out.printf("총점: %d", (int)total);
		
		total = total / cnt;
		System.out.printf(", 평균: %.2f", total);
				
		scan.close();
	}
}
