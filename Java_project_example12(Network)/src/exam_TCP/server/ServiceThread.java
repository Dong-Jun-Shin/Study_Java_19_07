package exam_TCP.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 클라이언트가 접속되면 메시지를 관리하고 전체 메시지를 리턴하는 구조를 연동하게 되는데
 * 서버를 연동할 때 클라이언트가 접속되어 연결하는 코드를 작성한 클래스 이다.
 * 메시지 관리를 하는 스트림을 지정하여 클라이언트가 보낸 메세지를 메소드를 통해 전달하도록 지정한 클래스
 */
public class ServiceThread extends Thread{
	// 클라이언트의 정보(추가, 클라이언트 삭제, 모든 메시지 관리)
	private ChatServer server;
	private Socket socket;

	// 클라이언트 이름
	String UserName;

	PrintWriter out;
	BufferedReader in;

	public ServiceThread(ChatServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
	}

	// 클라이언트가 메시지를 입력하게 되면 out 객체에 출력하는 메소드
	public void sendMessage(String msg) throws IOException {
		if (out != null)
			out.println(msg);
	}

	// 클라이언트 창에 출력하는 코드를 작성
	public void run() {
		try {
			System.out.println("클라이언트\n" + socket + "\n에서 접속하였습니다.");

			// 메시지 입출력 객체를 소켓에서 받아온다.
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 줄바꿈
			out.println();
			out.println("UserName:");
			UserName = in.readLine();
			sendMessage(UserName);
			server.sendMessageAll("#" + UserName + "님이 들어오셨습니다.");
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				server.sendMessageAll("[" + UserName + "] " + inputLine);
			}
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			// 클라이언트 삭제
			server.removeClient(this);
			server.sendMessageAll("#" + UserName + "님이 나가셨습니다.");
			System.out.println("클라이언트\n" + socket + "\n에서 접속이 끊겼습니다.");
		}
	}
}
