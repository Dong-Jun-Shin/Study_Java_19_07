package exam_lab;

/*
 *  일차원 배열에 대입된 점수에 해당하는 막대 그래프를 다음과 같이출력하시오.
 *  [실행 결과]
 *  
 *  90점 : ㅁㅁㅁㅁㅁㅁㅁㅁㅁ
 *  20점 : ㅁㅁ
 *  50점 : ㅁㅁㅁㅁㅁ
 *  70점 : ㅁㅁㅁㅁㅁㅁㅁ
 *  65점 : ㅁㅁㅁㅁㅁㅁ
 *  90점 : ㅁㅁㅁㅁㅁㅁㅁㅁㅁ
 * 100점 : ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
 *  43점 : ㅁㅁㅁㅁ
 *  55점 : ㅁㅁㅁㅁㅁ
 *  87점 : ㅁㅁㅁㅁㅁㅁㅁㅁ
 */
public class ArrayExample6 {
	public static void main(String[] args) {
		String[] qtyScore = new String[10];
		int[] score = { 90, 20, 50, 70, 65, 90, 100, 43, 55, 87 };

		
		for (int i = 0; i < qtyScore.length; i++) {
			qtyScore[i] = "";
			for (int j = 0; j < (score[i] / 10); j++) {
				qtyScore[i] += 'ㅁ';
			}
		}
		
		for(int i = 0; i < qtyScore.length; i++) {
			System.out.printf("%3d 점 : %s\n", score[i], qtyScore[i]);
		}
	}
}
