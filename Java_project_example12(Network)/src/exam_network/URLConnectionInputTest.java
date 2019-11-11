package exam_network;

import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionInputTest {
	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			//기상청 날씨 정보
			URL url = new URL("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108");
		} catch (MalformedURLException e) {
			// TODO: handle exception
		}
	}
}
