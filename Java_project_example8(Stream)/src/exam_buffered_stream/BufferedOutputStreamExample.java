package exam_buffered_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 버퍼 사용 여부에 따른 속도 차이를 확인하는 예제
 * [결과]
 * 사용하지 않았을 때: 529ms
 * 사용했을 때: 9ms
 */
public class BufferedOutputStreamExample {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int data = -1;
		long start = 0;
		long end = 0;
		
		//버퍼 없이 출력
		fis = new FileInputStream("C:/Temp/1.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("C:/Temp/1-2.jpg");
		start = System.currentTimeMillis();
		while((data = bis.read()) != -1) {
			//버퍼 없이 출력
			fos.write(data);
		}
		end = System.currentTimeMillis();
		fos.close();
		bis.close();
		fis.close();
		System.out.println("사용하지 않았을 때: " + (end-start) + "ms");

		
		//버퍼 이용 출력
		fis = new FileInputStream("C:/Temp/2.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("C:/Temp/2-2.jpg");
		//버퍼 사용을 위해 객체 생성
		bos = new BufferedOutputStream(fos);
		start = System.currentTimeMillis();
		while((data = bis.read()) != -1) {
			//버퍼 이용 출력
			bos.write(data);
		}
		end = System.currentTimeMillis();
		//닫는 순서에 따라서, 여부에 따라서 결과가 달라질 수 있으니 주의
		bos.close();
		fos.close();
		bis.close();
		fis.close();
		System.out.println("사용했을 때: " + (end-start) + "ms");
	}
}
