package exam_while;

import java.util.Scanner;

/*
 * ����ڷκ��� 5���� ������ �о �հ� ��հ��� ����Ͽ� ����ϴ� ���α׷��� �ۼ��϶�.
 */
public class NumberSum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n, i;
		int sum = 0;
		float avg = 0;
		int num_amount;
		
		System.out.println("����� ���� ���ϰڽ��ϱ�? ");
		num_amount = scan.nextInt();
		System.out.println("--------------------");
		
		for(i = 0; i < num_amount; i++) {
			System.out.println((i+1) + "��° ���� �Է����ּ���. ");
			n = scan.nextInt();
			sum = sum + n;
			System.out.println("--------------------");
		}
		//��� ��, int�� ����ϰ� double�� �ٲ�� �Ҽ��� ���ϴ� �߸���.
		avg = (float)sum / i;
		
		System.out.printf("%d��° �������� ��: %d, ���: %.2f", i, sum, avg);
		/*
		System.out.println(i+"��° �������� �� : "+ sum);
		System.out.println(i+"��° �������� ��� : "+ avg);
		*/
		
		scan.close();
	}
}
