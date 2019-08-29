package exam_for;

/*
 * 2개의 주사위를 던지는 게임이 있다고 가정하자.
 * 2개 주사위의 합이 6이 되는 경우는 몇가지나 있을까?
 * 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성해보자.
 * (1,5)
 * ...
 */
public class DiceExample2 {
	public static void main(String[] args) {
		int n1, n2;
		n1 = (int) ((Math.random() * 6) + 1);
		n2 = (int) ((Math.random() * 6) + 1);

		while (true) {
			if (n1 + n2 == 6) {
				System.out.println(n1 + ", " + n2);
			}
		}
	}
}
