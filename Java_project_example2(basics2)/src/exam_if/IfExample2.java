package exam_if;

import java.util.Scanner;

public class IfExample2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		char hakjum;
		boolean over = true;
		
		System.out.println("������ �Է����ּ���.");
		
		while (over) {
			
			int jumsu = scan.nextInt();
			
			System.out.println();
			System.out.println("jumsu�� �ʱⰪ : " + jumsu);
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
				System.out.println("���� = " + jumsu + " ���� = " + hakjum);
				over = false;
			}else {
				System.out.println();
				System.out.println("-----------------------------");
				System.out.println("������ 0 ~ 100 ���̷� �Է����ּ���.");
			}
		}

		scan.close();
	}
}
