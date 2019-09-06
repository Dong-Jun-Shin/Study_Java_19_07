package exam_api_string.exam01_constructor;

import java.util.Arrays;

public class ByteToStringExample {
	public static void main(String[] args) {
		//getBytes(), 문자열을 바이트배열로 리턴받는다. (String)"a" -> (byte)97
		String s = "ABCD";
		byte[] a = s.getBytes();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		//indexOf(문자열), 문자열 찾아서 몇번째인지 반환
		System.out.println(s.indexOf("B"));

		//int -> String
		String s1;
		s1 = String.valueOf(-15441 + 1);
		System.out.println(s1);

		//앞 뒤 공백 절삭
		s1 = " a  b  c  ";
		s1 = s1.trim();
		s1 = s1.replaceAll(" ", "");  //전체 공백 지우기
		System.out.println(s1);

//		------------------------------------------------------------------
		
		//Hello Java
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		String str1 = new String(bytes);
		System.out.println(str1);

		//Java
		String str2 = new String(bytes, 6, 4); //배열 중 6번째부터 4개
		System.out.println(str2);
		byte[] byteArray = str2.getBytes(); //다시 바이트로 반환해서 저장
		System.out.println(Arrays.toString(byteArray)); //배열을 문자로 해서 출력하기

		//Hello
		char[] value = { 'H', 'e', 'l', 'l', 'o' };
		String str = new String(value); //char형 배열을 String 하나에 저장
		System.out.println("배열을 이용한 문자열 객체 생성 : " + str);
		
		System.out.println(str.concat("l"));//더해주기
	}
}
