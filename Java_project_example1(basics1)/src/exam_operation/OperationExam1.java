package exam_operation;

import java.util.Scanner;

/*
 * �ް� 456���� 12���� ���� �� �ִ� ������ ���� ���� �����ڸ� �̿��Ͽ�
 * �������� ���� ����ϵ��� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * [������]
 * �ް� 456���� 12���� ���� �� �ִ� ������ ���� 00���Դϴ�.
 */
public class OperationExam1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("��ü ��� ���� �Է����ּ���. ^^");
		int egg = scan.nextInt();

		System.out.println("�� ���ڿ� ���� ��� ���� �Է����ּ���. ^^");
		int eggDiv = scan.nextInt();

		int box;

		box = egg / eggDiv;

		// if�� ��� ���ǿ����ڸ� �̿�
		box = (box % eggDiv == 0 || box % eggDiv == 1) ? (box) : (box + 1);

		System.out.println("�ް� " + egg + "���� " + eggDiv + "���� ���� �� �ִ� ������ ���� " + box + "���Դϴ�.");
		scan.close();
	}
}