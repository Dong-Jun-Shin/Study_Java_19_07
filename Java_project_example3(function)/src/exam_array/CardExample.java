package exam_array;

/*
 * ī�带 �����ϰ� �����Ͽ� ȭ�鿡 ����ϴ� �ڵ带 �ۼ��غ���.
 * {"Clubs","Diamonds", "Hearts", "Spades"}��
 * {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"}��
 * ������ �ִ� ���ڿ� �迭�� �����ϰ� �� �������κ��� �����ϰ� �ϳ��� ī�带 �����ϴ� �ڵ带 �ۼ��϶�.
 * ���� ��� : Hearts�� Jack
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
		System.out.print(form[random_num] + "�� ");

		random_num = randomNum(num);
		System.out.println(num[random_num]);
	}
}
