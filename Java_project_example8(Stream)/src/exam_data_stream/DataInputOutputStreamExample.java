package exam_data_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamExample {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = new FileOutputStream("C:/Temp/primitive.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동");
		dos.writeDouble(95.5);
		dos.writeInt(1);
		
		dos.writeUTF("\n김철수");
		dos.writeDouble(90.3);
		dos.writeInt(2);
		
		dos.close();
		fos.close();
		System.out.println("쓰기 완료");
		
		FileInputStream fis = new FileInputStream("C:/Temp/primitive.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		//방법1
		//for(int i = 0; i<2; i++){
		while(fis.available() > 0) {
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name + " " + score + " " + order);
		}
		
		
//		//방법2
//		String str = "";
//		//올바르게 읽은 경우
//		str += dis.readUTF() + " ";
//		str += dis.readDouble() + " ";
//		str += dis.readInt() + " ";
//		
//		//쓴 형식과 다르게 읽은 경우
//		str += dis.readUTF() + " ";
//		str += dis.readInt() + " ";
//		str += dis.readDouble() + " ";
//		
		System.out.println("읽기 완료");
//		System.out.println(str);
		
		dis.close();
		fis.close();
//		
		
		
	}
}
