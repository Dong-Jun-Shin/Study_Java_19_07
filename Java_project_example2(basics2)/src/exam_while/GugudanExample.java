package exam_while;

import java.util.Scanner;

/* ����ڷκ��� ���� �Է¹޾�
 * while���� �̿��� ������ ��� ���α׷�
 */
public class GugudanExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num, i=1;
		
		while (true) {
			System.out.print("������ �߿��� ����ϰ� ���� ���� �Է��Ͻÿ�: ");
			num = scan.nextInt();

			if (num > 0 && num < 10) {
				while (i < 10) {
					System.out.println(num + "*" + i + " = " + num * i);
					i++;
				}
				break;
			} else {
				System.out.println("�������� 1 ~ 9�����Դϴ�. �ٽ� �Է����ּ���.");
				System.out.println("--------------------------------");
			}
		}
		scan.close();
	}
}