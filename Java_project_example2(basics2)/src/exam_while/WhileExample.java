package exam_while;

public class WhileExample {
	public static void main(String[] args) {

		// while���� �̿��� 5�� ��°� ������ �ݺ��ϱ�
		// 1��° ��� (�Ŀ��� ������ Ʋ�� ��, ���߱�)
		int i = 1;
		System.out.println("����");
		while (i <= 5) {
			System.out.println(i + " ");
			i++;
		}
		System.out.println();

		// 2��° ��� (�Ŀ� true�� �ְ�, break�� ���߱�)
		i = 1;
		System.out.println("����: ");
		while (true) {
			System.out.println(i + " ");
			i++;
			if (i > 5)
				break;
		}
		System.out.println();

		// 1���� 100������ ��
		int num = 1, sum = 0;
		while (num <= 100) {
			sum += num;
			num++;
		}
		System.out.println("1���� 100������ �� = " + sum + "�Դϴ�.");
		System.out.println();

		// 10���� 1������ ���
		num = 10;
		sum = 0;

		System.out.println("10���� 1������ ���");
		while (num > 0) {
			System.out.println(num);
			num--;
		}
		System.out.println();

		// 1���� 100���� �� �߿��� ¦���� �հ� Ȧ���� ���� ����ϱ�
		num = 1;
		int even = 0, odd = 0;

		while (num < 101) {
			if (num % 2 == 0) {
				even += num;
				num++;
			} else {
				odd += num;
				num++;
			}

		}
		System.out.println("1���� 100������ Ȧ���� = " + odd + "�Դϴ�.");
		System.out.println("1���� 100������ ¦���� = " + even + "�Դϴ�.");
		System.out.println();

		
		// 1���� 30������ 7�� ����� ���, 7�� ����� ��, 7�� ����� ������ ����ϱ�
		int print = 1, cnt = 0;
		sum = 0;

		while (print < 31) {
			if (print % 7 == 0) {
				System.out.println("7�� " + (cnt+1) + "��° �� : " + print);
				sum += print;
				cnt++;
			}
			print++;
		}
		System.out.println("-------------------");
		System.out.println("7�� ����� �� : " + sum);
		System.out.println("7�� ����� ���� : " + cnt);
	}
}
