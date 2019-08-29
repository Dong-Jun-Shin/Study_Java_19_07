package exam_for;

import java.util.Scanner;

/*
 * 이 예제는 숫자 알아맞히기 게임이다.
 * 프로그램은 1부터 10사이의 정수를 저장하고 있고 사용자는 질문을 통하여 그 정수를 알아맞히려고 노력한다.
 * 사용자가 답을 제시하면 프로그램은 자신이 저장한 정수와 비교하여 제시된 정수가 
 * 더 높은지 낮은지 만을 알려준다.
 * 프로그램은 do ~ while 루프를 사용하여 사용자가 정확하게 정수를 알아맞힐 때까지 반복한다.
 * 사용자가 정답을 알아맞히면 몇 변 만에 알아맞혔는지를 화면에 출력한다. 
 */
public class NumberGame {
	public static void main(String[] args) {
		System.out.println("---------------------");
		System.out.println("	정수 알아맞히기 게임	 ");
		System.out.println("(끝내려면 \"q\"를 입력해주세요.)");
		System.out.println("---------------------");
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			int ran = (int) ((Math.random() * 10) + 1);
			System.out.println("         수가 정해졌습니다.");
			System.out.println("---------------------");
			System.out.println("(힌트는 '정답  * x * 7' 의 결과입니다.)");
			System.out.println("hint 1: "+ (ran*(int) ((Math.random() * 10) + 1)*7));
			System.out.println("hint 2: "+ (ran*(int) ((Math.random() * 10) + 1)*7));
			System.out.println("hint 3: "+ (ran*(int) ((Math.random() * 10) + 1)*7));
			
			while (true) {
				System.out.println("정답일거 같은 수를 입력해주세요.");
				int num = scan.nextInt();

				if (ran == num) {
					System.out.println("맞췄습니다.!");
					break;
				} else {
					System.out.println("틀렸습니다. 다시 입력해주세요.");
					System.out.println("---------------------");
				}
			}
			break;
		}

		scan.close();
	}
}
