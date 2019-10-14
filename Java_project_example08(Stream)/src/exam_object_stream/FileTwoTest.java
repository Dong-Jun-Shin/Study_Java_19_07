package exam_object_stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * 주어진 2개의 텍스트 파일(test.txt, result.txt)을 합하여
 * 하나의 파일(writer.txt)로 만드는 프로그램을 작성하시오.
 */
public class FileTwoTest {
	public static void main(String[] args) {
//		//result 파일 만들기
//		try(Writer writer = new FileWriter("result.txt")){
//			String str1 = "\n행복은 성취의 기쁨과 창조적인 노력이 주는 쾌감 속에 있다.(프랭클린 D, 루스벨트)\n";
//			String str2 = "우리가 할 수 있기 전에 배워야 하는 일들을, 우리는 하면서 배운다. (아리스토텔레스)";
//			
//			writer.write(str1);
//			writer.write(str2);
//		}catch(IOException io) {
//			io.printStackTrace();
//		}
		
		// 파일 합치기 (try-catch)
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		Writer fw = null;

		try {
			br1 = new BufferedReader(new FileReader(new File("test.txt")));
			br2 = new BufferedReader(new FileReader("result.txt"));

			fw = new FileWriter("writer.txt");

			// String형으로 한 줄씩 읽어올 경우 & 출력
			while (true) {
				String line = br1.readLine();
				if (line == null) {
					break;
				}
				fw.write(line + "\n");
				System.out.println("쓰는중");
			}
			System.out.println("첫번째 쓰기 완료");

			while (true) {
				String line = br2.readLine();
				if (line == null) {
					break;
				}
				fw.write(line + "\n");
				System.out.println("쓰는중");
			}
			System.out.println("두번째 쓰기 완료");
			fw.flush();
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			try {
				if (br1 != null)
					br1.close();
				if (br2 != null)
					br2.close();
				if (fw != null)
					fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//		// 파일 합치기 (try-with-resource)
//		try (Writer writer = new FileWriter("writer.txt");
//				BufferedReader reader1 = new BufferedReader(new FileReader("test.txt"));
//				BufferedReader reader2 = new BufferedReader(new FileReader("result.txt"))) {
//			// char형으로 한 자씩 읽어올 경우 & 출력
//			char[] cb = new char[10000];
//			int cnt = 0;
//			while (true) {
//				int str = reader1.read();
//				cb[cnt] = (char) str;
//				if (str == -1) {
//					System.out.println("첫번째 파일 쓰기 완료");
//					break;
//				}
//				cnt++;
//			}
//
//			while (true) {
//				int str = reader2.read();
//				cb[cnt] = (char) str;
//				if (str == -1) {
//					System.out.println("두번째 파일 쓰기 완료");
//					break;
//				}
//				cnt++;
//			}
//			int i = 0;
//			while (true) {
//				writer.write(cb[i]);
//				if (cb[i] == '\0') {
//					break;
//				}
//				i++;
//			}
//
//			System.out.println("쓰기 완료");
//		} catch (IOException io) {
//			io.printStackTrace();
//		}
	}
}
