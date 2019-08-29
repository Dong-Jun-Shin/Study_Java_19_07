package exam_operation;

public class BitLogicExample {
	public static void main(String[] args) {
		String x = toBinaryString(45);
		System.out.println(x);
		System.out.println();

		System.out.println(toBinaryString(3));
		System.out.println("&");
		System.out.println(toBinaryString(5));
		System.out.println("=");
		System.out.println(toBinaryString(3 & 5));
		System.out.println();

		System.out.println("3 & 5 = " + (3 & 5));
		System.out.println("3 | 5 = " + (3 | 5));
		System.out.println("3 ^ 5 = " + (3 ^ 5));
		System.out.println("~3 = " + (~3));
	}

	public static String toBinaryString(int value) {
		String str = Integer.toBinaryString(value);
		int show_bit_space = 32;

		if (str.length() <= 20) {
			// 4byte = 32(bit)�ڸ��� 2���� ǥ���� ���� ���� ����
			// 8�ڸ��� ��� ���, ����(3�ڸ� ����) + 32�ڸ� = 0~33(34��)
			// �� ���ڸ� ���� ���� ���
			for (int i = 0; i < show_bit_space / 8; i++) {
				while (str.length() < show_bit_space + (show_bit_space / 8 - 2)) {
					str = "0" + str;
					if (str.length() == 7 + 9 * i) {
						break;
					}
				}
				str = " 0" + str;
			}
			str = str.substring(1);
		} else {
			// -n�� Shift�ϸ� 32�ڸ��� ä���� ä�� ����Ѵ�.
			for (int i = 0; i < 3; i++) {
				str = str.substring(0, 8 + 9 * i) + " " + str.substring(8 + 9 * i, str.length());
			}
		}

		return str;
	}
}
