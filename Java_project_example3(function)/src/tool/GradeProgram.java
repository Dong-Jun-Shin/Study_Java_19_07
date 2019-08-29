package tool;

public class GradeProgram {
	public static void sum(int[][] score, int[] total){
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				total[i] += score[i][j];
			}
		}
	}
	
	public static void average(double[] avg, int[][] score, int[] total){
		for (int i = 0; i < avg.length; i++) {
			avg[i] = (double) total[i] / score[i].length;
		}
	}
	
	public static void gradeProcess(double[] avg, char[] grade){
		for (int i = 0; i < avg.length; i++) {
			if (avg[i] >= 90) {
				grade[i] = 'A';
			} else if (avg[i] >= 80) {
				grade[i] = 'B';
			} else if (avg[i] >= 70) {
				grade[i] = 'C';
			} else if (avg[i] >= 60) {
				grade[i] = 'D';
			} else {
				grade[i] = 'F';
			}
		}
	}
	
	public static void passProcess(double[] avg, String[] pass) {
		for (int i = 0; i < avg.length; i++) {
			if (avg[i] >= 60) {
				pass[i] = "pass";
			} else {
				pass[i] = "nopass";
			}
		}
	}
	
	public static void rankProcess(double[] avg, int[] rank) {
		for(int i = 0; i < avg.length; i++) {
			rank[i] +=1;
			for(int j = 0 ; j < avg.length; j++) {
				if(avg[i] < avg[j]) {
					++rank[i];
				}
			}
		}
	}
	
	public static void rankSort(double[] avg, int[] rank) {
		double[] rankProcess = new double[avg.length];
		double temp;
		System.arraycopy(avg, 0, rankProcess, 0, avg.length);

		for (int a = 0; a < avg.length - 1; a++) {
			for (int i = 0; i < avg.length - 1; i++) {
				if (rankProcess[i] < rankProcess[i + 1]) {
					temp = rankProcess[i];
					rankProcess[i] = rankProcess[i + 1];
					rankProcess[i + 1] = temp;
				}
			}
		}

		for (int i = 0; i < avg.length; i++) {
			for (int j = 0; j < avg.length; j++) {
				if (rankProcess[i] == avg[j]) {
					rank[j] = i + 1;
				}
			}
		}
	}
}
