package exam_operation;

import java.util.Scanner;

/*
 * 경비 45763원을 변수에 대입한 다음 산술 연산자를 이용하여 실행 결과와 같이 출력하도록 코드를 작성하시오.
 * 실행결과
 * 		45763원은
 * 			500원 : 00개
 * 			100원 : 0개
 * 			 50원 : 0게
 * 			 10원 : 0개
 * 			  1원 : 0개입니다.
 */
public class OperationExam2 {
	public static void main(String[] args) {
		int c50000, c10000, c5000, c1000,c500, c100, c50, c10, c1;
		int money;

		System.out.println("금액을 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		money = scan.nextInt();
		
		c50000 = money / 50000;
		c10000 = money % 50000 / 10000;
		c5000 = money % 10000 / 5000;
		c1000 = money % 5000 / 1000;
		c500 = money % 1000 / 500;
		c100 = money % 500 / 100;
		c50 = money % 100 / 50;
		c10 = money % 50 / 10;
		c1 = money % 10;

		System.out.println("50000원 : " + c50000);
		System.out.println("10000원 : " + c10000);
		System.out.println("5000원 : " + c5000);
		System.out.println("1000원 : " + c1000);
		System.out.println("500원 : " + c500);
		System.out.println("100원 : " + c100);
		System.out.println("50원 : " + c50);
		System.out.println("10원 : " + c10);
		System.out.println("1원 : " + c1);
		
		scan.close();
	}
}
