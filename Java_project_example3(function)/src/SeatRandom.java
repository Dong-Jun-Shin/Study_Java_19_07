

/*
 *  ��   ��			 ��     ��   ��    ��
 *  1  2			 3  4  5  6
 *  ��    ��   ��    ��		 ��    ��   ��    ��
 *  7  8  9  10		11 12 13 14
 *  ��    ��    ��    ��		 ��    ��   ��    ��
 *  15 16 17 18		19 20 21 22
 *  ��    ��    ��			 ��    ��   ��
 *  23 24 25		26 27 28
 */
public class SeatRandom {
	public static void main(String[] args) {
		String[] seat_name =  {"����","���ؿ�","������","������","�����","��Ҹ�","��±�","�����","������","������","������","�ڹ���","������","������","������", "�����","������","�ŵ���","�Ȼ���","�켺��","������","���̸�","�̹α�","�̿��","���ΰ�","������","������"};
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
