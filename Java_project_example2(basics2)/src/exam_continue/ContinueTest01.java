package exam_continue;

public class ContinueTest01 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 1)
					continue;
				System.out.println("i =" + i + " j =" + j);
			}
		}
		System.out.println("-----------------");
		//for�� ������ �ٲ� ����
		for (int j = 0; j < 1; j++) {
			for (int i = 0; i < 3; i++) {
				System.out.println("i =" + i + " j =" + j);
			}
		}
		System.out.println();
		
		//�󺧰� ��Ƽ���� �̿��� ����
		outer: for(int i = 0; i<3; i++) {
			for(int j =0; j<3; j++) {
				if(j==1)
					continue outer;
				System.out.println("i =" + i + " j =" + j);
			}
		}
		System.out.println("-----------------");
	}
}
