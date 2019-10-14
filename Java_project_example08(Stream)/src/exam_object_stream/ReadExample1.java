package exam_object_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class ReadExample1 {
	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("C:/Temp/test.txt");
		int readData;
		while(true) {
			//해당하는 char형 코드로 반환
			readData = reader.read();
			if(readData == -1) break;
			System.out.print(readData + "-");
			System.out.println((char)readData);
		}
		
		
//		BufferedReader reader = new BufferedReader(new FileReader("C:/Temp/test.txt"));
//		String str = null;
//		//한줄 씩 출력
//		while((str = reader.readLine())!=null) {
//			System.out.println(str);
//		}
//		reader.close();
	}
}
