package exam_lab;

import java.util.Scanner;

public class Page109 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		char hakjum;
		boolean over = true;
		
		System.out.println("학점을 입력해주세요.");
		
		while (over) {
			
			int jumsu = scan.nextInt();
			
			System.out.println();
			System.out.println("jumsu의 초기값 : " + jumsu);
			if (jumsu < 100 && jumsu > 0) {
				if (jumsu >= 90) {
					hakjum = 'A';
				} else if (jumsu >= 80) {
					hakjum = 'B';
				} else if (jumsu >= 70) {
					hakjum = 'C';
				} else if (jumsu >= 60) {
					hakjum = 'D';
				} else {
					hakjum = 'F';
				}
				System.out.println("점수 = " + jumsu + " 학점 = " + hakjum);
				over = false;
			}else {
				System.out.println();
				System.out.println("-----------------------------");
				System.out.println("점수는 0 ~ 100 사이로 입력해주세요.");
			}
		}

		scan.close();
	}
}

