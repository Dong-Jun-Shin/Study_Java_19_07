package exam_lab;

import java.util.Scanner;

public class PrintPage1_2 {
	public static void main(String[] args) {
		int m_score, f_score, r_score, c_score;
		double avg, report, check, grade;
		char eng_grade;
		String eval = "";

		//�Է�
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�߰���� ������ �Է����ּ���.");
		m_score = scan.nextInt();

		System.out.println("�⸻��� ������ �Է����ּ���.");
		f_score = scan.nextInt();

		System.out.println("����Ʈ ������ �Է����ּ���.");
		r_score = scan.nextInt();

		System.out.println("�⼮ ������ �Է����ּ���.");
		c_score = scan.nextInt();

		//ó��
		avg = ((m_score + f_score) / 2) * 0.6;
		report = r_score * 0.2;
		check = c_score * 0.2;

		//����
		grade = avg + report + check;

		//����
		if (grade >= 90) {
			eng_grade = 'A';
		} else if (grade >= 80) {
			eng_grade = 'B';
		} else if (grade >= 70) {
			eng_grade = 'C';
		} else if (grade >= 60) {
			eng_grade = 'D';
		} else {
			eng_grade = 'F';
		}

		//��
		switch (eng_grade) {
		case 'A':
		case 'B':
			eval = "excellent";
			break;
		case 'C':
		case 'D':
			eval = "good";
			break;
		case 'F':
			eval = "poor";
			break;
		}

		//���
		System.out.println("------ ����Դϴ� ------");
		System.out.println("�߰���� : " + m_score);
		System.out.println("�⸻��� : " + f_score);
		System.out.println("����Ʈ : " + r_score);
		System.out.println("�⼮���� : " + c_score);
		System.out.printf("���� : %.2f\n", grade);
		System.out.println("���� : " + eng_grade);
		System.out.println("�� : " + eval);
		
		scan.close();
	}
}
