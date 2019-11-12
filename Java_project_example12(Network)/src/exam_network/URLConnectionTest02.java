package exam_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest02 {
	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			URL url = new URL("http://tour.chungnam.net/_prog/openapi/?func=tour&start=1&end=10");
			URLConnection con = url.openConnection();

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
				if(in!=null) in.close();
			} catch (Exception e) {
				System.out.println("CLOSE ERROR");
			}
		}
	}
}
