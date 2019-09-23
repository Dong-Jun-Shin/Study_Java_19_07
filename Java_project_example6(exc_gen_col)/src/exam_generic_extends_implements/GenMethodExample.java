package exam_generic_extends_implements;

public class GenMethodExample {
	static <T extends Number, V extends T> boolean isInclude(T num, V[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Integer[] inum = { 1, 2, 3, 4, 5 };
		Double[] dnum = { 1.0, 2.0, 3.0, 4.0, 5.0 };

		@SuppressWarnings("unused")
		String[] snum = { "one", "two", "three", "four", "five" };
		
		boolean b1 = isInclude(3, inum); //제네릭 자료형을 유추해서 쓰도록 작성
		System.out.println("결과: "+b1);
		
		boolean b2 = isInclude(5.0, dnum);
		System.out.println("결과: "+b2);
		
//		isInclude("one", snum);
		
		//제네릭 자료형을 정확하게 명시
		GenMethodExample.<Integer, Integer>isInclude(3, inum);
	}
}
