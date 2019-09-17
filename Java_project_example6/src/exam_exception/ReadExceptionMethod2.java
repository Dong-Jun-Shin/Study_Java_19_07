package exam_exception;

import java.io.*;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;

public class ReadExceptionMethod2 {
	//	//throws 사용 예외처리 (예제용)
	//	public static void main(String[] args) throws FileNotFoundException, IOException {
	//		FileInputStream fi = new FileInputStream("test1.txt");
	//		int c = fi.read(); //read는 한 바이트만 읽는다.
	//		System.out.println((char) c);
	//	}

	//try~catch 사용
	public static void main(String[] args) {
		FileInputStream fi = null;
		
		byte[] readBytes = new byte[6];
		int readByteNo;
		String data = "";
		
		try {
			fi = new FileInputStream("test.txt");
			while(true) {
				readByteNo = fi.read(readBytes);
				System.out.println("읽은 바이트 수 : " + readByteNo);
				if(readByteNo == -1) break;
				data += new String(readBytes, 0, readByteNo);
			}
			System.out.println(data);
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중에 문제가 발생하였습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fi!=null) fi.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}