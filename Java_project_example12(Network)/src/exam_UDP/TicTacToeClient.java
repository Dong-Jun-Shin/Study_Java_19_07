package exam_UDP;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToeClient extends Thread{
	// 버튼들의 배열로 보드를 표현한다.
	private JButton[][] buttons = new JButton[3][3];
	// 나의 문자와 상대방 문자를 여기에 저장한다.
	private char me, other;
	// 프레임 객체
	private JFrame frame;
	// 패널 객체, 여기에 보드가 보여진다.
	private JPanel panel;
	// 서버로부터 오는 메시지를 보여주는 레이블이다.
	private JLabel message;
	// 서버와 연결된 소켓
	private Socket socket;
	// 입력 스트림
	private BufferedReader input;
	// 출력 스트림
	private PrintWriter output;

	public TicTacToeClient() throws UnknownHostException, IOException {
		// 현재는 로컬 컴퓨터에서만 실행
		socket = new Socket("localhost", 9001);

		// 소켓으로부터 입력 스트림과 출력 스트림을 구한다.
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		output = new PrintWriter(socket.getOutputStream(), true);

		// 애플리케이션의 GUI를 생성한다. 9장의 Lab과 동일하다.
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3, 5, 5));
		Font font = new Font("Dialog", Font.ITALIC, 50);
		
		message = new JLabel("여기에 메시지가 표시됩니다.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(message, BorderLayout.SOUTH);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		//패널에 3격자 형식으로 버튼을 추가한다.
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[0].length; j++) {
				final int ii = i;
				final int jj = j;
				buttons[i][j] = new JButton(" ");
				buttons[i][j].setFont(font);
				
				//각 버튼에 이벤트 처리기를 붙인다. 람다식을 사용하였다.
				buttons[i][j].addActionListener(e -> {
					buttons[ii][jj].setText("" + me);
					output.println("MOVE " + ii + " " + jj);
				});
				panel.add(buttons[i][j]);
			}
		}
		panel.repaint();
	}
	
	public void run() {
		String response;
		try {
			//서버로부터 첫 번째 명령어를 읽는다.
			response = input.readLine();
			
			if(response.startsWith("START")) {
				//START 명령어이면 경기를 시작한다.
				me = response.charAt(6);
				other = (me == 'X') ? 'O' : 'X';
				message.setText("경기가 시작됩니다.");
				frame.setTitle("현재 격ㅇ기자는 " + me);
			}
			
			//서버로부터 반복적으로 명령어를 읽어서 처리한다.
			while(true) {
				response = input.readLine();
				if(response.startsWith("OTHER")) {
					//상대방의 수를 보드에 표시한다.
					int i = Integer.parseInt(response.substring(6,7));
					int j = Integer.parseInt(response.substring(8,9));
					buttons[i][j].setText("" + other);
					message.setText("상대방이 두었습니다. ");
				}else if(response.startsWith("PRINT")) {
					//메시지를 화면에 출력한다.
					message.setText(response.substring(6));
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		TicTacToeClient client = new TicTacToeClient();
		client.start();
	}
}
