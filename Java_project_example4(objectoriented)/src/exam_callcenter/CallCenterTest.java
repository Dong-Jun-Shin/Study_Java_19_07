package exam_callcenter;

import java.util.Scanner;

public class CallCenterTest {
	private static void showMenu() {
		System.out.println("전화 상담 할당 방식을 선택 하세요. (다른 문자 입력시, 종료)");
		System.out.println("R : 한명씩 차례로 할당");
		System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당");
		System.out.println("P : 우선순위가 높은 고객 먼저 할당");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scheduler callMethod = null; //인터페이스 다형성
		
		while(true) {
			showMenu();
			
			//String으로 받기
			String selStr = scan.nextLine();
			if (selStr.equals("R") || selStr.equals("r")) {
				callMethod = new RoundRobin();
			} else if (selStr.equals("L") || selStr.equals("l")) {
				callMethod = new LeastJob();
			} else if (selStr.equals("P") || selStr.equals("p")) {
				callMethod = new PriorityAllocation();
			} else {
				System.out.println("지원되지 않는 기능입니다.");
				break;
			}
			
			/*
			//Char로 받기
			char ch = scan.nextLine().charAt(0);
			if (ch == 'R' || ch == 'r') {
			} else if (ch == 'L' || ch == 'l') {
				callMethod = new LeastJob();
			} else if (ch == 'P' || ch == 'p') {
				callMethod = new PriorityAllocation();
			} else {
				break;
			}
			*/
			
			callMethod.getNextCall();
			callMethod.sendCallToAgent();
			
			System.out.println();
		}
		
		scan.close();
	}
}
