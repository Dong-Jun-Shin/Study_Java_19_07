package exam_lab;

import java.time.LocalDateTime;

public class Page111 {
	public static void main(String[] args) {
		LocalDateTime time = LocalDateTime.now();
		int time_hour = time.getHour();
		
		if(time_hour<24 && time_hour>=21) {
			System.out.println("���� ���̿���. �߽��� �弼��.");
		}else if(time_hour>=18) {
			System.out.println("�����̿���. �Ļ縦 �ϼ���.");
		}else if(time_hour>=13) {
			System.out.println("������ ���Ŀ���. ���� �ڿ�.");
		}else if(time_hour>=11) {
			System.out.println("�����̿���. �Ļ縦 �ϼ���.");
		}else if(time_hour>=6) {
			System.out.println("��ħ�̿���. �Ļ縦 �ϼ���.");
		}else {
			System.out.println("���� ���Դϴ�. ���� �ڼ���.");
		}
	}
}
