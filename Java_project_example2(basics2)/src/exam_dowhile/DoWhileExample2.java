package exam_dowhile;

/*
 * do ~ while���� �̿��Ͽ� 'a'���� 'z'���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
public class DoWhileExample2 {
	public static void main(String[] args) {
		// char�� �̿��ؼ� ���
		// a: 97, z: 122
		char ch = 97;

		do {
			System.out.print(ch + " ");
			ch++; 
			//ch = ch + 1; �ۼ���, char = int ���̶� ����ȯ�� �ʿ�
			//ch = (char)ch + 1;
			
		} while (ch <= 122);
		
		/* �ƽ�Ű�ڵ� ���� �ƴ� ���ڷ� �ۼ��ϱ�
			char ch = 'a';
	
			do {
				System.out.print(ch + " ");
				ch++;
			} while (ch <= 'z');
		*/
		
	}
}
