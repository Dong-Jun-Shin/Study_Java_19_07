package exam_network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLTest {
	public static void main(String[] args) throws Exception {
		String site = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";
		
		URL url = new URL(site);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		System.out.println("문서의 타입:"+conn.getContentType());
		
		int resCode= conn.getResponseCode();
		System.out.println("응답코드 : " + resCode);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer output = new StringBuffer();
		
		while((inputLine = in.readLine())!=null){
			output.append(inputLine);
			output.append("\n");
		}
		in.close();
		System.out.println(output);
	}
}
