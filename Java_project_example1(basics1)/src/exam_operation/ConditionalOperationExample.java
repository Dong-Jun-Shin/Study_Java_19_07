package exam_operation;

public class ConditionalOperationExample {
	public static void main(String[] args) {

		int x = 100;
		int y = 200;

		int result = ((x > y) ? x : y);

		System.out.print("두 수(100과 200) 중에서 최대값 : " + result);

		char even = '짝';
		char odd = '홀';

		result = ((result % 2 == 0) ? even : odd);
		System.out.println(", (" + (char)result + ")");
		
		//TODO 교안 비교하기
	}
}