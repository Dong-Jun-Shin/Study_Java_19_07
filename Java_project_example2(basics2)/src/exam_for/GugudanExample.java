package exam_for;

import java.util.Scanner;

/* ����ڷκ��� ���� �Է¹޾�
 * while���� �̿��� ������ ��� ���α׷�
 */
public class GugudanExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num, i = 1;

		System.out.print("������ �߿��� ����ϰ� ���� ���� �Է��Ͻÿ�: ");
		num = scan.nextInt();
		if (num > 0 && num < 10) {
			for (i = 1; i < 10; i++) {
				System.out.println(num + "*" + i + " = " + (num * i));
			}
		} else {
			System.out.println("�������� 1 ~ 9�����Դϴ�. �ٽ� �Է����ּ���.");
			System.out.println("--------------------------------");
		}
		scan.close();
	}
}