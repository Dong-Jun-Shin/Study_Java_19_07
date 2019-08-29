package exam_operation;

import java.util.Scanner;

/*
 * 달걀 456개를 12개씩 담을 수 있는 상자의 수를 삼항 연산자를 이용하여
 * 실행결과와 같이 출력하도록 프로그램을 작성하시오.
 * 
 * [실행결과]
 * 달걀 456개를 12개씩 담을 수 있는 상자의 수는 00개입니다.
 */
public class OperationExam1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("전체 계란 수를 입력해주세요. ^^");
		int egg = scan.nextInt();

		System.out.println("한 상자에 담을 계란 수를 입력해주세요. ^^");
		int eggDiv = scan.nextInt();

		int box;

		box = egg / eggDiv;

		// if문 대신 조건연산자를 이용
		box = (box % eggDiv == 0 || box % eggDiv == 1) ? (box) : (box + 1);

		System.out.println("달걀 " + egg + "개를 " + eggDiv + "개씩 담을 수 있는 상자의 수는 " + box + "개입니다.");
		scan.close();
	}
}