package exam_api_wrapper;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		//Boxing    값  -> 객체
		Integer obj1 = new Integer(100); //정수로 생성
		Integer obj2 = new Integer("200"); //문자열로 생성
		Integer obj3 = Integer.valueOf("300"); //정적메소드를 이용해서 대입 

		//Unboxing	객체 -> 값 변환
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		double value4 = obj1.doubleValue();
		double value5 = obj2.doubleValue();
		double value6 = obj3.doubleValue();

		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		System.out.println(value5);
		System.out.println(value6);
		System.out.println();

		//int
		//자동 Boxing
		Integer obj = 100;
		//Integer obj = new Integer(100);
		System.out.println("value: " + obj.intValue());

		//대입시 자동 Unboxing
		int value = obj;
		//int value = obj.intValue();
		System.out.println("value: " + value);

		//연산시 자동 Unboxing
		int result = obj + 100;
		//int result = obj.intValue()+100;
		System.out.println("result: " + result);
		//int result = obj.intValue()+100;

		//char
		//자동 Boxing
		Character cobj = 100; //d
		//Integer obj = new Integer(100);
		System.out.println("value: " + cobj.charValue());

		//대입시 자동 Unboxing
		Character cvalue = cobj;
		//int value = obj.intValue();
		System.out.println("value: " + cvalue);

		
		String str = "My name is Tom. ";
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
