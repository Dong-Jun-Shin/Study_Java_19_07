package exam_lab;

/*
 *  析託据 壕伸拭 企脊吉 繊呪拭 背雁馬澗 厳企 益掘覗研 陥製引 旭戚窒径馬獣神.
 *  [叔楳 衣引]
 *  
 *  90繊 : けけけけけけけけけ
 *  20繊 : けけ
 *  50繊 : けけけけけ
 *  70繊 : けけけけけけけ
 *  65繊 : けけけけけけ
 *  90繊 : けけけけけけけけけ
 * 100繊 : けけけけけけけけけけ
 *  43繊 : けけけけ
 *  55繊 : けけけけけ
 *  87繊 : けけけけけけけけ
 */
public class ArrayExample6 {
	public static void main(String[] args) {
		String[] qtyScore = new String[10];
		int[] score = { 90, 20, 50, 70, 65, 90, 100, 43, 55, 87 };

		
		for (int i = 0; i < qtyScore.length; i++) {
			qtyScore[i] = "";
			for (int j = 0; j < (score[i] / 10); j++) {
				qtyScore[i] += 'け';
			}
		}
		
		for(int i = 0; i < qtyScore.length; i++) {
			System.out.printf("%3d 繊 : %s\n", score[i], qtyScore[i]);
		}
	}
}
