package exam_byte;

public class ByteExample {
	public static void main(String[] args) {
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		byte var5 = 127;
		// byte var6 = 128; //범위 초과(-128 ~ 127)

		System.out.println("var1=" + var1);
		System.out.println("var2=" + var2);
		System.out.println("var3=" + var3);
		System.out.println("var4=" + var4);
		System.out.println("var5=" + var5);

		byte num6 = 20 % 6;
		System.out.println(num6);

		// byte var7 = 63*4; //범위 초과(-128 ~ 127)

		int num8 = var3 * var4; // byte*byte = int형에 담는다.
		System.out.println(num8);
	}
}
