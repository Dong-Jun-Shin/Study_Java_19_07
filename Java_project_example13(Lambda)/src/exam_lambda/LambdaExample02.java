package exam_lambda;

interface Verify {
	boolean check(int n);
}

public class LambdaExample02 {
	public static void main(String[] args) {
		//무명 클래스 구현
		Verify isEven = new Verify() {

			@Override
			public boolean check(int n) {
				return (n % 2) == 0;
			}

		};
		System.out.println("결과값: " + isEven.check(3));

		//람다식으로 구현 (매개변수 사용, 리턴생략)
		isEven = (n) -> (n % 2) == 0;
		System.out.println("결과값: " + isEven.check(10));

		//변수 선언과 람다식을 동시에 작성
		Verify isOdd = (n) -> (n % 2) == 1;
		System.out.println("결과값: " + isOdd.check(9));
	}
}
