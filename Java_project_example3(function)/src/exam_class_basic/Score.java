package exam_class_basic;

import java.util.Scanner;

/*
 * 이름/국어/영어/수학/총점을 저장하고자 한다.
 * 필드에 값을 설정할 수 있는 기능, 국어영어수학의 합을 구하는 기능, 모든 필드를 출력할 수
 * 있는 기능을 포함하도록 한다.
 * 
 * [출력결과]
 * ==========================
 * 이름 국어 영어 수학 총점
 * ==========================
 * 홍길동 90 100 95 285
 * 김철수 90 80 100 270
 */
public class Score {
	public String name;
	public int score1;
	public int score2;
	public int score3;

	public void getData(Scanner scan) {
		System.out.println("이름과 국어,영어,수학의 점수를 입력해주세요>>");
		System.out.print("이름 : ");
		name = scan.nextLine();

		System.out.print("국어 : ");
		score1 = scan.nextInt();

		System.out.print("영어 : ");
		score2 = scan.nextInt();

		System.out.print("수학 : ");
		score3 = scan.nextInt();
		scan.nextLine(); //다음 입력을 받을 때, 남아있는 줄바꿈으로 구분을 하는 입력이면
						 //nextLine()구문을 추가해서 남아있는 줄바꿈을 없애준다.

		System.out.println();
	}

	public int sum() {
		int total;
		total = score1 + score2 + score3;
		return total;
	}

	public static void printSet() {
		System.out.println("====================================");
		System.out.println(" 이름\t국어\t영어\t수학\t총점");
		System.out.println("====================================");
	}

	public String toString() {
		return String.format("%s\t%3d\t%3d\t%3d\t%d", name, score1, score2, score3, sum());

	}
}
