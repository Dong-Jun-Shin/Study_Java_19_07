package exam_lab;

import java.time.LocalDateTime;

public class Page111 {
	public static void main(String[] args) {
		LocalDateTime time = LocalDateTime.now();
		int time_hour = time.getHour();
		
		if(time_hour<24 && time_hour>=21) {
			System.out.println("늦은 밤이에요. 야식을 드세요.");
		}else if(time_hour>=18) {
			System.out.println("저녁이에요. 식사를 하세요.");
		}else if(time_hour>=13) {
			System.out.println("나른한 오후에요. 잠을 자요.");
		}else if(time_hour>=11) {
			System.out.println("점심이에요. 식사를 하세요.");
		}else if(time_hour>=6) {
			System.out.println("아침이에요. 식사를 하세요.");
		}else {
			System.out.println("깊은 밤입니다. 잠을 자세요.");
		}
	}
}
