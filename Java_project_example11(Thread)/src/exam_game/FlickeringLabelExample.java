package exam_game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;

//깜박이는 문자열을 가진 레이블 만들기
class FlickeringLabel extends JLabel implements Runnable {
	private static final long serialVersionUID = 1651352412448013739L;

	public FlickeringLabel(String text) {
		// JLabel 생성자 호출
		super(text);
		// 배경색 변경이 가능하도록 설정
		setOpaque(true);

		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		int n = 0;

		while (true) {
			if (n == 0) {
				setBackground(Color.YELLOW);
				n = 1;
			} else {
				setBackground(Color.GREEN);
				n = 0;
			}
			
			try {
				//0.5초의 간격으로 코드 실행
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}

public class FlickeringLabelExample extends JFrame {
	private static final long serialVersionUID = -2677430460879976050L;

	public FlickeringLabelExample() throws HeadlessException {
		setTitle("FlickeringLabelExample 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//깜빡이는 레이블 생성
		FlickeringLabel fLabel = new FlickeringLabel("깜박");
		
		//깜빡이지 않는 레이블 생성
		JLabel label = new JLabel("안깜빡");
		
		//깜빡이는 레이블 생성
		FlickeringLabel fLabel2 = new FlickeringLabel("여기도 깜빡");
		
		add(fLabel);
		add(label);
		add(fLabel2);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlickeringLabelExample();
	}

	
}
