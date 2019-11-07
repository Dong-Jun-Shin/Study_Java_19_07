package exam_game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//공을 Ball 클래스로 모델링한다.
class Ball {
	// 공의 속성은 위치, 크기, 속도이다.
	private int x = 100;
	private int y = 100;
	private int size = 50;
	private int xSpeed = 50;
	private int ySpeed = 50;

	// 공을 화면에 그려주는 메소드이다.
	public void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillOval(x, y, size, size);
	}

	public void update() {
		x += xSpeed;
		y += ySpeed;
		if ((x + size) > MyBallPanel.WIDTH - size || x < 0) {
			xSpeed = -xSpeed;
		}
		if ((y + size) > MyBallPanel.HEIGHT - size || y < 0) {
			ySpeed = -ySpeed;
		}
	}
}

public class MyBallPanel extends JPanel{
	private static final long serialVersionUID = -3369208765116544383L;
	
	static final int WIDTH = 300;
	static final int HEIGHT = 300;
	private Ball ball = new Ball();

	public MyBallPanel() {
		this.setBackground(Color.DARK_GRAY);
		Runnable task = new Runnable() {

			@Override
			public void run() {
				while (true) {
					ball.update();
					repaint();
					try {
						Thread.sleep(50);
						;
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
			}
		};
		new Thread(task).start();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.draw(g);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(MyBallPanel.WIDTH, MyBallPanel.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new MyBallPanel());
		
	}
}
