package exam_api_string.exam02_method;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class StringSort {
	public static StringTokenizer strSort() {
		Scanner scan = new Scanner(System.in);
		
		String text = scan.nextLine();
		StringTokenizer str = new StringTokenizer(text, ", ");
		
		scan.close();
		return str;
	}
	
}

public class StringSortTest{
	public static void main(String[] args) {
		StringTokenizer str = StringSort.strSort();
		String[] text = new String[str.countTokens()];
		//토큰 값
		int i = 0;
		while(str.hasMoreTokens()) {
			text[i] = str.nextToken();
			System.out.println(text[i]);
			
			i++;
		}
		//토큰 개수
		System.out.println(str.countTokens());
		
		Arrays.sort(text);
		
		for (String string : text) {
			System.out.println(string);
		}
	}
}
