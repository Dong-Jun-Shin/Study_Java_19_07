package exam_exception;

public class RuntimeException {
	public static void main(String[] args) {
		// RuntimeException 종류 - 비체크 예외.
		// ArrayIndexOutOfBoundsExxception 예외 발생
		try {
			int[] arr = new int[3];
			arr[4] = 20;
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		//ClassCastException 예외 발생 - 타입 변환이 되지 않은 상태
		try {
			Object x = new Integer(0);
			// 부모 클래스명 참조변수 = new 서브클래스생성자();
			System.out.println((String)x);
		}catch(ClassCastException e) {
			e.printStackTrace();
		}
		
		// NegativeArraySizeException 예외 발생
		try {
			int[] arr = new int[-10];
			System.out.println(arr.toString());
		}catch(NegativeArraySizeException e) {
			e.printStackTrace();
		}catch(Exception e) {
			
		}
		
		
		// NullPointerException 예외 발생 - 객체 참조가 없는 상태
		try {
			String str = null;
			@SuppressWarnings("null")
			int len = str.length();
			System.out.println(len);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		// NumberFormatException 예외 발생
		try {
			String data1 = "100";
			String data2 = "a100";
			
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" + result);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
