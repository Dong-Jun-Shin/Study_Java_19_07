package exam_api_string.exam02_method;

public class StringMethodExample {
	public static void main(String[] args) {
		String subject = "   자바 프로그래밍";

		//인덱스 위치의 값을 반환
		char ch = subject.charAt(0);
		System.out.println(ch);

		//시작인덱스 반환
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);

		//매개변수의 값으로 시작하는지, 띄어쓰기라도 있으면 false
		boolean b = subject.startsWith("자바");
		System.out.println(b);

		//매개변수의 값으로 끝이 나는지, 띄어쓰기라도 있으면 false
		b = subject.endsWith("프로그래밍");
		System.out.println(b);

		//해당 문자가 없으면 -1을 반환한다. 문자가 있으면 해당 인덱스를 반환
		if (subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}

		System.out.println();

		//문자열 길이 반환
		String birth = "730624";
		int length = birth.length();
		System.out.println("문자열의 길이 수:" + length);

		//문자열을 '1번째 인덱스'부터 '2번째 인덱스'까지 가져오기
		String ssn = "660606 - 1234561 ";
		String firstNum = ssn.substring(0, 6);
		System.out.println("substring(0,6): " + firstNum);

		//'1번째 인덱스'부터 문자열을 전부 가져온다.
		String secondNum = ssn.substring(7);
		System.out.println("substring(7): " + secondNum);
	}
}
