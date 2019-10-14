package exam_class;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * "C:/Temp/intest.txt"를 생성한다. (직접 파일 생성)
 * 해당 파일에는 아래의 내용이 저장되어 있다.
 * Hello World!
 * My Name is IOStream
 * 이 내용을 읽어 C:/Temp/outtest.txt 파일을 생성하여 저장한다.
 */

public class InputOutputStreamExample {
	public static void main(String[] args) {
		//파일 생성
		try(OutputStream os = new FileOutputStream("C:/Temp/intest.txt")) {
			byte[] data = "Hello World!\nMy Name is IOStream".getBytes();
			os.write(data);
		}catch(IOException io) {
			io.printStackTrace();
		}
		System.out.println("쓰기 완료");
				
		//풀이
		//파일 읽고 복사
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("C:/Temp/intest.txt");
			fos = new FileOutputStream("C:/Temp/outtest.txt");
			//읽을게 아무것도 없으면 반복 멈추기 
			int data = -1;
			
			//읽고 data에 넣고 -1과 비교한 값을 반전
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			System.out.println("파일 복사가 완료 되었습니다.");
		}catch(IOException io) {
			System.out.println("파일 입출력에 문제가 발생하여 더 이상의 작업을 진행할 수 없습니다.");
			io.printStackTrace();
		}catch(Exception e) {
			System.out.println("오류 발생으로 더 이상의 작업을 진행할 수 없습니다.");
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			}catch(IOException io) {
				io.printStackTrace();
			}
		}
		
		
		//시도
		//파일 읽기
		//try-with-resource 사용 시, 체크 예외가 여러개이면 ';'으로 구분해준다.
		try(InputStream is = new FileInputStream("C:/Temp/intest.txt");
			OutputStream os = new FileOutputStream("C:/Temp/outtest.txt");){
			int byteNo = 0;
			
			//byte를 하나 읽고, 하나 쓰고 반복한다.
			while(true) {
				byteNo = is.read();
				if(byteNo == -1) break;

				os.write(byteNo);
			}
			System.out.println("파일 읽기 완료");
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
}
