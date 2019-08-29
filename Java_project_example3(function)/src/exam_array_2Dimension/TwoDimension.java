package exam_array_2Dimension;

/*
 * 다음과 같은 값을 초기값으로 갖는 {95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88}
 * 2차원 배열이 존재한다. (array)
 * 전체 항목의 합과 평균값을 출력하도록 프로그램을 작성해 주세요.
 */
public class TwoDimension {
	public static void main(String[] args) {
		int[][] arr = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int total = 0, cnt = 0;
		double avg = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
				cnt++;
			}
		}
		avg = (double)total / cnt;

		System.out.println("배열의 개수 : " + cnt);
		System.out.println(total + " <-합계 | 평균 -> " + avg);

	}
}
