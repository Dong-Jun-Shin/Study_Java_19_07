package exam_user_define_exception;

import java.util.Scanner;

@SuppressWarnings("serial")
class NegativeNumberException1 extends Exception {
	public NegativeNumberException1() {
	}

	public NegativeNumberException1(String msg) {
		super(msg);
	}

}

public class AvgProgramming2 {
	public static Scanner scan = new Scanner(System.in);

	public static int sum() throws NegativeNumberException1{
		String[] msg = {"국어", "영어", "수학"};
		int[] score = new int[3];
		int total = 0;

		for (int i = 0; i < score.length; i++) {
			System.out.println(msg[i] + " 점수를 입력해주세요.");
			score[i] = scan.nextInt();
			if (score[i] < 0) {
				throw new NegativeNumberException1("음수는 입력할 수 없습니다.");
			}

			if (score[i] > 100) {
				throw new NegativeNumberException1("100점을 넘기셨습니다.");
			}
		}
		
		for (int i = 0; i < score.length; i++) {
			total += score[i];			
		}
		
		return total;
	}

	public static void main(String[] args) {
		double avg = 0;

		try {
			avg = sum();
			avg = avg / 3;
		} catch (NegativeNumberException1 e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		System.out.println("\n" + avg);
	}
}
