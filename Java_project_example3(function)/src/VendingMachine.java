import java.util.Scanner;
import tool.VendingTool;

//���Ǳ� �����
public class VendingMachine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		VendingTool vending = new VendingTool();
		int balance;
		int product_num;

		// 1.����� ����� ���´�.(24��)
		//��� �ʱ�ȭ
		vending.setStock();

		// 2.�ݾ��� �־�޶�� �ȳ��� �Ѵ�.
		balance = vending.setBalance(scan);
		
		while (true) {
			// ��ǰ��ȣ �Է�
			vending.setActivation(balance);
			vending.printList(balance);
			product_num = scan.nextInt();

			vending.cleaner();
			
			// ��� Ȯ��
			if (product_num == -100001) {
				// 1.������ ���(���������� ���δ� 100001�� �Է��ϸ� ��� �߰� �� ������ ����)
				while(true) {
					System.out.println("-------------------------------------------");
					System.out.println("\t\t������ ���");
					System.out.println("-------------------------------------------");
					System.out.println("|1.��ǰ�߰� | 2.��ǰ���� | 3.��ǰ����߰� | 4.��ǰ������� | 5.������");
					int caseNum = scan.nextInt();
					if(caseNum == 5) {
						break;
					}else {						
						vending.adminMode(scan, caseNum);						
					}
				}
			} else if (product_num == 99) {
				// 2.�����ϸ� �ܾ� ȯ���ϰ� ������(�ܾ��� �ݾױǿ� ���� �����ؼ� ȯ��)
				vending.refund(balance);
				break;

			} else if (product_num > 25) {
				// 3.�ݾ����� ��ǰ���� �˻�, ������ ��ǰ��ȣ ��ȿ���˻�, ���, ó��
				balance += product_num;

			} else if (product_num > 0 && product_num < 25) {
				int[] index = vending.index(product_num);
				int i = index[0];
				int j = index[1];
				
				int[][] qty = vending.getQty();
				char[][] active = vending.getActivation();
				
				// 4.������ ��ǰ�� ��� Ȯ�� ��, �ܾ� Ȯ�� ��, �ݾ��� ������Ű��, ��ǰ�� ���
				if (active[i][j] == 'O') {
					if (qty[i][j] > 0) {
						balance = vending.purchaseGoods(balance, i, j);
						vending.printProduct(balance, i, j);
					} else {
						System.out.println("����� �����ϴ�. �����ڿ��� �������ּ���.");
					}
					
				}else {
					System.out.println("���ܾ��� �����մϴ�.");
					System.out.println();
					System.out.println();
				}
			} else {
				System.out.println("�������ϴ� ��ǰ��ȣ�� �Է����ּ���.");
				System.out.println();
				System.out.println();
			}
		}
		scan.close();
	}
}
