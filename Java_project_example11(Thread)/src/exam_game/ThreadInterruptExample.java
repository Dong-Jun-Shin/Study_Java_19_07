package exam_game;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//1초씩 작동하는 타이머 스레드 강제 종료
class TimerRunnable implements Runnable {
	JLabel timerLabel;

	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		int n = 0;
		while (true) {
//			timerLabel.setText(Integer.toString(n));
//			n++;
//			timerLabel.setText(LocalDateTime.now().toString());
			timerLabel.setText(new SimpleDateFormat().format(new Date()));
			try {
				// 1초 동안 잠을 잔다.
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// 예외가 발생하면 스레드 종료
				return;
			}
		}
	}

}

public class ThreadInterruptExample extends JFrame {
	private static final long serialVersionUID = -794904361364549541L;

	Thread thread;

	public ThreadInterruptExample() throws HeadlessException {
		setTitle("ThreadInterruptExample 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));

		TimerRunnable runnable = new TimerRunnable(timerLabel);

		// 스레드 생성
		thread = new Thread(runnable);
		add(timerLabel);

		// 버튼을 생성하고 Action 리스너 등록
		JButton btn = new JButton("kill Timer");
//		cancleBtn.setText("종료");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 타이머 스레드 강제 종료
				thread.interrupt();
				// 버튼이 눌렸을 때, 대상이 누군지 getSource로 가져옴
				JButton btn = (JButton) e.getSource();
				// 버튼 비활성화
				btn.setEnabled(false);
			}
		});
		add(btn);
		setSize(240, 200);
		setVisible(true);

		thread.start();
	}

	public static void main(String[] args) {
		new ThreadInterruptExample();
	}
}
