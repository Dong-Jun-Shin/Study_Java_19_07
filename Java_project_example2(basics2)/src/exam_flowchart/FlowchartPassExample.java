package exam_flowchart;

import java.util.Scanner;

public class FlowchartPassExample {
	public static void main(String[] args) {
		/*
		 * //ù��° ��� Scanner scan = new Scanner(System.in); int i; int lesson1; int
		 * lesson2;
		 * 
		 * String std_num1 = null, std_num2 = null, std_num3 = null; double avg = 0,
		 * avg1 = 0, avg2 = 0, avg3 = 0; String pass1 = null, pass2 = null, pass3 =
		 * null;
		 * 
		 * for (i = 0; i < 3; i++) { switch (i) { case 0:
		 * System.out.print("�й��� �Է����ּ���."); std_num1 = scan.next(); case 1:
		 * System.out.print("�й��� �Է����ּ���."); std_num2 = scan.next(); case 2:
		 * System.out.print("�й��� �Է����ּ���."); std_num3 = scan.next(); }
		 * System.out.print("����1 �Է����ּ���."); lesson1 = scan.nextInt();
		 * System.out.print("����2�� �Է����ּ���."); lesson2 = scan.nextInt();
		 * 
		 * avg = (double) (lesson1 + lesson2) / 2;
		 * 
		 * switch (i) { case 0: avg1 = avg; if ((lesson1 >= 40 || lesson1 >= 40) && avg1
		 * >= 60) { pass1 = "�հ�"; } else { pass1 = "���հ�"; } case 1: avg2 = avg; if
		 * ((lesson1 >= 40 || lesson1 >= 40) && avg2 >= 60) { pass2 = "�հ�"; } else {
		 * pass2 = "���հ�"; } case 2: avg3 = avg; if ((lesson1 >= 40 || lesson1 >= 40) &&
		 * avg3 >= 60) { pass3 = "�հ�"; } else { pass3 = "���հ�"; } } }
		 * 
		 * System.out.println("----------------");
		 * System.out.println("�й�        ���      �հݿ���");
		 * System.out.printf("%s %.2f   %s\n", std_num1, avg1, pass1);
		 * System.out.printf("%s %.2f   %s\n", std_num2, avg2, pass2);
		 * System.out.printf("%s %.2f   %s\n", std_num3, avg3, pass3);
		 * 
		 * scan.close();
		 */

		// �ι�° ���
		Scanner scan = new Scanner(System.in);

		int lesson1;
		int lesson2;

		String result = "";
		String std_num = null;
		String pass = null;
		double avg = 0;

		for (int i = 0; i < 3; i++) {
			System.out.print("�й��� �Է����ּ���.");
			std_num = scan.next();
			System.out.print("����1 �Է����ּ���.");
			lesson1 = scan.nextInt();
			System.out.print("����2�� �Է����ּ���.");
			lesson2 = scan.nextInt();

			avg = (double) (lesson1 + lesson2) / 2;
			if ((lesson1 >= 40 || lesson1 >= 40) && avg >= 60) {
				pass = "�հ�";
			} else {
				pass = "���հ�";
			}

			// ����� ���ڿ��� ��� �����ϴ� ���
			result += std_num + "\t" + avg + "\t" + pass + "\n";
		}

		System.out.println("---------------------");
		System.out.println("�й�\t���\t�հݿ���");
		System.out.printf("%s", result);

		scan.close();
	}
}
