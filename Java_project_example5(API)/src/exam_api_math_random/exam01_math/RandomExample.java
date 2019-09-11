package exam_api_math_random.exam01_math;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 6자리 1 ~ 45 중 난수를 받아, 6개가 모두 맞을 때까지 반복해서 돌리기
 */
public class RandomExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean repeatBool = true;
		while (repeatBool) {
			//당첨 번호 정하기
			int[] answerNum = new int[6];
			Random ranNum = new Random();
			for (int i = 0; i < answerNum.length; i++) {
				answerNum[i] = ranNum.nextInt(45) + 1;
				for (int j = 0; j < i; j++) {
					if(answerNum[i] == answerNum[j]) {
						i--;
						break;
					}
				}
			}

			//선택 번호 받기
			String inputStr = "15 21 16 17 34 28";
			System.out.print("선택 번호: " + inputStr + "\n");
			//String uNum = scan.nextLine();

			System.out.println("당첨 번호: " + Arrays.toString(answerNum));

			//입력 받은 번호를 나누어 배열로 가공
			StringTokenizer strTk = new StringTokenizer(inputStr, " ");
			int[] inputNum = new int[strTk.countTokens()];
			int i = 0;
			while (strTk.hasMoreElements()) {
				inputNum[i] = Integer.parseInt(strTk.nextToken());
				i++;
			}

			//비교할 숫자들 정렬
			Arrays.sort(answerNum);
			Arrays.sort(inputNum);
			
			//비교 판단 방법1
//			boolean result = Arrays.equals(answer, uNumArrays);
//			if(result) {
//				System.out.println("1등에 당첨되셨습니다.");
//			}else {
//				System.out.println("당첨되지 않았습니다.");
//			}
			
			//비교 판단 방법2
			i = 0;
			for (int j = 0 ; i < inputNum.length; i++) {
				if (answerNum[i] == inputNum[i]) {
					j++;
				}
				if(j == 6) {
					System.out.println("1등에 당첨되셨습니다.");
					scan.close();

					return;
				}
			}
			System.out.println("당첨되지 않았습니다.");
		}
		scan.close();
	}
}
