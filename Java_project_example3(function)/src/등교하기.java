﻿class 학생{
	public int 돈 = (int)((Math.random()*50000)+1)/10*10;
	public int 생명 = 100; 
}

class 양아치{
	private int 돈  = 0;
	private int 생명 = 100;
	public static int 선택 = 0;
	
	public static void 부르기() {
		System.out.println("야, 이리와봐");
	}
	
	public static void 삥뜯기(학생 학생) {
		System.out.println("얼마 있냐");
		System.out.println(학생.돈 +"을 확인했다.");
		
		
	}
	
	public static void 토닥이기() {
		System.out.println("토닥토닥(+2)");
	}
	
	public static void 때리기(int 때릴횟수) {
		for (int 반복횟수 = 0; 반복횟수 < 때릴횟수; 반복횟수++) {
			if(반복횟수%3 == 0) {
				System.out.print("막타 치명타(-2)  ");
			}
			System.out.println("퍽(-1)  ");		
		}
	}
}

public class 등교하기{
	public static void main(String[] args) {
		
		if(양아치.선택 == 1) {
			System.out.println("뜯기 시작한다.");
			
		}
	}
}