package exam_if;

import java.util.Scanner;

/*
 * ����ڷ� �Ͽ��� ���������� ���������� �Է¹޾� ����� ���ϰ�,
 * ����� 60�� �̻��̸� "�հ�"�� ����ϵ��� ���α׷��� �ۼ��� �ּ���.
 */
public class IfElseExample {
	public static void main(String[] args) {
		int l_score, m_score, avg;
		boolean over = true;

		Scanner scan = new Scanner(System.in);

		while (over) {
			System.out.println("���� ������ �Է����ּ���.");
			l_score = scan.nextInt();

			System.out.println("���� ������ �Է����ּ���.");
			m_score = scan.nextInt();

			if (l_score <= 100 && l_score >= 0) {
				if (m_score <= 100 && m_score >= 0) {
					avg = (l_score + m_score) / 2;
					if (avg >= 60) {
						System.out.println("�հ�");
					} else {
						System.out.println("���հ�");
					}
					break;
				}
			}
			System.out.println("�Է� ������ �Ѿ����ϴ�.");
			System.out.println("-------------------------------");
			System.out.println("������ 0 ~ 100 ���̷� �Է����ּ���.");
		}
		scan.close();
	}
}
