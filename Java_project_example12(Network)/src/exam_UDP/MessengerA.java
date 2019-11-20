package exam_UDP;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/*
 * UDP 토신을 이용하여서 간단한 채팅을 할 수 있는 메시지를 작성하여 보자.
 * 여기서 송신용 포트 번호와 수신용 포트 번호가 고정되어 있다.
 */

public class MessengerA {
	protected JTextField textField;
	protected JTextArea textArea; 
	protected JScrollPane scrollPane;
	
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	
	final int myPort = 5000; //수신용 포트 번호
	final int otherPort = 6000; //송신용 포트 번호
	
	public MessengerA() throws IOException {
		new MyFrame();
//		address = InetAddress.getByName("192.168.0.115");
		address = InetAddress.getByName("192.168.0.117");
//		address = InetAddress.getByName("127.0.0.1");
		socket = new DatagramSocket(myPort);
	}
	
	//패킷을 받아서 텍스트 영역에 표시한다.
	public void process() {
		while(true) {
			try {
				byte[] buf = new byte[256];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet); //패킷을 받는다.
				//받은 패킷을 텍스트 영역에 표시한다.
				textArea.append("RECIEVED: " + new String(buf) + "\n");
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	//내부 클래스 정의
	class MyFrame extends JFrame implements ActionListener {
		private static final long serialVersionUID = -6782739081077562801L;
		
		public MyFrame() throws HeadlessException {
			super("MessengerA");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			textField = new JTextField(30);
			textField.addActionListener(this);
			
			textArea = new JTextArea(10, 30);
			textArea.setEditable(false);
			scrollPane = new JScrollPane(textArea); //스크롤 팬 추가
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setAutoscrolls(true);
			textArea.setCaretPosition(textArea.getDocument().getLength());
			
			add(textField, BorderLayout.PAGE_END);
			add(new JScrollPane(textArea), BorderLayout.CENTER);
			pack();
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = textField.getText();
			byte[] buffer = s.getBytes();
			DatagramPacket packet;

			//패킷을 생성한다.
			packet = new DatagramPacket(buffer, buffer.length, address, otherPort);
			try {
				socket.send(packet); //패킷을 보낸다.
			} catch (IOException ie) {
				ie.printStackTrace();
			}
			textArea.append("SEND: " + s + "\n");
//			textField.selectAll();
			textField.setText("");
		}
	}
	public static void main(String[] args) throws IOException {
		MessengerA m = new MessengerA();
		m.process();
	}
}
