package exam_network;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionOutputTest {
	public static void main(String[] args) {
		BufferedReader in = null;
		OutputStream os = null;
		PrintWriter out = null;
		try {
			URL url = new URL("http://www.hanbit.co.kr/search/search_list.html");
			URLConnection con = url.openConnection();
			//URLConnection의 출력 스트림을 사용할지의 여부를 나타낸다.
			con.setDoOutput(true);
			
			os = con.getOutputStream();
			out = new PrintWriter(os);
			out.println("keyword_str=오라클");
			out.close();
		
			//웹은 바이트 기반이기 때문에 문자기반으로 가공해준다. (InputStreamReader)
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inLine;
			while((inLine = in.readLine())!=null) {
			System.out.println(inLine);

			}
//			System.out.println("파일 복사 완료되었습니다.");
		} catch (MalformedURLException e) {
			System.out.println("URL ERROR");
		} catch(IOException i) {
			System.out.println("IO ERROR");
		} finally {
			try {
				if(out!=null) out.close();
				if(os!=null) os.close();
				if(in!=null) in.close();
			} catch (Exception e) {
				System.out.println("CLOSE ERROR");
			}
		}
	}
}
