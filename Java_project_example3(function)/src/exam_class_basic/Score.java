package exam_class_basic;

import java.util.Scanner;

/*
 * �̸�/����/����/����/������ �����ϰ��� �Ѵ�.
 * �ʵ忡 ���� ������ �� �ִ� ���, ���������� ���� ���ϴ� ���, ��� �ʵ带 ����� ��
 * �ִ� ����� �����ϵ��� �Ѵ�.
 * 
 * [��°��]
 * ==========================
 * �̸� ���� ���� ���� ����
 * ==========================
 * ȫ�浿 90 100 95 285
 * ��ö�� 90 80 100 270
 */
public class Score {
	public String name;
	public int score1;
	public int score2;
	public int score3;

	public void getData(Scanner scan) {
		System.out.println("�̸��� ����,����,������ ������ �Է����ּ���>>");
		System.out.print("�̸� : ");
		name = scan.nextLine();

		System.out.print("���� : ");
		score1 = scan.nextInt();

		System.out.print("���� : ");
		score2 = scan.nextInt();

		System.out.print("���� : ");
		score3 = scan.nextInt();
		scan.nextLine(); //���� �Է��� ���� ��, �����ִ� �ٹٲ����� ������ �ϴ� �Է��̸�
						 //nextLine()������ �߰��ؼ� �����ִ� �ٹٲ��� �����ش�.

		System.out.println();
	}

	public int sum() {
		int total;
		total = score1 + score2 + score3;
		return total;
	}

	public static void printSet() {
		System.out.println("====================================");
		System.out.println(" �̸�\t����\t����\t����\t����");
		System.out.println("====================================");
	}

	public String toString() {
		return String.format("%s\t%3d\t%3d\t%3d\t%d", name, score1, score2, score3, sum());

	}
}
