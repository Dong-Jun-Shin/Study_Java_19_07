package exam_input;

import java.util.Scanner;

/*
 * 각자의 이름, 나이, 주소를 출력할 수 있록 작성해 주세요.
 * 
 * -------------출력문---------------
 * 홍길동님 안녕하세요! 50살이시네요.
 * 주소는 서울시 성동구 무학로 2길
 */
public class InputString {
	public static void main(String[] args) {
		String name, address;
		int age;

		Scanner scan = new Scanner(System.in);

		System.out.println("이름을 입력해주세요.");
		name = scan.next();

		System.out.println("나이를 입력해주세요.");
		age = scan.nextInt();
		
		//입력하면서 생긴 개행문자를 없애준다.
		scan.nextLine();
		
		System.out.println("주소를 입력해주세요.");
		address = scan.nextLine();
	
		System.out.println("-------------------------");
		System.out.println(name + "님 안녕하세요! " + age + "살이시네요.");
		System.out.println("주소는 " + address);
		
		scan.close();
	}
}