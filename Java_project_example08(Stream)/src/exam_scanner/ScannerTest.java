package exam_scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) throws Exception {
		Scanner s = null;
		PrintWriter out = null;
		int sum = 0;

		out = new PrintWriter(new FileWriter("C:/Temp/input.txt"));
		// out.println("567, 123, 200");
		out.println("15");
		out.println("9.5");
		out.println("7");
		out.println("Java");
		out.println("3");
		out.flush();

		//Scanner로 파일 입력받기
		s = new Scanner(new BufferedReader(new FileReader("C:/Temp/input.txt")));
		// 구분자 명시
//		s.useDelimiter(",");
		while (s.hasNext()) {
//			System.out.println(s.next());
			if (s.hasNextInt()) {
				sum += s.nextInt();
			} else {
				s.next();
			}
		}

		System.out.println("정수의 합: " + sum);
		if (s != null)
			out.close();
		if (out != null)
			s.close();
	}
}
