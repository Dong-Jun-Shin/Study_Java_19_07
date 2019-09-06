

/*
 *  ㅁ   ㅁ			 ㅁ     ㅁ   ㅁ    ㅁ
 *  1  2			 3  4  5  6
 *  ㅁ    ㅁ   ㅁ    ㅁ		 ㅁ    ㅁ   ㅁ    ㅁ
 *  7  8  9  10		11 12 13 14
 *  ㅁ    ㅁ    ㅁ    ㅁ		 ㅁ    ㅁ   ㅁ    ㅁ
 *  15 16 17 18		19 20 21 22
 *  ㅁ    ㅁ    ㅁ			 ㅁ    ㅁ   ㅁ
 *  23 24 25		26 27 28
 */
public class SeatRandom {
	public static void main(String[] args) {
		String[] seat_name =  {"고석현","고준영","곽예리","구선모","김민재","김소명","김승규","김승훈","김유림","김준형","노은찬","박무송","박정선","박태정","서재현", "서희민","성보현","신동준","안상진","우성훈","원동희","유미르","이민규","이용균","이인경","조수한","조형배"};
		int[] seat = new int[27];
		int temp;
		int j;

		for (int i = 0; i < seat.length; i++) {
			temp = (int)(Math.random() * 27);

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

		for (int i=1; i <= seat.length; i++) {
			System.out.printf("%4s", seat_name[seat[i-1]]);
			if((i+2)%4==0) {
				System.out.println();
			}
		}
	}
}
