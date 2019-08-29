package exam_dowhile;

/*
 * do ~ while문을 이용하여 'a'부터 'z'까지 출력하는 프로그램을 작성하시오.
 */
public class DoWhileExample2 {
	public static void main(String[] args) {
		// char을 이용해서 출력
		// a: 97, z: 122
		char ch = 97;

		do {
			System.out.print(ch + " ");
			ch++; 
			//ch = ch + 1; 작성시, char = int 형이라서 형변환이 필요
			//ch = (char)ch + 1;
			
		} while (ch <= 122);
		
		/* 아스키코드 값이 아닌 문자로 작성하기
			char ch = 'a';
	
			do {
				System.out.print(ch + " ");
				ch++;
			} while (ch <= 'z');
		*/
		
	}
}
