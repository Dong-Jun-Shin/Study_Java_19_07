package exam_lab;

public class RockScissors {
	public static void competeIf(String[] list, int user, int com) {
		System.out.println("컴퓨터는 " + list[com - 1] + "를 냈습니다.");
		if (user == 3){
			if (com == user) {
				System.out.println("비겼습니다.");
			} else if (com == 1) {
				System.out.println("졌습니다.");
			} else {
				System.out.println("이겼습니다.");
			}
		} else {
			if (com == user) {
				System.out.println("비겼습니다.");
			} else if (com == user+1) {
				System.out.println("졌습니다.");
			} else {
				System.out.println("이겼습니다.");
			}
		}	
	}
	
	public static void competeSwitch(String[] list, int user, int com){
		int diff = 0;
		
		System.out.println("컴퓨터는 " + list[com - 1] + "를 냈습니다.");
		diff = user - com;
		
		switch(diff) {
		case 0:
			System.out.println("비겼습니다.");
			break;
		case -1:	//사용자 가위, 컴퓨터 바위 or 사용자 바위, 컴퓨터 가위
		case 2:		//사용자 보, 컴퓨터 가위
			System.out.println("졌습니다.");
			break;
		case 1:
		case -2: 
			System.out.println("이겼습니다.");
			break;
		default:
			System.out.println("숫자를 다시 입력해주세요.");
		}
	}
}
