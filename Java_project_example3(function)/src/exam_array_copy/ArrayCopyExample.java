package exam_array_copy;

public class ArrayCopyExample {
	public static void main(String[] args) {
		String[] oldStrArray = { "java", "array", "copy" };
		String[] newStrArray = new String[5];

		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);

		for (int i = 0; i < newStrArray.length; i++) {
			System.out.print(newStrArray[i]);
			if (i < newStrArray.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		int myArray[] = { 100, 200, 300, 400, 500 };
		int hold[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
		System.out.println();

		for (int j = 0; j < hold.length; j++) {
			System.out.println(hold[j] + " ");
		}

		System.out.println();
		System.arraycopy(myArray, 0, hold, 0, myArray.length);

		System.out.println("<==arraycopy result ==>");
		for (int j = 0; j < hold.length; j++) {
			System.out.println(hold[j] + " ");
		}
	}
}
