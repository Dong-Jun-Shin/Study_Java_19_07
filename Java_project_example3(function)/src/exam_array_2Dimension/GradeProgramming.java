package exam_array_2Dimension;
import tool.GradeProgram;
/*
 * ���� ���α׷� �����
 * - �л��� : name / ���� : score / ��� : avg /
 * 	 ����: grade	/ ����� : pass / ���� : rank
 * - ������ ������ ����
 * ���� = ���� + ���� + ����;
 * ��� = ���� / 3;
 * ���� = ��� 90�̻� 'A' / 80�̻� 'B' / 70�̻� 'C' / 
 * 			60�̻� 'D' / �������� 'F'
 * ����� = ��� 60�̻��̸� 'pass' / 60�̸��̸� 'nopass' 
 */
public class GradeProgramming {
	public static void main(String[] args) {
		String[] name = {"ȫ�浿", "��ö��", "�̼���"};
		String[] pass = new String[3];
		int[][] score = { { 90, 75, 61 }, { 55, 56, 46 }, { 90, 90, 90 } };
		int[] total = new int[3];
		double[] avg = new double[3];
		char[] grade = new char[3];
		int[] rank = new int[3];

		// ����
		GradeProgram.sum(score, total);

		// ���
		GradeProgram.average(avg, score, total);

		// ����
		GradeProgram.gradeProcess(avg, grade);

		// �����
		GradeProgram.passProcess(avg, pass);
		
		// ��� ���ؼ� ū ������ŭ rank�� �ڸ��� �б�.
		GradeProgram.rankProcess(avg, rank);

		System.out.println("================================================================================");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����\t�����\t����");
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
