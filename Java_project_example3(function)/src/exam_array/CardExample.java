package exam_array;

/*
 * 카드를 랜덤하게 선택하여 화면에 출력하는 코드를 작성해보자.
 * {"Clubs","Diamonds", "Hearts", "Spades"}와
 * {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"}를
 * 가지고 있는 문자열 배열을 생성하고 위 내용으로부터 랜덤하게 하나의 카드를 선택하는 코드를 작성하라.
 * 실행 결과 : Hearts의 Jack
 */
public class CardExample {
	public static int randomNum(String[] array) {
		int random_num;
		random_num = (int) (Math.random() * array.length);
		if (random_num == 5 || random_num == 6) {
			random_num = 11;
		}

		return random_num;
	}

	public static void main(String[] args) {
		String[] form = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] num = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		int random_num;
		random_num = randomNum(form); 
		System.out.print(form[random_num] + "의 ");

		random_num = randomNum(num);
		System.out.println(num[random_num]);
	}
}
