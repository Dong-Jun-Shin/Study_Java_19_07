class �л�{
	public int �� = (int)((Math.random()*50000)+1)/10*10;
	public int ���� = 100; 
}

class ���ġ{
	private int ��  = 0;
	private int ���� = 100;
	public static int ���� = 0;
	
	public static void �θ���() {
		System.out.println("��, �̸��ͺ�");
	}
	
	public static void ����(�л� �л�) {
		System.out.println("�� �ֳ�");
		System.out.println(�л�.�� +"�� Ȯ���ߴ�.");
		
		
	}
	
	public static void ����̱�() {
		System.out.println("������(+2)");
	}
	
	public static void ������(int ����Ƚ��) {
		for (int �ݺ�Ƚ�� = 0; �ݺ�Ƚ�� < ����Ƚ��; �ݺ�Ƚ��++) {
			if(�ݺ�Ƚ��%3 == 0) {
				System.out.print("��Ÿ ġ��Ÿ(-2)  ");
			}
			System.out.println("��(-1)  ");		
		}
	}
}

public class ��ϱ�{
	public static void main(String[] args) {
		
		if(���ġ.���� == 1) {
			System.out.println("��� �����Ѵ�.");
			
		}
	}
}