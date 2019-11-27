package exam_lambda;

import java.util.Arrays;

//예외 사용자 정의
class EmptyStringException extends Exception {
	private static final long serialVersionUID = 3919903693843055634L;

	public EmptyStringException() {
		super("빈 문자열");
	}
}

interface StringFunction2 {
	String[] modify(String str) throws EmptyStringException;
}

public class LambdaExample07 {
	public static void main(String[] args) {
		String cityName = "Korea, Australia, China, Germany, Spain, Turkey";
		
		try {
			StringFunction2 sf = (str) -> {
				if(str.length() == 0)
					throw new EmptyStringException();
				return str.split(",");
			};
			
			String result[] = sf.modify(cityName);
			System.out.println("결과값: " + Arrays.toString(result));
			
			String str2 = "";
			String result2[] = sf.modify(str2);
			System.out.println("결과값:" + Arrays.toString(result2));
		} catch (EmptyStringException e) {
			System.err.println(e.getMessage());
		}
		
	}
}
