package exam_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			s.append("가나다라마바사");			
		}
		byte[] buf = s.toString().getBytes();

		// "address"의 "port"에 있는 클라이언트에게 데이터를 보낸다.
		InetAddress address = InetAddress.getByName("192.168.0.117");

		// 로컬 호스트
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5000);
		socket.send(packet);
		socket.close();
	}
}
