﻿package exam_printpage;

import java.util.Scanner;

public class Account {
	private String ano;
	private String owner;
	private int balance;
	private static int pCount;

	// 생성자
	public Account() {
		this(null, null, 0);
	}

	public String getOwner() {
		return owner;
	}

	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		++pCount;
	}

	// getter, setter
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String owner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public static int getpCount() {
		return pCount;
	}

	// 기능 메소드
	public Account[] createAccount(Scanner scan, Account[] person) {
		menuFrame("계좌생성");

		inputAno(scan);
		inputOwner(scan);
		inputBal(scan);

		person = addArray(person);

		System.out.println("결과: 계좌가 생성되었습니다.");

		return person;
	}

	public Account[] removeAccount(Scanner scan, Account[] person) {
		menuFrame("계좌삭제");

		System.out.print("삭제할 계좌의 순번을 입력해주세요>>");
		int num = scan.nextInt();
		scan.nextLine();

		if (person.length > 1) {
			if (num < person.length) {
				System.out.println("결과: " + person[num - 1].owner + "님의 계좌가 삭제되었습니다.");

				person = removeArray(person, num);
			} else {
				System.out.printf("\n계좌는 %d번째까지 있습니다.\n다시 입력해주세요.\n", person.length - 1);
			}
		} else {
			System.out.println("계좌목록이 비어있습니다.");
		}

		return person;
	}

	public void accountList(Account[] person) {
		menuFrame("계좌목록");
		for (int i = 0; i < person.length - 1; i++) {
			System.out.printf("%20s\t%4s\t%7d\n", person[i].ano, person[i].owner, person[i].balance);
		}
	}

	public void deposit(Scanner scan, Account[] person) {
		menuFrame("예금");
		int indexNum = selAno(scan, person);

		if (indexNum != -1) {
			person[indexNum].balance += person[indexNum].addBal(scan);

			System.out.println("결과: 예금이 되었습니다.");
		} else {
			System.out.println("입력해주신 계좌가 없습니다.");
		}
	}

	public void withdraw(Scanner scan, Account[] person) {
		menuFrame("출금");
		int indexNum = selAno(scan, person);

		if (indexNum != -1) {
			int temp = person[indexNum].subBal(scan);
			if (person[indexNum].balance > temp) {
				person[indexNum].balance -= temp;
				System.out.println("결과: 출금이 되었습니다.");
			} else {
				System.out.println("결과: 계좌에 잔액이 부족합니다.");
			}
		} else {
			System.out.println("입력해주신 계좌가 없습니다.");
		}

	}

	// 출력 메소드
	public static void showFrame() {
		System.out.println("-------------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌삭제 | 3.계좌목록 | 4.예금 | 5.출금 | 6.종료");
		System.out.println("-------------------------------------------------");
		System.out.print("선택>");
	}

	public static void menuFrame(String menu) {
		System.out.println("------------");
		System.out.println(menu);
		System.out.println("------------");
	}

	// 입력 메소드
	public String inputAno(Scanner scan) {
		System.out.print("계좌번호: ");
		ano = scan.nextLine();

		return ano;
	}

	public String inputOwner(Scanner scan) {
		System.out.print("계좌주: ");
		owner = scan.nextLine();

		return owner;
	}

	public int inputBal(Scanner scan) {
		while (true) {
			System.out.print("초기입금액: ");
			balance = scan.nextInt();
			scan.nextLine();

			if (balance >= 0) {
				break;
			}
			System.out.println("개설시, 최소 시작금액은 1000원입니다.");
			System.out.println("1000원 이상 입력해주세요.");
		}

		return balance;
	}

	public int addBal(Scanner scan) {
		int addBal;
		while (true) {
			System.out.print("예금액: ");
			addBal = scan.nextInt();
			scan.nextLine();

			if (balance >= 0 && addBal > 0) {
				break;
			}
			System.out.println("숫자를 정수로 입력해주세요.");
		}

		return addBal;
	}

	public int subBal(Scanner scan) {
		int subBal;
		while (true) {
			System.out.print("출금액: ");
			subBal = scan.nextInt();
			scan.nextLine();

			if (balance >= 0 && subBal > 0) {
				break;
			}
			System.out.println("숫자를 정수로 입력해주세요.");
		}

		return subBal;
	}

	// 부가 메소드
	public Account[] addArray(Account[] person) {
		//새로 받을 배열 초기화
		Account[] temp = new Account[person.length + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = new Account();
		}

		//새로 받은 배열에 대입
		for (int i = 0; i < temp.length - 1; i++) {
			temp[i] = person[i];
		}

		return temp;
	}

	public Account[] removeArray(Account[] person, int selArray) {
		//새로 받을 배열 초기화
		Account[] temp = new Account[person.length - 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = new Account();
		}

		//해당 값 삭제하기
		for (int i = 0; i < temp.length; i++) {
			if (i == selArray - 1) {
				continue;
			}
			temp[i] = person[i];
		}

		//공백 땡겨서 줄 맞추기
		for (int i = 0, j = 0; j < temp.length; i++, j++) {
			if (temp[i].ano == null) {
				temp[i] = person[++j];
				continue;
			}
			temp[i] = person[j];
			if (j == temp.length - 1) {
				temp[j] = new Account();
			}
		}

		return temp;
	}

	public int selAno(Scanner scan, Account[] person) {
		System.out.print("계좌번호: ");
		String index = scan.nextLine();

		int indexNum = -1;

		for (int i = 0; i < person.length; i++) {
			if (person[i].ano != null && person[i].ano.equals(index)) {
				indexNum = i;
				break;
			}
		}

		return indexNum;
	}

}
