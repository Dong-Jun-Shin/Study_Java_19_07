package exam_dowhile;

import java.util.Scanner;

public class DoWhileExample {
	public static void main(String[] args) {

		// 조건 불충분이더라도 한번은 실행
		int num = 0;
		do {
			System.out.println("num의 값: " + num);
			num++;
		} while (num < 0);

		System.out.println();

		// 1에서부터 10까지 출력
		int i = 1;
		do {
			System.out.println(i + " ");
			i++;
		} while (i <= 10);
		System.out.println();

		// 10에서부터 1까지 출력
		i = 10;
		do {
			System.out.println(i + " ");
			i--;
		} while (i >= 1);
		System.out.println();

		// 1에서 100까지의 합을 출력해주세요.(do ~ while문을 이용하여)
		int sum = 0;
		i = 1;

		do {
			sum += i;
			i++;
		} while (i <= 100);
		System.out.println(sum);
		System.out.println();

		// 사용자에게 문자 및 숫자를 입력받아서 출력하고자 한다. 이때 종료는 q를 입력하면 된다.
		System.out.println("\n메시지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		String input_string;
		
		do {
			System.out.print(">");
			input_string = scan.nextLine();
			System.out.println(input_string);
		} while (!input_string.equals("q")); 
	      //String은 클래스라서 비교시 '=='을 사용할 수 없다.
		  //그래서 String은 비교시 .equals("비교할 문자")로 써준다.
		scan.close();
		
		System.out.println("종료되었습니다.");
		System.out.println();
		
		
	    //.equals()와 .contentEquals()의 차이--------------------------	
		//  equals는 (내용이 같은지 여부 && String인지 아닌지)를 판단해서 만족시 true.
		//  contentEquals는 (내용이 같은지 여부)를 판단해서 만족시 true.
		//	  -애초에 String 이외의 타입을 넣을 수 없다.
		String compare = "q";
		char compare_c = 'q';
		System.out.println(input_string.equals(compare_c));
		System.out.println(input_string.contentEquals(compare));
		}
}
