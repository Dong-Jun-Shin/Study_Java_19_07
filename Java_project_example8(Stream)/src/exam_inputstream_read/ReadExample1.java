package exam_inputstream_read;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExample1 {
	public static void main(String[] args) {
//		InputStream is = null;
//		try {
//			is = new FileInputStream("C:/Temp/test.txt");
//			//방법1 - int변수를 활용해서 출력
////			int readByte;
////			System.out.println("읽어 들인 문자 : ");
////			while (true) {
////				// read()로 읽어들이다가 끝을 출력할 때 -1을 반환
////				readByte = is.read();
////				if (readByte == -1)
////					break;
////				System.out.println((char) readByte);
////			}
//
//			//방법2 - 배열을 활용해서 출력
////			int readByteNo;
////			byte[] readBytes = new byte[4];
////			
////			String data = "";
////			while(true) {
////				readByteNo = is.read(readBytes);
////				System.out.println("읽은 바이트 수: " + readByteNo);
////				if(readByteNo == -1) break;
////				//byte[] b를 0부터 'readByteNo'개 만큼 읽어서 String으로 만든다.
////				data += new String(readBytes, 0, readByteNo);
////			}
////			System.out.println(data);
//
//			//방법3 - byte[]에 중간 삽입
//			int readByteNo;
//			byte[] readBytes = new byte[10];
//			//readBytes[]에 저장할 길이수는 5이고 배열의 저장 위치는 2번째부터. (''으로 초기화 되어 있는 배열의 2~6까지 저장)
//			readByteNo = is.read(readBytes, 2, 5);
//			System.out.println("리턴 바이트 수 : " + readByteNo);
//			
//			for (int i = 0; i < readBytes.length; i++) {
//				System.out.println((char)readBytes[i]);
//			}
//			
//		} catch (FileNotFoundException io) {
//			io.printStackTrace();
//		} catch (IOException io) {
//			io.printStackTrace();
//		} finally {
//			try {
//				//is가 null이면 객체가 만들어지지 않은 상태
//				if (is != null) {
//					is.close();
//				}
//			} catch (IOException io) {
//				io.printStackTrace();
//			}
//		}
		
		//try-with-resource문 이용 -> try선언과 동시에 생성까지 한다. 이상이 없을 경우, close까지 해준다. 
		int readByte;
		try(InputStream fis = new FileInputStream("C:/Temp/test.txt")){
			while(true) {
				readByte = fis.read();
				if(readByte == -1) break;
				System.out.print((char)readByte);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n완료");
	}
}
