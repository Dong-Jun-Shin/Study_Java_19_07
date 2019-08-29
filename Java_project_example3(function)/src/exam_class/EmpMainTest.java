package exam_class;

public class EmpMainTest {
	public static void main(String[] args) {
		EmpMain[] p = new EmpMain[3];
		int[] gi = {780000, 450000, 570000};
		
		//기본값 입력
		for (int i = 0; i < p.length; i++) {
			p[i] = new EmpMain(String.format("%s%d", (char)(65+i), 111*(i+1)), gi[i]);
		}

		//출력
		EmpMain.showFrame();
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].toString());
		}
	}
}
