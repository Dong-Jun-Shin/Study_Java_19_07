package exam_object_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample1 {
	public static void main(String[] args) throws IOException {
		Writer writer = new FileWriter("test.txt");
		char[] data = {'A', 'B', 'C', 'D', 'E'};
//		char[] data = {'홍', '길', '동'};
//		char[] data = "홍길동".toCharArray();
		
		//write(int c) 메소드 - int를 char형으로 쓰기
//		for (int i = 0; i < data.length; i++) {
//			writer.write(data[i]);
//		}
		
		//write(char[] cbuf) 메소드- 배열 전체 쓰기
//		writer.write(data);
		
		//write(char[] cbuf, int off, int len) 메소드 - char 배열 중, 일부 입력
//		writer.write(data, 1, 2);
		
		writer.flush();

		
		StringBuffer sb = new StringBuffer();
		sb.append("신은 우리가 성공할 것을 ");
		sb.append("요구하지 않는다.\n");
		sb.append("우리가 노력할 것을 요구할 ");
		sb.append("뿐이다. (마더 테레사)");
		//write(String str)
		writer.write(sb.toString());
		writer.flush();
		writer.close();
		
		System.out.println("쓰기 완료");
	}
}
