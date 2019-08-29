package exam_class_basic;

import java.util.Scanner;

public class ScoreTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Score std1 = new Score();
		Score std2 = new Score();
		
		std1.getData(scan);
		std2.getData(scan);
	
		Score.printSet();
		System.out.println(std1.toString());
		System.out.println(std2.toString());
		
		scan.close();
	}
}
