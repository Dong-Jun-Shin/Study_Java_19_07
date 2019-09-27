package exam_collection_set;

import java.util.Set;
import java.util.HashSet;

class Lotto {
	Set<Integer> set = new HashSet<Integer>();

	public Lotto() {
		int d;
		for (int i = 0; i < 6; i++) {
			do {
				d = (int) ((Math.random() * 45) + 1);
			} while (set.contains(d));
			set.add(d);
		}
	}

	@Override
	public String toString() {
		return "Lotto 번호 " + set;
	}

}

public class LottoExample2 {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		System.out.println(lotto.toString());
	}
}
