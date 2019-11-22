package exam_TCP.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1965003726171914347L;

	private Socket clientSocket = null;// 클라이언트 선언

	private PrintWriter out = null;
	private BufferedReader in = null;// 클라이언트 선언

	private JTextArea outputArea;
	private JTextField inputField;
	private JScrollPane scrollPane;
	private JPanel pa;

	public ChatClient(String title) { // 스윙은 UI 초기화를 생성자에 명시
		super(title);
		pa = new JPanel(new BorderLayout());
		outputArea = new JTextArea();

		outputArea.setEditable(false);
		scrollPane = new JScrollPane(outputArea); // 스크롤 패인 추가
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		outputArea.setCaretPosition(outputArea.getDocument().getLength());

		pa.add(scrollPane, "Center");
		inputField = new JTextField();
		pa.add(inputField, "South");
		inputField.addActionListener(new InputListener());// 이벤트 호출
		add(pa);

	}

	public void addMessage(String msg) {
		// 전체 주고받는 메시지에 입력한 값을 추가한다.
		outputArea.append(msg);
	}

	public void connect(String host, int port) {
		try {
			//서버에 접속
			clientSocket = new Socket(host, port);
			
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					
		} catch (Exception e) {
			System.err.println("입출력 에러입니다.");
			System.exit(1);
		}
	}

	public void disconnect() {
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException ie) {

		}
	}

	@Override
	public void run() {
		try {
			while(true) {
				//서버측으로부터 읽은 데이터 출력
				addMessage(in.readLine() + "\n");
			}
		} catch (IOException ie) {
			disconnect();
		}
	}
	
	class InputListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String input = inputField.getText();
			inputField.setText("");
			try {
				//클라이언트에서 입력 데이터 서버측으로 전송
				out.println(input);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			outputArea.setCaretPosition(outputArea.getDocument().getLength());
		}
	}

	public static void main(String[] args) {
		ChatClient mf = new ChatClient("자바 채팅 클라이언트");
		
		mf.pack();
		mf.setSize(500,300);
		mf.setVisible(true);
		mf.connect("192.168.0.130", 9999);
		Thread thread = new Thread(mf);
		thread.start();
	}
}
