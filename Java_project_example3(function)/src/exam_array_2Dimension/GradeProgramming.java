package exam_array_2Dimension;


/*
 * 성적 프로그램 만들기
 * - 학생명 : name / 점수 : score / 평균 : avg /
 * 	 학점: grade	/ 재수강 : pass / 순위 : rank
 * - 수식은 다음과 같다
 * 총점 = 국어 + 영어 + 수학;
 * 평균 = 총점 / 3;
 * 학점 = 평균 90이상 'A' / 80이상 'B' / 70이상 'C' / 
 * 			60이상 'D' / 나머지는 'F'
 * 재수강 = 평균 60이상이면 'pass' / 60미만이면 'nopass' 
 */
public class GradeProgramming {
	public static void main(String[] args) {
		String[] name = {"홍길동", "김철수", "이수진"};
		String[] pass = new String[3];
		int[][] score = { { 90, 75, 61 }, { 55, 56, 46 }, { 90, 90, 90 } };
		int[] total = new int[3];
		double[] avg = new double[3];
		char[] grade = new char[3];
		int[] rank = new int[3];

		// 총점
		GradeProgram.sum(score, total);

		// 평균
		GradeProgram.average(avg, score, total);

		// 학점
		GradeProgram.gradeProcess(avg, grade);

		// 재수강
		GradeProgram.passProcess(avg, pass);
		
		// 모두 비교해서 큰 개수만큼 rank의 자리를 밀기.
		GradeProgram.rankProcess(avg, rank);

		System.out.println("================================================================================");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점\t재수강\t순위");
		System.out.println("================================================================================");
		for (int i = 0; i < name.length; i++) {
			System.out.printf("%d\t%s\t ", i + 1, name[i]);
			for (int j = 0; j < score[i].length; j++) {
				System.out.printf("%d\t", score[i][j]);
			}
			System.out.printf("%d\t%.2f\t%s\t%s\t%d\t\n", total[i], avg[i], grade[i], pass[i], rank[i]);
		}
	}
}
