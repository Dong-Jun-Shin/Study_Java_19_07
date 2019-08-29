package exam_if;

import java.util.Scanner;

/*
 * 사용자로 하여금 국어점수와 수학점수를 입력받아 평균을 구하고,
 * 평균이 60점 이상이면 "합격"을 출력하도록 프로그램을 작성해 주세요.
 */
public class IfElseExample {
	public static void main(String[] args) {
		int l_score, m_score, avg;
		boolean over = true;

		Scanner scan = new Scanner(System.in);

		while (over) {
			System.out.println("국어 점수를 입력해주세요.");
			l_score = scan.nextInt();

			System.out.println("수학 점수를 입력해주세요.");
			m_score = scan.nextInt();

			if (l_score <= 100 && l_score >= 0) {
				if (m_score <= 100 && m_score >= 0) {
					avg = (l_score + m_score) / 2;
					if (avg >= 60) {
						System.out.println("합격");
					} else {
						System.out.println("불합격");
					}
					break;
				}
			}
			System.out.println("입력 범위를 넘었습니다.");
			System.out.println("-------------------------------");
			System.out.println("점수는 0 ~ 100 사이로 입력해주세요.");
		}
		scan.close();
	}
}
