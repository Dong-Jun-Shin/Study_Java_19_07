﻿package exam_printpage;

public class ScoreOXMain {
	public static void main(String[] args) {
//		변수 할당 후 대입하는 방법 (스택에 변수를 할당받아 사용)
//		int[] dap1 = {1,2,1,3,4};
//		int[] dap2 = {1,1,1,1,1};
//		int[] dap3 = {1,2,1,3,1};
//		int[] dap4 = {1,1,1,3,1};
//		int[] dap5 = {1,4,2,5,4};
//		
//		ScoreOX[] sc = new ScoreOX[5];
//		sc[0] = new ScoreOX(1, "홍길동", dap1);
//		sc[1] = new ScoreOX(2, "김철수", dap2);
//		sc[2] = new ScoreOX(3, "이진희", dap3);
//		sc[3] = new ScoreOX(4, "조현민", dap4);
//		sc[4] = new ScoreOX(5, "최현정", dap5);
		
//		클래스 배열을 생성하며 힙에서 바로 대입 (스택에 변수 할당x)
		ScoreOX[] sc = {
				new ScoreOX(1, "홍길동", new int[] {1,2,1,3,4}),
				new ScoreOX(2, "김철수", new int[] {1,1,1,1,1}),
				new ScoreOX(3, "이진희", new int[] {1,2,1,3,1}),
				new ScoreOX(4, "조현민", new int[] {1,1,1,3,1}),
				new ScoreOX(5, "최현정", new int[] {1,4,2,5,4}),
		};
		
		
		//비교하기
		for (int i = 0; i < sc.length; i++) {
			sc[i].compute();			
		}
		
		//등수 구하기
		ScoreOX.ranking(sc);
		
		//출력
		System.out.printf("\n");
		System.out.printf(" * * 시험결과 * * \n\n");
		System.out.printf("-------------------------------------------------------------------------\n");
		System.out.printf("번호\t이름\t1\t2\t3\t4\t5\t점수\t등수\n");
		System.out.printf("-------------------------------------------------------------------------\n");
		for (int i = 0; i < sc.length; i++) {
			sc[i].display();
		}
		System.out.printf("\n전체 맞은 개수 = %2d", ScoreOX.tot);
	}
}
