package exam_lab;

import java.util.Scanner;

public class PrintPage1_2 {
	public static void main(String[] args) {
		int m_score, f_score, r_score, c_score;
		double avg, report, check, grade;
		char eng_grade;
		String eval = "";

		//입력
		Scanner scan = new Scanner(System.in);
		
		System.out.println("중간고사 점수를 입력해주세요.");
		m_score = scan.nextInt();

		System.out.println("기말고사 점수를 입력해주세요.");
		f_score = scan.nextInt();

		System.out.println("레포트 점수를 입력해주세요.");
		r_score = scan.nextInt();

		System.out.println("출석 점수를 입력해주세요.");
		c_score = scan.nextInt();

		//처리
		avg = ((m_score + f_score) / 2) * 0.6;
		report = r_score * 0.2;
		check = c_score * 0.2;

		//성적
		grade = avg + report + check;

		//학점
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

		//평가
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

		//출력
		System.out.println("------ 결과입니다 ------");
		System.out.println("중간고사 : " + m_score);
		System.out.println("기말고사 : " + f_score);
		System.out.println("레포트 : " + r_score);
		System.out.println("출석점수 : " + c_score);
		System.out.printf("성적 : %.2f\n", grade);
		System.out.println("학점 : " + eng_grade);
		System.out.println("평가 : " + eval);
		
		scan.close();
	}
}
