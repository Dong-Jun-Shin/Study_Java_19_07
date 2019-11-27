package exam_methodRef;

interface StringFunction {
	String modify(String str);
}

public class MethodReference01 {
	//메소드로 람다식을 정의한 형태
//	static String func(String str) {
	//일반 메소드를 만든 형태
	String func(String str) {
		String result = "";
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (c == ',')
				result += " ";
			else
				result += c;
		}
		return result;
	}

	public static void main(String[] args) {
		String cityName = "Korea, Australia, China, Germany, Spain, Turkey";
		//메소드로 정의된 람다식을 호출한 형태
//		StringFunction sf = MethodReference01::func;
		//일반 메소드를 호출한 형태
		new MethodReference01().func(cityName);


//		String str1 = sf.modify(cityName);
//		System.out.println(str1);

		String str2 = "서울, 도쿄, 뉴욕, 발리";
//		str1 = sf.modify(str2);
//		System.out.println(str1);

	}
}
