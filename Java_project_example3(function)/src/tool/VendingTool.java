package tool;

import java.util.Scanner;

public class VendingTool {
	private String[][] product = this.setProduct();
	private int[][] price = this.setPrice();
	private int[][] qty = new int[product.length][product[0].length];
	private char[][] activation = new char[product.length][product[0].length];

	//클래스 내 메소드
	//TODO  1st
	//		(이름, 재고) (파일 입출력으로 재고관리 기능 구현하기)
	public String[][] setProduct() {
		String[][] object = { { "코카콜라(PET)", "코카콜라(PET)", "스프라이트(PET)", "환타(오렌지)(PET)", "코카콜라(CAN)", "코카콜라(CAN)" }, { "미닛메이드(망고)(CAN)", "미닛메이드(망고)(CAN)", "암바사(PET)", "아이스티(복숭아)(PET)", "마테차(PET)", "생수(PET)" }, { "파워에이드(블루)(PET)", "미닛메이드(오렌지)(PET)", "썬키스트(라임)(PET)", "썬키스트(자몽)(PET)", "코코팜(코코넛)(CAN)", "코코팜(코코넛)(CAN)" }, { "식혜(CAN)", "식혜(CAN)", "닥터페퍼(CAN)", "닥터페퍼(CAN)", "레몬에이드(CAN)", "레몬에이드(CAN)" } };

		return object;
	}

	public int[][] setPrice() {
		int[][] object = { { 1200, 1200, 1000, 1000, 1000, 1000 }, { 900, 900, 1000, 1200, 1200, 900 }, { 1200, 1200, 1200, 1200, 900, 900 }, { 900, 900, 1000, 1000, 1000, 1000 } };

		return object;
	}

	public void setStock() {
		//재고 초기화
		for (int i = 0; i < qty.length; i++) {
			for (int j = 0; j < qty[i].length; j++) {
				qty[i][j] = 5;
			}
		}

		for (int i = 0; i < activation.length; i++) {
			for (int j = 0; j < activation[i].length; j++) {
				activation[i][j] = 'O';
			}
		}
	}

	public void setActivation(int balance) {
		for (int i = 0; i < activation.length; i++) {
			for (int j = 0; j < activation[i].length; j++) {
				if (price[i][j] > balance || price[i][j] == 0) {
					activation[i][j] = 'X';
				} else {
					activation[i][j] = 'O';
				}
			}
		}

	}

	public void vendingList() {
		for (int i = 0, num = 1; i < product.length; i++) {
			//제품명 출력
			for (int j = 0; j < product[i].length; j++) {
				if (product[i][j].length() < 10) {
					System.out.printf("|%2d. %-9s\t\t", num++, product[i][j]);
				} else {
					System.out.printf("|%2d. %-10s\t", num++, product[i][j]);
				}
			}
			System.out.println();

			//제품명 출력
			for (int j = 0; j < product[i].length; j++) {
				System.out.printf("|%10d\t\t", price[i][j]);
			}
			System.out.println();

			//구입가능여부 출력
			for (int j = 0; j < product[i].length; j++) {
				System.out.printf("|\t%-10s\t", activation[i][j]);
			}
			System.out.println();
			System.out.println();

		}
	}

	public void vendingListAdmin() {
		for (int i = 0, num = 1; i < product.length; i++) {
			//제품명 출력
			for (int j = 0; j < product[i].length; j++) {
				if (product[i][j].length() < 10) {
					System.out.printf("|%2d. %-9s\t\t", num++, product[i][j]);
				} else {
					System.out.printf("|%2d. %-10s\t", num++, product[i][j]);
				}
			}
			System.out.println();

			//제품명 출력
			for (int j = 0; j < product[i].length; j++) {
				System.out.printf("|%10d\t\t", price[i][j]);
			}
			System.out.println();

			//재고 출력
			for (int j = 0; j < product[i].length; j++) {
				System.out.printf("|\t%10d\t", qty[i][j]);
			}
			System.out.println();
			System.out.println();

		}
	}

	private int selProduct(Scanner scan, String guide) {
		System.out.println("-------------------------------------------");
		vendingListAdmin();
		System.out.println("-------------------------------------------");
		System.out.print(guide);
		int num;
		while (true) {
			num = scan.nextInt();
			scan.nextLine();

			if (num > 0 && num < 25) {
				break;
			} else {
				System.out.println("유효한 자리 번호를 다시 입력해주세요.");
			}
		}

		return num;
	}

	public void setData(Scanner scan, int i, int j) {
		System.out.print("상품명 : ");
		product[i][j] = scan.nextLine();

		System.out.print("가격 : ");
		while (true) {
			price[i][j] = scan.nextInt();
			scan.nextLine();

			if (price[i][j] >= 0) {
				break;
			}else {
				System.out.println("가격은 음수로 입력할 수 없습니다. 다시 입력해주세요.");
			}
		}

		System.out.print("재고 : ");
		while (true) {
			qty[i][j] = scan.nextInt();
			scan.nextLine();

			if (qty[i][j] >= 0) {
				break;
			}else {
				System.out.println("재고는 음수로 입력할 수 없습니다. 다시 입력해주세요.");
			}
		}
	}

	public void delData(int i, int j) {
		product[i][j] = "";
		price[i][j] = 0;
		qty[i][j] = 0;
	}

	public int addStock(Scanner scan, int i, int j) {
		System.out.print("추가할 재고량 : ");
		int num;
		while (true) {
			num = scan.nextInt();
			scan.nextLine();

			if (num > 0) {
				break;
			}else {
				System.out.println("추가할 개수를 입력해주세요.");
			}
		}
		qty[i][j] += num;

		return num;
	}

	public int subStock(Scanner scan, int i, int j) {
		System.out.print("감소할 재고량 : ");
		int num = 0;
		if (qty[i][j] > 0) {
			while (true) {
				num = scan.nextInt();
				scan.nextLine();

				if (num > 0) {
					break;
				}else {
					System.out.println("뺄 개수를 입력해주세요.");
				}
			}
			qty[i][j] -= num;
		} else {
			System.out.println("뺄 재고가 없습니다.");
		}

		return num;
	}

	private void productAdd(Scanner scan) {
		String guide = "상품을 추가할 자리번호를 입력해주세요>>";

		int num = selProduct(scan, guide);
		int[] index = index(num);
		int i = index[0];
		int j = index[1];

		if (product[i][j] == "") {
			System.out.println("상품명, 가격, 재고를 입력해주세요>>");
			setData(scan, i, j);
			cleaner();
			System.out.printf("▶ %s이(가) 추가되었습니다.\n", product[i][j]);
		} else {
			cleaner();
			System.out.println("▶해당 자리에 다른 상품이 있습니다.");

		}
	}

	private void productRemove(Scanner scan) {
		String guide = "상품을 삭제할 자리번호를 입력해주세요>>";

		int num = selProduct(scan, guide);
		int[] index = index(num);
		int i = index[0];
		int j = index[1];

		guide = product[i][j];
		delData(i, j);
		cleaner();
		System.out.printf("▶ %s이(가) 삭제되었습니다.\n", guide);
	}

	private void stockAdd(Scanner scan) {
		String guide = "재고를 추가할 상품의 자리번호를 입력해주세요>>";

		int num = selProduct(scan, guide);
		int[] index = index(num);
		int i = index[0];
		int j = index[1];

		num = addStock(scan, i, j);
		cleaner();
		System.out.printf("▶%d(개)가 증가했습니다.\n", num);
		System.out.printf(" %s의 남은 재고는 %d(개)입니다.\n", product[i][j], qty[i][j]);
	}

	private void stockSub(Scanner scan) {
		String guide = "재고를 뺄 상품의 자리번호를 입력해주세요>>";

		int num = selProduct(scan, guide);
		int[] index = index(num);
		int i = index[0];
		int j = index[1];

		num = subStock(scan, i, j);
		cleaner();
		System.out.printf("▶%d(개)가 감소했습니다.\n", num);
		System.out.printf("▶ %s의 남은 재고는 %d(개)입니다.\n", product[i][j], qty[i][j]);
	}

	//클래스 외 메소드

	public int[][] getQty() {
		return qty;
	}

	public char[][] getActivation() {
		return activation;
	}

	public int setBalance(Scanner scan) {
		int balance;
		System.out.print("▶금액을 넣어주세요. ");
		balance = scan.nextInt();

		return balance;
	}

	public void printList(int balance) {
		System.out.println("-------------------------------------------");
		System.out.println("▶상품번호를 입력해주세요. (투입된 금액 : " + balance + "원)");
		System.out.println("-------------------------------------------");
		vendingList();
		System.out.println("-------------------------------------------");
		System.out.println("(금액을 추가 투입하시려면 금액을 입력하세요. (100원 단위)");
		System.out.println("(잔액을 환불하고 종료하려면 '99'를 눌러주세요.)");
	}

	public void cleaner() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	public void adminMode(Scanner scan, int caseNum) {
		//각 관리자 기능
		switch (caseNum) {
		case 1:
			//상품 추가			
			productAdd(scan);
			break;
		case 2:
			//상품제거
			productRemove(scan);
			break;
		case 3:
			//상품 재고 추가
			stockAdd(scan);
			break;
		case 4:
			//상품 재고 제거
			stockSub(scan);
			break;
		}
	}

	public void refund(int balance) {
		this.cleaner();
		System.out.println("-------------------------------------------");
		System.out.println("▶잔액 :" + balance + "원이 반환됐습니다.");
		System.out.println("-------(금액별 반환 개수)-------");
		System.out.printf("50000원 : %d장\n", balance / 50000);
		System.out.printf("10000원 : %d장\n", (balance % 50000) / 10000);
		System.out.printf(" 5000원 : %d장\n", (balance % 10000) / 5000);
		System.out.printf(" 1000원 : %d장\n", (balance % 5000) / 1000);
		System.out.printf("  500원 : %d개\n", (balance % 1000) / 500);
		System.out.printf("  100원 : %d개\n", (balance % 500) / 100);
		System.out.printf("   50원 : %d개\n", (balance % 100) / 50);
		System.out.printf("   10원 : %d개\n", (balance % 50) / 10);
	}

	public int[] index(int product_num) {
		int[] index = new int[2];
		index[0] = (product_num - 1) / 6;
		index[1] = (product_num - 1) % 6;

		return index;
	}

	public int purchaseGoods(int balance, int i, int j) {
		balance -= price[i][j];
		qty[i][j] -= 1;

		return balance;
	}

	public void printProduct(int balance, int i, int j) {
		System.out.println("-------------------------------------------");
		System.out.println("상품명 : " + product[i][j] + "\n가격 : " + price[i][j] + "원, 재고 : " + qty[i][j]);
		System.out.println("-------------------------------------------");
		System.out.println(product[i][j] + "이(가) 나왔습니다.");
		System.out.println("잔액 : " + balance);
		System.out.println();
	}
}