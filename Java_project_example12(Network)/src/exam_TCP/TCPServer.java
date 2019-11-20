package exam_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			// 설정할 포트번호
			server = new ServerSocket(8888);
			System.out.println("클라이언트를 기다린다.");

			// 클라이언트의 Socket 클래스를 통해 연결을 승인
			Socket st = server.accept();
			System.out.println("클라이언트와 연결 여부 : " + st.isConnected());

			System.out.println("로컬 소켓 주소 : " + st.getLocalSocketAddress());

			dos = new DataOutputStream(st.getOutputStream());
			dos.writeUTF("실패했습니다. \n클래스를 새로 만들어서 다시 작성해주십시오.");

			dis = new DataInputStream(st.getInputStream());
			System.out.println("[클라이언트로부터 전달받은 문자열]");
			System.out.println(dis.readUTF());
			
			dos.close();
			dis.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
