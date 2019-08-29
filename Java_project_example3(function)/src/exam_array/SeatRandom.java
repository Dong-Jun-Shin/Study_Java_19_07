package exam_array;

/*
 *  ¤±   ¤±			 ¤±     ¤±   ¤±    ¤±
 *  1  2			 3  4  5  6
 *  ¤±    ¤±   ¤±    ¤±		 ¤±    ¤±   ¤±    ¤±
 *  7  8  9  10		11 12 13 14
 *  ¤±    ¤±    ¤±    ¤±		 ¤±    ¤±   ¤±    ¤±
 *  15 16 17 18		19 20 21 22
 *  ¤±    ¤±    ¤±			 ¤±    ¤±   ¤±
 *  23 24 25		26 27 28
 */
public class SeatRandom {
	public static void show(int[] seat, String[] seat_name) {
		for (int i = 1; i <= seat.length; i++) {

			System.out.printf("%4s", seat_name[seat[i - 1]]);
			if (i == 2) {
				System.out.println();
			}
			if (i % 4 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}
	public static void main(String[] args) {
		String[] seat_name = { "°í¼®Çö", "°íÁØ¿µ", "°û¿¹¸®", "±¸¼±¸ð", "±è¹ÎÀç", "±è¼Ò¸í", "±è½Â±Ô", "±è½ÂÈÆ", "±èÀ¯¸²", "±èÁØÇü", "³ëÀºÂù", "¹Ú¹«¼Û",
				"¹ÚÁ¤¼±", "¹ÚÅÂÁ¤", "¼­ÀçÇö", "¼­Èñ¹Î", "¼ºº¸Çö", "½Åµ¿ÁØ", "¾È»óÁø", "¿ì¼ºÈÆ", "¿øµ¿Èñ", "À¯¹Ì¸£", "ÀÌ¹Î±Ô", "ÀÌ¿ë±Õ", "ÀÌÀÎ°æ", "Á¶¼öÇÑ",
				"Á¶Çü¹è" };
		int[] seat = new int[27];
		int temp;
		int j, w = 0;

		for (int re = 0; re < 9; re++) {
			for (int i = 0; i < seat.length; i++) {
				temp = (int) (Math.random() * 27);

				j = 0;
				do {
					if (temp == seat[j]) {
						i--;
						break;
					}
					seat[i] = temp;
					j++;
				} while (j < i);
			}

			for (int i = 0; i < seat.length; i++) {
				if (i < seat.length - 1) {
					if (seat[i] == 14 && seat[i + 1] == 17) {
						show(seat, seat_name);
						w++;
					}
					if (seat[i] == 17 && seat[i + 1] == 14) {
						show(seat, seat_name);
						w++;
					}
				}
			}

		}
		System.out.println("°°ÀÌ ¾ÉÀº È½¼ö : " + w);
	}
}
