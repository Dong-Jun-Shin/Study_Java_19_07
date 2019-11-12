package exam_network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImage {
	public static void main(String[] args) {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			URL url = new URL(
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOqaD2LdTqP-JFP-0VvjaQ0tTlHZKwzTwwnhzuKxL0Z4s-gFbslA&s");
//			//서버에 값 보내고 + 읽어들이는 것도 가능하다. (입출력이 가능)
//			in = new BufferedInputStream(url.openStream());
			
			URLConnection con = url.openConnection();
			in = new BufferedInputStream(con.getInputStream());

			//원래 이미지명 일치시켜야 함
			out = new BufferedOutputStream(new FileOutputStream("image.jpg"));
//			int data = -1;
//			while ((data = in.read()) != -1) {
//				out.write(data);
//				out.flush();
//			}
			int readByteNo;
			byte[] data = new byte[2048];
			while ((readByteNo = in.read(data)) != -1) {
				out.write(data, 0, readByteNo);
			}
			System.out.println("파일 복사 완료되었습니다.");
		} catch (MalformedURLException e) {
			System.out.println("URL ERROR");
		} catch (IOException i) {
			System.out.println("IO ERROR");
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (Exception e) {
				System.out.println("CLOSE ERROR");
			}
		}
		
	}
}
