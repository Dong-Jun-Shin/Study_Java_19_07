package exam_break;

import java.util.Scanner;

/*����ڰ� �Է��� ������ ����, ����� ���� ���α׷��� �ۼ��Ͻÿ�.
 * �� ����� - ~ 100 ���̰� �ƴ� �� �Է��ϸ� �ȴ�.
 */
public class BreakExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int u_score, cnt = 0;
		double  total = 0;

		while (true) {
			System.out.println((cnt + 1) + "��° ������ �Է����ּ���.");
			u_score = scan.nextInt();
			
			if(u_score>100 || u_score<0) {
				break;
			}
			total = (int)total + u_score;
			cnt++;
			
		}
		System.out.printf("����: %d", (int)total);
		
		total = total / cnt;
		System.out.printf(", ���: %.2f", total);
				
		scan.close();
	}
}
