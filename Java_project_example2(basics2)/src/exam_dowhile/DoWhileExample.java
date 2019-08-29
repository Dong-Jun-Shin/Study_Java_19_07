package exam_dowhile;

import java.util.Scanner;

public class DoWhileExample {
	public static void main(String[] args) {

		// ���� ������̴��� �ѹ��� ����
		int num = 0;
		do {
			System.out.println("num�� ��: " + num);
			num++;
		} while (num < 0);

		System.out.println();

		// 1�������� 10���� ���
		int i = 1;
		do {
			System.out.println(i + " ");
			i++;
		} while (i <= 10);
		System.out.println();

		// 10�������� 1���� ���
		i = 10;
		do {
			System.out.println(i + " ");
			i--;
		} while (i >= 1);
		System.out.println();

		// 1���� 100������ ���� ������ּ���.(do ~ while���� �̿��Ͽ�)
		int sum = 0;
		i = 1;

		do {
			sum += i;
			i++;
		} while (i <= 100);
		System.out.println(sum);
		System.out.println();

		// ����ڿ��� ���� �� ���ڸ� �Է¹޾Ƽ� ����ϰ��� �Ѵ�. �̶� ����� q�� �Է��ϸ� �ȴ�.
		System.out.println("\n�޽����� �Է��ϼ���");
		System.out.println("���α׷��� �����Ϸ��� q�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		String input_string;
		
		do {
			System.out.print(">");
			input_string = scan.nextLine();
			System.out.println(input_string);
		} while (!input_string.equals("q")); 
	      //String�� Ŭ������ �񱳽� '=='�� ����� �� ����.
		  //�׷��� String�� �񱳽� .equals("���� ����")�� ���ش�.
		scan.close();
		
		System.out.println("����Ǿ����ϴ�.");
		System.out.println();
		
		
	    //.equals()�� .contentEquals()�� ����--------------------------	
		//  equals�� (������ ������ ���� && String���� �ƴ���)�� �Ǵ��ؼ� ������ true.
		//  contentEquals�� (������ ������ ����)�� �Ǵ��ؼ� ������ true.
		//	  -���ʿ� String �̿��� Ÿ���� ���� �� ����.
		String compare = "q";
		char compare_c = 'q';
		System.out.println(input_string.equals(compare_c));
		System.out.println(input_string.contentEquals(compare));
		}
}
