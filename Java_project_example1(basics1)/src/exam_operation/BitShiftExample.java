package exam_operation;

public class BitShiftExample {
	public static void main(String[] args) {
		System.out.println(toBinaryString(1));
		System.out.println("<< 3");
		System.out.println(toBinaryString(1 << 3));

		System.out.println("1 << 3 ������ ���: " + (1 << 3));
		System.out.println();

		System.out.println(toBinaryString(-8));
		System.out.println(">> 3");
		System.out.println(toBinaryString(-8 >> 3));

		System.out.println("-8 << 3 ������ ���: " + (-8 << 3));
		System.out.println();

		System.out.println(toBinaryString(-8));
		System.out.println(">>> 3");
		System.out.println(toBinaryString(-8 >>> 3));

		System.out.println("-8 >>> 3 ������ ���: " + (-8 >>> 3));
		System.out.println();
	}

	public static String toBinaryString(int value) {
		String str = Integer.toBinaryString(value);
		int showBitSpace = 32;

		if (str.length() <= 20) {
			// 4byte = 32(bit)�ڸ��� 2���� ǥ���� ���� ���� ����
			// 8�ڸ��� ��� ���, ����(3�ڸ� ����) + 32�ڸ� = 0~33(34��)
			// �� ���ڸ� ���� ���� ���
			for (int i = 0; i < showBitSpace / 8; i++) {
				while (str.length() < showBitSpace + (showBitSpace / 8 - 2)) {
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
