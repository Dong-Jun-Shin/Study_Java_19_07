package exam_network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {
		Socket client = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			//접속할 IP
			client = new Socket("192.168.0.109", 8888);
//			client = new Socket("192.168.0.110", 8888);
//			client = new Socket("192.168.0.117", 8888);
			if(client.isConnected()) {
				System.out.println("서버와 연결됨");
			}
			
			System.out.println("서버 주소 " + client.getInetAddress());
			System.out.println("서버 포트 " + client.getPort());
			System.out.println("나의 포트 " + client.getLocalPort());
			System.out.println("나의 주소 " + client.getLocalAddress());
			
			dis = new DataInputStream(client.getInputStream());
			System.out.println("[서버로부터 전달받은 문자열]");
			System.out.println(dis.readUTF());

			dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF("실패했습니다. \n클래스를 새로 만들어서 다시 작성해주십시오.");
			
			dis.close();
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
