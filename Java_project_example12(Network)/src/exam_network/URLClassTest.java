package exam_network;

import java.net.MalformedURLException;
import java.net.URL;

public class URLClassTest {
	public static void main(String[] args) {
		try {
			//.html?는 확장자일 경우와 파일과 매칭시키는 값일 경우로 나누어진다.
			URL myURL = new URL("http://java.sun.com:80/docs/books/index.html?name=database#TOP");
			
			System.out.println("프로토콜 = " + myURL.getProtocol());		//프로토콜
			System.out.println("호스트명과 포트 = " + myURL.getAuthority());	//호스트명과 포트 둘 다
			System.out.println("호스트명 = " + myURL.getHost());			//호스트명
			System.out.println("포트 = " + myURL.getPort());				//포트
			System.out.println("경로 = " + myURL.getPath());				//경로
			System.out.println("query = " + myURL.getQuery());			//query
			System.out.println("경로와 query = " + myURL.getFile());		//경로와 query
			System.out.println("ref = " + myURL.getRef());				//ref
			
		} catch (MalformedURLException e) {
			System.out.println("URL ERROR");
		}		
	}
}
