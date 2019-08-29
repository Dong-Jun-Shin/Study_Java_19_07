package exam_flowchart;

import java.util.Scanner;

public class FlowchartPassExample {
	public static void main(String[] args) {
		/*
		 * //첫번째 방법 Scanner scan = new Scanner(System.in); int i; int lesson1; int
		 * lesson2;
		 * 
		 * String std_num1 = null, std_num2 = null, std_num3 = null; double avg = 0,
		 * avg1 = 0, avg2 = 0, avg3 = 0; String pass1 = null, pass2 = null, pass3 =
		 * null;
		 * 
		 * for (i = 0; i < 3; i++) { switch (i) { case 0:
		 * System.out.print("학번을 입력해주세요."); std_num1 = scan.next(); case 1:
		 * System.out.print("학번을 입력해주세요."); std_num2 = scan.next(); case 2:
		 * System.out.print("학번을 입력해주세요."); std_num3 = scan.next(); }
		 * System.out.print("과목1 입력해주세요."); lesson1 = scan.nextInt();
		 * System.out.print("과목2을 입력해주세요."); lesson2 = scan.nextInt();
		 * 
		 * avg = (double) (lesson1 + lesson2) / 2;
		 * 
		 * switch (i) { case 0: avg1 = avg; if ((lesson1 >= 40 || lesson1 >= 40) && avg1
		 * >= 60) { pass1 = "합격"; } else { pass1 = "불합격"; } case 1: avg2 = avg; if
		 * ((lesson1 >= 40 || lesson1 >= 40) && avg2 >= 60) { pass2 = "합격"; } else {
		 * pass2 = "불합격"; } case 2: avg3 = avg; if ((lesson1 >= 40 || lesson1 >= 40) &&
		 * avg3 >= 60) { pass3 = "합격"; } else { pass3 = "불합격"; } } }
		 * 
		 * System.out.println("----------------");
		 * System.out.println("학번        평균      합격여부");
		 * System.out.printf("%s %.2f   %s\n", std_num1, avg1, pass1);
		 * System.out.printf("%s %.2f   %s\n", std_num2, avg2, pass2);
		 * System.out.printf("%s %.2f   %s\n", std_num3, avg3, pass3);
		 * 
		 * scan.close();
		 */

		// 두번째 방법
		Scanner scan = new Scanner(System.in);

		int lesson1;
		int lesson2;

		String result = "";
		String std_num = null;
		String pass = null;
		double avg = 0;

		for (int i = 0; i < 3; i++) {
			System.out.print("학번을 입력해주세요.");
			std_num = scan.next();
			System.out.print("과목1 입력해주세요.");
			lesson1 = scan.nextInt();
			System.out.print("과목2을 입력해주세요.");
			lesson2 = scan.nextInt();

			avg = (double) (lesson1 + lesson2) / 2;
			if ((lesson1 >= 40 || lesson1 >= 40) && avg >= 60) {
				pass = "합격";
			} else {
				pass = "불합격";
			}

			// 결과를 문자열로 모두 저장하는 방법
			result += std_num + "\t" + avg + "\t" + pass + "\n";
		}

		System.out.println("---------------------");
		System.out.println("학번\t평균\t합격여부");
		System.out.printf("%s", result);

		scan.close();
	}
}
