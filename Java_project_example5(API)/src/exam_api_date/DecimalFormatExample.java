package exam_api_date;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String[] args) {
		double num = 1234567.482;
		
		//(format 설정) / (정수는 초과분 표시o, 소수는 초과분 표시x - 반올림이 된다.
		print(num, "0.0");				//1234567.5			
		print(num, "000000000.00000");	//001234567.48200	(0표시 o)
		print(num, "#.#");				//1234567.5			
		print(num, "##########.#####");	//1234567.482		(0표시 x)
		print(num, "####.00");			//1234567.48		
		print(num, "\u00A4 #,###");		//￦ 1,234,567		(초과 시, 자리마다 반복적용)
		
	}
	
	private static void print(Number number, String pattern) {
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		String format = decimalFormat.format(number);
		System.out.printf("Number: %f, Pattern %-16s, result:%s\n", number, pattern, format);
	}
}
