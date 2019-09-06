package exam_lab;

import java.util.Scanner;

/*컴퓨터와 하는 가위바위보 만들기
 * 승부 판별, 게임은 반복(4 입력시 종료)
 */
public class RockScissorsPaper {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] list = { "가위", "바위", "보" };
		int user = 0;
	

		outer: while (true) {
			System.out.print("가위(1), 바위(2), 보(3), 끝내기(4) 중 하나를 선택하세요>>");
			user = scan.nextInt();

			int com = (int) ((Math.random() * 3) + 1);
			
			//첫번째. Switch로 경우의 수로 구분한 경우
			//RockScissors.competeSwitch(list, user, com);
			
			//두번째. If로 값에 따라 판별
			switch (user) {
			case 1:
				RockScissors.competeIf(list, user, com);
				break;
			case 2:
				RockScissors.competeIf(list, user, com);
				break;
			case 3:
				RockScissors.competeIf(list, user, com);
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break outer;
			default:
				System.out.println("숫자를 제대로 입력해주세요.");
			}
		}
		scan.close();
	}
}