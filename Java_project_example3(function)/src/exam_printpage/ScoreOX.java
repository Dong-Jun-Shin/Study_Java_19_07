package exam_printpage;

public class ScoreOX {
	private int no; //번호
	private String name; //이름
	private int[] dap; //입력한 답
	private int cnt; //맞는 개수
	private int score; //점수
	private int rank; //순위
	private char[] c_ox; // o,x 저장변수
	public static int tot; //전체 맞는 정답 수

	public ScoreOX() {
		this(0, null, null);
		this.c_ox = new char[5];
	}

	public ScoreOX(int no, String name, int[] dap) {
		this.no = no;
		this.name = name;
		this.dap = dap;
		this.c_ox = new char[5];
	}

	public void compute() {
		final int[] solution = { 1, 1, 1, 1, 1 };
		for (int i = 0; i < solution.length; i++) {
			if (dap[i] == solution[i]) {
				c_ox[i] = 'O';
				++cnt;
			} else {
				c_ox[i] = 'X';
			}
		}

		score = cnt * 20;
		tot += cnt;
	}

	public void display() {
		System.out.printf("%2d\t%3s", no, name);
		
		for (int i = 0; i < c_ox.length; i++) {
			System.out.printf("\t%1s", c_ox[i]);
		}
		
		System.out.printf("\t%3d\t%2d\n", score, rank);
	}

	public static void ranking(ScoreOX[] sc) {
		for (int i = 0; i < sc.length; i++) {
			sc[i].rank++;
			for (int j = 0; j < sc.length; j++) {
				if (i == j) {
					continue;
				}

				if (sc[i].score < sc[j].score) {
					sc[i].rank++;
				}
			}
		}
	}
}
