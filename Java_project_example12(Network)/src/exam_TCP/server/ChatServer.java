package exam_TCP.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/*
 * Vector는 스레드 동기화(synchronization)
 * 복수의 스레드가 동시에 Vector에 접근해 객체를 추가, 삭제하더라도 스레드에 안전(thread safe)
 */
public class ChatServer {
	Vector<ServiceThread> clients;

	public ChatServer() {
		clients = new Vector<>();
	}
	
	//클라이언트 추가
	public void addClient(ServiceThread st) {
		clients.addElement(st);
	}
	
	//클라이언트 삭제
	public void removeClient(ServiceThread st) {
		clients.removeElement(st);
	}
	
	//전체 메시지 출력
	public void sendMessageAll(String msg) {
		try {
			for (int i = 0; i < clients.size(); i++) {
				ServiceThread st = ((ServiceThread)clients.elementAt(i));
				st.sendMessage(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 9999;
		//클라이언트를 관리하는 객체(추가, 삭제, 메세지,
		ChatServer server = new ChatServer();
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (Exception e) {
			System.err.println("연결 실패입니다.");
			System.exit(1);
		}
		System.out.println("서버에서 연결을 기다립니다.");
		
		try {
			while(true) {
				//클라이언트 접속
				Socket serviceSocket = serverSocket.accept();
				
				//클라이언트 관리하는 객체, 클라이언트를 가진 객체를 생성한 후
				// Thread를 통해서 작업을 (읽고 쓰는) run 메소드를 명시한 후 실행한다.
				ServiceThread thread = new ServiceThread(server, serviceSocket);
				thread.start(); //run을 호출한다.
				server.addClient(thread);
			}
		} catch (Exception e) {
			try {
				serverSocket.close(); //서버종료
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("서버를 종료합니다.");
	}
}
