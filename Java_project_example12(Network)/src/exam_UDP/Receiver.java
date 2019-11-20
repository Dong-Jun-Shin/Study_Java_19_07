package exam_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 전송 받는 쪽
 * 
 * @author user
 */
public class Receiver {
	public static void main(String[] args) throws IOException {
		byte[] buf = new byte[256];

		// 포트번호 : 5000
		DatagramSocket socket = new DatagramSocket(5000);

		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		// 패킷이 도착할 때까지 기다리게 된다.
		socket.receive(packet);

		// 바이트를 스트링 객체로 변환한다.
		System.out.println(new String(buf));
		socket.close();

	}
}
