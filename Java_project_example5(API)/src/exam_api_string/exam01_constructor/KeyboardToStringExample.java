package exam_api_string.exam01_constructor;

import java.io.IOException;

public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException{
		byte[] bytes = new byte[100];
		
		System.out.print("입력:");
		int readByteNo = System.in.read(bytes);
		System.out.println("읽어들인 바이트 수 :"+readByteNo);
		
		//0번째부터 (읽어들인 수-2)만큼 문자열로 만들기
		// (-2) = Enter(\n\r)
		// \n(줄바꿈)\r(줄 시작으로 커서 이동을 위한문자)
		String str = new String(bytes, 0, readByteNo-2);
		System.out.println(str);
	}
}
