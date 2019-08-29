package exam_main_argument;

/*
 * 실행방법
 * Run > Run Configurations에서 두번째 탭(Arguments)을 선택하여
 * Program arguments에 값을 입력하고 Run 버튼을 클릭하면 된다.
 */
public class Greeting {
	public static void main(String[] args) {
		System.out.print("안녕하세요. ");
		System.out.print("자바 수업 시간에 ");
		System.out.println("예제 파일입니다.");

		if (args.length == 0) {
			System.out.println("아무것도 입력하지 않았습니다.");
		}
		for (int i = 0; i < args.length; i++) {
			System.out.println("나의 이름은 " + args[i] + "입니다.");
		}
	}
}
