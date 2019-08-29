package exam_for;

/*
 * 1+3+5+7+...+X에서 합이 최초로 500을 넘은 떄의 X값과 X가 몇 번째 수인가를 출력하는 프로그램을 작성
 */
public class ForExample2 {
	public static void main(String[] args) {
		int i, sum, cnt;
		sum = 0;
		cnt = 0;

		for (i = 1; i <= 500; i = i + 2) {
			sum = sum + i;
			cnt++;
		}

		System.out.println("500을 넘을 때까지의 합: " + sum);
		System.out.println("500을 넘을 때의 X값 : " + i);
		System.out.println("X는 " + cnt + "번째");
	}
}
