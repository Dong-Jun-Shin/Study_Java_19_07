package exam_lambda;

interface StringFunction {
	String modify(String str);
}

public class LambdaExample06 {
	static String test(StringFunction sf, String str) {
		return sf.modify(str);
	}

	public static void main(String[] args) {
		String cityName = "Korea, Australia, China, Germany, Spain, Turkey";
		StringFunction sf1 = (s) -> {
			String result = "";
			char c;
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (c == ',')
					result += " ";
				else
					result += c;
			}
			return result;
		};

		// 첫번째 방법
		String str1 = test(sf1, cityName);
		System.out.println(str1);
		// 두번째 방법
//		String str2 = test((str) -> {
//			String result = "";
//			char c;
//			for (int i = 0; i < str.length(); i++) {
//				c = str.charAt(i);
//				if(c ==',')
//					result += " ";
//				else
//					result += c;
//			}
//			return result;
//		}, cityName);

		String str2 = test((s) -> {
			int max = 0;
			int index = 0;
			String[] word = s.split(",");
			for (int i = 0; i < word.length; i++) {
				if (max < word[i].length()) {
					max = word[i].length();
					index = i;
				}
			}

			return word[index];
		}, cityName);
		System.out.println(str2);
	}
}