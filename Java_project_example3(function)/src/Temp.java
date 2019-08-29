public class Temp {
	public static void main(String[] args) {
		System.out.println("せせせせせせせせせせせせ");
		System.out.println("せせせせせせせせせせせせ");
		System.out.println("	         せせせ");
		System.out.println("せせせせせせせせせせせせ");
		System.out.println("せせせせせせせせせせせせ");
		System.out.println("	         せせせ");
		System.out.println("	         せせせ");
		System.out.println("	         せせせ");
		System.out.println("---------------------------");

		
		/**
		 *   1  2  3  4  5
		 	16 17 18 19  6
		 	15 24 25 20  7
		 	14 23 22 21  8
		 	13 12 11 10  9
		 */
		int i = 0, j = 0, k;
		int num = 1;

		int array = 5;
		int map[][] = new int[array][array];

		int plus_minus = 1;

		
		
		for (k = 0; k < 2; k++) {
			if(plus_minus==1) {
				// i, j++
				for (i=0; i < 1; i += plus_minus) {
					for (j=0; j < 5; j += plus_minus) {
						map[i][j] = num++;
					}
				}
				
				// i++,j
				for (j=4; j < 5; j += plus_minus) {
					for (i=1; i < 5; i += plus_minus) {
						map[i][j] = num++;
					}
				}
				
				plus_minus *= (-1); 
			}else {
				// i, j--
				for (i=4; i > 3; i += plus_minus) {
					for (j=3; j > 0; j += plus_minus) {
						map[i][j] = num++;
					}
				}
				
				// i--, j
				for (j=0; j > -1; j += plus_minus) {
					for (i=4; i > 0; i += plus_minus) {
						map[i][j] = num++;
					}
				}
				plus_minus *= (-1);
			}
		}

		for (k = 0; k < 2; k++) {
			if(plus_minus==1) {
				// i, j++
				for (i=1; i < 2; i += plus_minus) {
					for (j=1; j < 4; j += plus_minus) {
						map[i][j] = num++;
					}
				}
				
				// i++,j
				for (j=3; j < 4; j += plus_minus) {
					for (i=2; i < 4; i += plus_minus) {
						map[i][j] = num++;
					}
				}
				plus_minus *= (-1); 
			}else {
				// i, j--
				for (i=3; i > 2; i += plus_minus) {
					for (j=2; j > 1; j += plus_minus) {
						map[i][j] = num++;
					}
				}
				
				// i--, j
				for (j=1; j > 0; j += plus_minus) {
					for (i=3; i > 1; i += plus_minus) {
						map[i][j] = num++;
					}
				}
				plus_minus *= (-1);
			}
		}
		// i, j++
		for (i=2; i < 3; i += plus_minus) {
			for (j=2; j < 3; j += plus_minus) {
				map[i][j] = num++;
			}
		}
		
		//窒径
		for(i=0; i<array; i++) {
			for(j=0; j<array; j++) {
				System.out.printf("%3d", map[i][j]);		
				
			}
			System.out.println("");
		}
	}
}