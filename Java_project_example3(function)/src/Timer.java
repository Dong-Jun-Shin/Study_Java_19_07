import java.time.LocalDateTime;

public class Timer {
	public static void main(String[] args) {
		int t_s = 0, t_e = 0;
		int st = 0, et = 0;
		int i = 1;
		int second;
		/*
		 * // 1�� Ÿ�̸� LocalDateTime s = LocalDateTime.now(); while (t_s != 1) {
		 * LocalDateTime ms = LocalDateTime.now(); t_s = s.getSecond(); t_e =
		 * ms.getSecond();
		 * 
		 * t_s = t_e - t_s;
		 * 
		 * if (i == 1) { st = (int) System.nanoTime(); } } et = (int) System.nanoTime();
		 * second = et - st;
		 * 
		 * System.out.println("1�ʰ� �������ϴ�.");
		 */
		
		// �ð��� ���
		for (i = 0; i < 10000000; i++) {
			// ���� �ð�
			LocalDateTime s = LocalDateTime.now();
			//while (t_s != 1)�� ������ ���, 
			//(s�� ms�� ��)t_s�� ���� 0->1�� ���Ѵ�.
			// �� ��, ������ ���ؼ� 1�̻��� ������ ���� Ŀ���� �ǰ�,
			//2�� �Ѱ� �Ǿ�, �ʰ� ��µ��� �ʰ� while���� ������ �ȴ�.
			//�׷��� (t_s == 0)�� �����ؼ� ���� 0�̸� �ݺ��ϰ�, �� �ܸ̿�
			//�������� �����. �� ���, ������ ���� �þ������� t_s�� �ٽ� ������ �ȴ�.
			while (t_s == 0) {
				// ���� �ð�
				LocalDateTime ms = LocalDateTime.now();
				// �ʴ���(byte)�� ��ȯ
				t_s = s.getSecond();
				t_e = ms.getSecond();

				// ��� �ð�(��)
				t_s = t_e - t_s;

				if (i == 100) {
					st = (int) System.nanoTime();
				}

			} // �ð��� ���̸� �ʱ�ȭ, ���� ��� �ݺ� ���ǹ��� ��� ���� ���¿��� �� �Ѿ��.
			t_s = 0;
					
			//�ð��� ���
			System.out.println((i + 1) + "��");	
			
		}
		et = (int) System.nanoTime();

		second = et - st;

		System.out.println("--------------------");
		System.out.println(st);
		System.out.println(et);
		System.out.println("--------------------");
		System.out.println(second);
	}
}
