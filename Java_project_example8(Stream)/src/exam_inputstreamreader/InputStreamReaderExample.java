package exam_inputstreamreader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {
	public static void main(String[] args) throws IOException{
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		
		int readCharNo;
		String data;
		char[] cbuf = new char[100];
		System.out.print("문자를 입력해 주세요:");
		
		while((readCharNo = reader.read(cbuf)) != -1) {
			//-2는 \r과 \n을 생략하기 위해 하는 것
			data = new String(cbuf, 0, readCharNo-2);
			System.out.println(data);
		}
		reader.close();
	}
}
