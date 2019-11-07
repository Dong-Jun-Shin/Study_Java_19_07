package exam_createthread;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame{
	private static final long serialVersionUID = 4364314031480416383L;

	class MyThread extends Thread{
		private JLabel label;
		private int x, y;
		
		public MyThread(String fname, int x, int y ) {
			this.x = x;
			this.y = y;
			label = new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x, y, 250, 250);
			add(label);
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 300; i++) {
				x += 10 * Math.random();
				label.setBounds(x, y, 250, 250);
				repaint();
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public CarGame() {
		setTitle("CarRace");
		setSize(1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		(new MyThread("1.jpg", 300, 0)).start();
		(new MyThread("2.jpg", 300, 250)).start();
		(new MyThread("3.jpg", 300, 500)).start();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		/*CarGame t = */new CarGame();
	}
}
