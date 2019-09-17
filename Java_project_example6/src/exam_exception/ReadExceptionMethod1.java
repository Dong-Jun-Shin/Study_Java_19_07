package exam_exception;

import java.io.IOException;

public class ReadExceptionMethod1 {
	//try~catch를 이용해서 내부 예외처리
	public static void main(String[] args) {
		System.out.println(readString());
	}
	
	public static String readString(){
		byte[] buf = new byte[100];
		System.out.print("문자열을 입력하시오:");
		int readCount = 0;
		try {
			readCount = System.in.read(buf);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		return new String(buf, 0, readCount - 2);
	}
	
//	//throws를 이용한 예외 처리
//	public static void main(String[] args) {
//		try {
//			System.out.println(readString());
//		}catch(IOException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//	
//	public static String readString() throws IOException{
//		byte[] buf = new byte[100];
//		System.out.print("문자열을 입력하시오:");
//		System.in.read(buf);
//		
//		return new String(buf);
//	}
	
//	//throws를 이용한 예외 처리
//	public static void main(String[] args) {
//		try {
//			System.out.println(readString());			
//		}catch(IOException e){
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	public static String readString() throws IOException{
//	byte[] buf = new byte[100];
//	System.out.print("문자열을 입력하시오:");
//	int readCount = System.in.read(buf);
//
//	return new String(buf, 0, readCount - 2);
//	}
}
