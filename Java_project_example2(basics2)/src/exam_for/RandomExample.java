package exam_for;

public class RandomExample {
	public static void main(String[] args) {
		int r_sum = 0;
		int random;

		for(int i=0; i<=10; i++) {
			for (int j = 0; j < 6; j++) {
				random = (int) (Math.random() * 100) + 1;
				System.out.printf("%4d", random);
				r_sum += random;
			}
			System.out.println();
		}
		System.out.println("난수의 합:" + r_sum);
	}
}
