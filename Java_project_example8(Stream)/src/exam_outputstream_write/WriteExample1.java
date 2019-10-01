package exam_outputstream_write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample1 {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			//파일 출력 객체(=os)에 명시한 test.txt라는 파일에 명령을 수행
			os = new FileOutputStream("C:/Temp/test.txt");
			
			//"JAVA"라는 문자열을 byte로 변환 후, byte배열에 저장
			//방법1 - 하나씩 입력
//			byte[] data = "JAVA".getBytes();
//			for (int i = 0; i < data.length; i++) {
//				//파일 출력 객체를 이용해서 byte배열에 있는걸 하나씩 쓰기 
//				os.write(data[i]);
//			}
			
			//방법2 - 배열을 통으로 입력
//			byte[] data = "JAVA".getBytes();
//			os.write(data); //write(바이트배열)
			
			//방법3 - 배열의 부분만 입력
//			byte[] data = "JAVA".getBytes();
//			//write 배열의 값 중에서 첫번째 인덱스부터 2개의 길이만큼만 저장.
//			os.write(data, 1, 2);
			
			//다른 예제
			byte[] data = "HelloWorld!\nMy".getBytes();
			os.write(data);
			
		}catch(FileNotFoundException io) {
			io.printStackTrace();
		}catch(IOException io) {
			io.printStackTrace();
		}finally {
			//is가 null이면 객체가 만들어지지 않은 상태
			if(os != null) {
				try {
					os.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("완료");
	}
}
