﻿/*
 * 문제 설명
직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.

제한사항
v는 세 점의 좌표가 들어있는 2차원 배열입니다.
v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
좌표값은 1 이상 10억 이하의 자연수입니다.
직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.

 */

class SolutionTest {
	public int[] solution(int[][] v) {
		int[] answer = new int[2];
		
		int compareNum = 0;

		// answer[0] = X좌표
		//같은 배열인덱스를 비교하는게 아니면서 같은 값을 가진 좌표를 compareNum에 담기
		for (int j = 0; j < v.length; j++) {
			for (int i = 1; i < v.length; i++) {
				if (v[j][0] == v[i][0] && i != j) {
					compareNum = v[j][0];
					j++;
				}
			}
		}

		//같을 값을 가진 좌표 이외의 값을 answer[0]에 대입
		for (int i = 0; i < v.length; i++) {
			if (compareNum != v[i][0]) {
				answer[0] = v[i][0];
			}
		}
		
		// answer[1] = Y좌표
		for (int j = 0; j < v.length; j++) {
			for (int i = 1; i < v.length; i++) {

				if (v[j][1] == v[i][1] && i != j) {
					compareNum = v[j][1];
					j++;
				}
			}
		}
		for (int i = 0; i < v.length; i++) {
			if (compareNum != v[i][1]) {
				answer[1] = v[i][1];
			}
		}

		System.out.println(answer[0] + ", " + answer[1]);

		return answer;
	}
}

public class KakaoChallenges1 {
	public static void main(String[] args) {
		int[][] v1 = { { 1, 4 }, { 3, 4 }, { 3, 10 } };
		int[][] v2 = { { 1, 1 }, { 2, 2 }, { 1, 2 } };
		SolutionTest a = new SolutionTest();

		a.solution(v1);
		a.solution(v2);

	}
}

//1. [1, 10]
//2. [2, 1]