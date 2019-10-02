package exam_data_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * base.dat 파일에 각각 배열의 내용을 순서대로저장하고 순서대로 읽어와서
 * 전체 합(가격*수량)을 출력
 */
public class DataStreamTest {
	public static void main(String[] args) throws IOException {
		double[] prices = { 19.99, 9.97, 23.89, 4.23 };
		int[] units = { 12, 8, 23, 56 };
		String[] descs = { "Apple", "Orange", "banana", "grape" };

//		// 쓰기 풀이
//		// try-catch-finally문
//		DataOutputStream out = null;
//		try {
//			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:/Temp/base.dat")));
//
//			for (int i = 0; i < prices.length; i++) {
//				out.writeDouble(prices[i]);
//				out.writeInt(units[i]);
//				out.writeUTF(descs[i]);
//			}
//		} catch (IOException io) {
//			io.printStackTrace();
//		} finally {
//			try {
//				if (out != null)
//					out.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

//		//try-with-resource문
//		try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:/Temp/base.dat")))) {
//			for (int i = 0; i < prices.length; i++) {
//				out.writeDouble(prices[i]);
//				out.writeInt(units[i]);
//				out.writeUTF(descs[i]);
//			}
//		}catch(IOException io) {
//			io.printStackTrace();
//		}

//		// 읽기 풀이
//		// try-catch-finally문
//		DataInputStream in = null;
//		double price;
//		int unit;
//		String desc;
//		double total = 0.0;
//
//		try {
//			in = new DataInputStream(new BufferedInputStream(new FileInputStream("C:/Temp/base.dat")));
//			System.out.println("------------ Your Order's -----------");
//			// available(): 현재 읽을 수 있는 바이트 수를 얻는다.
//			while (in.available() > 0) {
//				price = in.readDouble();
//				unit = in.readInt();
//				desc = in.readUTF();
//				System.out.printf("price: %.2f, unit: %d, description: %s\n", price, unit, desc);
//				total += (unit * price);
//			}
//		} catch (IOException io) {
//			io.printStackTrace();
//		} finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

//		// try-with-resource문
//		try (DataInputStream in = new DataInputStream(
//				new BufferedInputStream(new FileInputStream("C:/Temp/base.dat")))) {
//			System.out.println("------------ Your Order's -----------");
//			// available(): 현재 읽을 수 있는 바이트 수를 얻는다.
//			while (in.available() > 0) {
//				price = in.readDouble();
//				unit = in.readInt();
//				desc = in.readUTF();
//				System.out.printf("price: %.2f, unit: %d, description: %s\n", price, unit, desc);
//				total += (unit * price);
//			}
//		} catch (IOException io) {
//			io.printStackTrace();
//		}
		
		

		//시도
		//버퍼 사용x
//		FileOutputStream fos = new FileOutputStream("C:/Temp/base.dat");
//		DataOutputStream dos = new DataOutputStream(fos);
//		FileInputStream fis = new FileInputStream("C:/Temp/base.dat");
//		DataInputStream dis = new DataInputStream(fis);

		//버퍼 사용o
		FileOutputStream fos = new FileOutputStream("C:/Temp/base.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);		
		FileInputStream fis = new FileInputStream("C:/Temp/base.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		
		
		long start = 0;
		long end = 0;
		
		
		start = System.currentTimeMillis();
		for (int i = 0; i < descs.length; i++) {
			dos.writeDouble(prices[i]);
			dos.writeInt(units[i]);
			dos.writeUTF(descs[i]);
		}
		System.out.println("쓰기 완료");
		/*쓰기용으로 사용 중인데, 읽기를 해버리면 커서는 쓰기에서 사용 후 그대로의 위치이다.
		  사용 후 제대로 마무리 해준 후, 읽기를 해야 커서가 시작위치로 설정된다.
		*/
		dos.close();
		bos.close();
		fos.close();
		System.out.println("------------ Your Order's ----------");
		while(dis.available() > 0) {
			double dp = dis.readDouble();
			int iu = dis.readInt();
			String sd = dis.readUTF();
			System.out.printf("price: %.2f, unit: %d, description: %s\n", dp, iu, sd);
		}
		end = System.currentTimeMillis();
		System.out.println("소요 시간 : " + (end-start) + "ms");
		
		
		dis.close();
		bis.close();
		fis.close();
	}
}
