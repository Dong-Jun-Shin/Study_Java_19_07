package exam_outputstreamwriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterExample {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
		Writer writer = new OutputStreamWriter(fos);
		
		String data = "오늘 하루도 다들 고생 많이 하셨습니다.";
		writer.write(data);
		
		writer.flush();
		writer.close();
		fos.close();
		System.out.println("파일 저장이 끝났습니다.");
	}
}
