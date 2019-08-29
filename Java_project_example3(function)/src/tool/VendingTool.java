package tool;

import java.util.Scanner;

public class VendingTool {
	private String[][] product = this.setProduct();
	private int[][] price = this.setPrice();
	private int[][] qty = new int[product.length][product[0].length];
	private char[][] activation = new char[product.length][product[0].length];

	//Ŭ���� �� �޼ҵ�
	//TODO  1st
	//		(�̸�, ���) (���� ��������� ������ ��� �����ϱ�)
	public String[][] setProduct() {
		String[][] object = { { "��ī�ݶ�(PET)", "��ī�ݶ�(PET)", "��������Ʈ(PET)", "ȯŸ(������)(PET)", "��ī�ݶ�(CAN)", "��ī�ݶ�(CAN)" }, { "�̴ָ��̵�(����)(CAN)", "�̴ָ��̵�(����)(CAN)", "�Ϲٻ�(PET)", "���̽�Ƽ(������)(PET)", "������(PET)", "����(PET)" }, { "�Ŀ����̵�(���)(PET)", "�̴ָ��̵�(������)(PET)", "��Ű��Ʈ(����)(PET)", "��Ű��Ʈ(�ڸ�)(PET)", "������(���ڳ�)(CAN)", "������(���ڳ�)(CAN)" }, { "����(CAN)", "����(CAN)", "��������(CAN)", "��������(CAN)", "�����̵�(CAN)", "�����̵�(CAN)" } };

		return object;
	}

	public int[][] setPrice() {
		int[][] object = { { 1200, 1200, 1000, 1000, 1000, 1000 }, { 900, 900, 1000, 1200, 1200, 900 }, { 1200, 1200, 1200, 1200, 900, 900 }, { 900, 900, 1000, 1000, 1000, 1000 } };

		return object;
	}

	public void setStock() {
		//��� �ʱ�ȭ
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
			//��ǰ�� ���
			for (int j = 0; j < product[i].length; j++) {
				if (product[i][j].length() < 10) {
					System.out.printf("|%2d. %-9s\t\t", num++, product[i][j]);
				} else {
					System.out.printf("|%2d. %-10s\t", num++, product[i][j]);
				}
			}
			System.out.println();

			//��ǰ�� ���
			for (int j = 0; j < product[i].length; j++) {
				System.out.printf("|%10d\t\t", price[i][j]);
			}
			System.out.println();

			//���԰��ɿ��� ���
			for (int j = 0; j < product[i].length; j++) {
				System.out.printf("|\t%-10s\t", activation[i][j]);
			}
			System.out.println();
			System.out.println();

		}
	}

	public void vendingListAdmin() {
		for (int i = 0, num = 1; i < product.length; i++) {
			//��ǰ�� ���
			for (int j = 0; j < product[i].length; j++) {
				if (product[i][j].length() < 10) {
					System.out.printf("|%2d. %-9s\t\t", num++, product[i][j]);
				} else {
					System.out.printf("|%2d. %-10s\t", num++, product[i][j]);
				}
			}
			System.out.println();

			//��ǰ�� ���
			for (int j = 0; j < product[i].length; j++) {
				System.out.printf("|%10d\t\t", price[i][j]);
			}
			System.out.println();

			//��� ���
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
				System.out.println("��ȿ�� �ڸ� ��ȣ�� �ٽ� �Է����ּ���.");
			}
		}

		return num;
	}

	public void setData(Scanner scan, int i, int j) {
		System.out.print("��ǰ�� : ");
		product[i][j] = scan.nextLine();

		System.out.print("���� : ");
		while (true) {
			price[i][j] = scan.nextInt();
			scan.nextLine();

			if (price[i][j] >= 0) {
				break;
			}else {
				System.out.println("������ ������ �Է��� �� �����ϴ�. �ٽ� �Է����ּ���.");
			}
		}

		System.out.print("��� : ");
		while (true) {
			qty[i][j] = scan.nextInt();
			scan.nextLine();

			if (qty[i][j] >= 0) {
				break;
			}else {
				System.out.println("���� ������ �Է��� �� �����ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	public void delData(int i, int j) {
		product[i][j] = "";
		price[i][j] = 0;
		qty[i][j] = 0;
	}

	public int addStock(Scanner scan, int i, int j) {
		System.out.print("�߰��� ��� : ");
		int num;
		while (true) {
			num = scan.nextInt();
			scan.nextLine();

			if (num > 0) {
				break;
			}else {
				System.out.println("�߰��� ������ �Է����ּ���.");
			}
		}
		qty[i][j] += num;

		return num;
	}

	public int subStock(Scanner scan, int i, int j) {
		System.out.print("������ ��� : ");
		int num = 0;
		if (qty[i][j] > 0) {
			while (true) {
				num = scan.nextInt();
				scan.nextLine();

				if (num > 0) {
					break;
				}else {
					System.out.println("�� ������ �Է����ּ���.");
				}
			}
			qty[i][j] -= num;
		} else {
			System.out.println("�� ��� �����ϴ�.");
		}

		return num;
	}

	private void productAdd(Scanner scan) {
		String guide = "��ǰ�� �߰��� �ڸ���ȣ�� �Է����ּ���>>";

		int num = selProduct(scan, guide);
		int[] index = index(num);
		int i = index[0];
		int j = index[1];

		if (product[i][j] == "") {
			System.out.println("��ǰ��, ����, ��� �Է����ּ���>>");
			setData(scan, i, j);
			cleaner();
			System.out.printf("�� %s��(��) �߰��Ǿ����ϴ�.\n", product[i][j]);
		} else {
			cleaner();
			System.out.println("���ش� �ڸ��� �ٸ� ��ǰ�� �ֽ��ϴ�.");

		}
	}

	private void productRemove(Scanner scan) {
		String guide = "��ǰ�� ������ �ڸ���ȣ�� �Է����ּ���>>";

		int num = selProduct(scan, guide);
		int[] index = index(num);
		int i = index[0];
		int j = index[1];

		guide = product[i][j];
		delData(i, j);
		cleaner();
		System.out.printf("�� %s��(��) �����Ǿ����ϴ�.\n", guide);
	}

	private void stockAdd(Scanner scan) {
		String guide = "��� �߰��� ��ǰ�� �ڸ���ȣ�� �Է����ּ���>>";

		int num = selProduct(scan, guide);
		int[] index = index(num);
		int i = index[0];
		int j = index[1];

		num = addStock(scan, i, j);
		cleaner();
		System.out.printf("��%d(��)�� �����߽��ϴ�.\n", num);
		System.out.printf(" %s�� ���� ���� %d(��)�Դϴ�.\n", product[i][j], qty[i][j]);
	}

	private void stockSub(Scanner scan) {
		String guide = "��� �� ��ǰ�� �ڸ���ȣ�� �Է����ּ���>>";

		int num = selProduct(scan, guide);
		int[] index = index(num);
		int i = index[0];
		int j = index[1];

		num = subStock(scan, i, j);
		cleaner();
		System.out.printf("��%d(��)�� �����߽��ϴ�.\n", num);
		System.out.printf("�� %s�� ���� ���� %d(��)�Դϴ�.\n", product[i][j], qty[i][j]);
	}

	//Ŭ���� �� �޼ҵ�

	public int[][] getQty() {
		return qty;
	}

	public char[][] getActivation() {
		return activation;
	}

	public int setBalance(Scanner scan) {
		int balance;
		System.out.print("���ݾ��� �־��ּ���. ");
		balance = scan.nextInt();

		return balance;
	}

	public void printList(int balance) {
		System.out.println("-------------------------------------------");
		System.out.println("����ǰ��ȣ�� �Է����ּ���. (���Ե� �ݾ� : " + balance + "��)");
		System.out.println("-------------------------------------------");
		vendingList();
		System.out.println("-------------------------------------------");
		System.out.println("(�ݾ��� �߰� �����Ͻ÷��� �ݾ��� �Է��ϼ���. (100�� ����)");
		System.out.println("(�ܾ��� ȯ���ϰ� �����Ϸ��� '99'�� �����ּ���.)");
	}

	public void cleaner() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	public void adminMode(Scanner scan, int caseNum) {
		//�� ������ ���
		switch (caseNum) {
		case 1:
			//��ǰ �߰�			
			productAdd(scan);
			break;
		case 2:
			//��ǰ����
			productRemove(scan);
			break;
		case 3:
			//��ǰ ��� �߰�
			stockAdd(scan);
			break;
		case 4:
			//��ǰ ��� ����
			stockSub(scan);
			break;
		}
	}

	public void refund(int balance) {
		this.cleaner();
		System.out.println("-------------------------------------------");
		System.out.println("���ܾ� :" + balance + "���� ��ȯ�ƽ��ϴ�.");
		System.out.println("-------(�ݾ׺� ��ȯ ����)-------");
		System.out.printf("50000�� : %d��\n", balance / 50000);
		System.out.printf("10000�� : %d��\n", (balance % 50000) / 10000);
		System.out.printf(" 5000�� : %d��\n", (balance % 10000) / 5000);
		System.out.printf(" 1000�� : %d��\n", (balance % 5000) / 1000);
		System.out.printf("  500�� : %d��\n", (balance % 1000) / 500);
		System.out.printf("  100�� : %d��\n", (balance % 500) / 100);
		System.out.printf("   50�� : %d��\n", (balance % 100) / 50);
		System.out.printf("   10�� : %d��\n", (balance % 50) / 10);
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
		System.out.println("��ǰ�� : " + product[i][j] + "\n���� : " + price[i][j] + "��, ��� : " + qty[i][j]);
		System.out.println("-------------------------------------------");
		System.out.println(product[i][j] + "��(��) ���Խ��ϴ�.");
		System.out.println("�ܾ� : " + balance);
		System.out.println();
	}
}