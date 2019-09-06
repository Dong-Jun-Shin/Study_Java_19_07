import java.util.Scanner;

//자판기 만들기
public class VendingMachine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		VendingTool vending = new VendingTool();
		int balance;
		int product_num;

		// 1.목록을 만들어 놓는다.(24개)
		//재고 초기화
		vending.setStock();

		// 2.금액을 넣어달라는 안내를 한다.
		balance = vending.setBalance(scan);
		
		while (true) {
			// 상품번호 입력
			vending.setActivation(balance);
			vending.printList(balance);
			product_num = scan.nextInt();

			vending.cleaner();
			
			// 모드 확인
			if (product_num == -100001) {
				// 1.관리자 모드(관리자인지 여부는 100001을 입력하면 재고 추가 및 관리로 진입)
				while(true) {
					System.out.println("-------------------------------------------");
					System.out.println("\t\t관리자 모드");
					System.out.println("-------------------------------------------");
					System.out.println("|1.상품추가 | 2.상품제거 | 3.상품재고추가 | 4.상품재고제거 | 5.끝내기");
					int caseNum = scan.nextInt();
					if(caseNum == 5) {
						break;
					}else {						
						vending.adminMode(scan, caseNum);						
					}
				}
			} else if (product_num == 99) {
				// 2.종료하면 잔액 환불하고 끝내기(잔액을 금액권에 따라 구분해서 환불)
				vending.refund(balance);
				break;

			} else if (product_num > 25) {
				// 3.금액인지 상품인지 검사, 선택한 상품번호 유효성검사, 출력, 처리
				balance += product_num;

			} else if (product_num > 0 && product_num < 25) {
				int[] index = vending.index(product_num);
				int i = index[0];
				int j = index[1];
				
				int[][] qty = vending.getQty();
				char[][] active = vending.getActivation();
				
				// 4.선택한 상품의 재고를 확인 후, 잔액 확인 후, 금액을 차감시키고, 상품을 출력
				if (active[i][j] == 'O') {
					if (qty[i][j] > 0) {
						balance = vending.purchaseGoods(balance, i, j);
						vending.printProduct(balance, i, j);
					} else {
						System.out.println("▶재고가 없습니다. 관리자에게 문의해주세요.");
					}
					
				}else {
					System.out.println("▶잔액이 부족합니다.");
					System.out.println();
					System.out.println();
				}
			} else {
				System.out.println("▶존재하는 상품번호를 입력해주세요.");
				System.out.println();
				System.out.println();
			}
		}
		scan.close();
	}
}
