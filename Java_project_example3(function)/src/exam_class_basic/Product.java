package exam_class_basic;

public class Product {
	public int pNum;
	public String pName;
	public int pStock;

	public void getData(int pNum, String pName, int pStock) {
		this.pNum = pNum;
		this.pName = pName;
		this.pStock = pStock;
	}

	public void stockPlus(int plus) {
		pStock += plus;
	}

	public int stockMinus(int minus) {
		if(pStock<minus) {
			return 0;
		}
		pStock -= minus;
		
		return pStock;
	}

	public String toString() {
		return "��ǰ��ȣ : " + pNum + "\t��ǰ�� : " + pName + "\t������ : " + pStock;
	}
}
