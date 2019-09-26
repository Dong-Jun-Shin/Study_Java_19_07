package exam_collection_set;

public class Score implements Comparable<Score> {
	private int lang;
	private int math;

	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Score(int lang, int math) {
		super();
		this.lang = lang;
		this.math = math;
	}

	public int getLang() {
		return lang;
	}

	public void setLang(int lang) {
		this.lang = lang;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return this.lang + this.math;
	}

	@Override
	public String toString() {
		return "Score [국어: "+ this.lang + ", " + "수학: "+ this.math + ", " + "총점: "+getSum()+"]";
	}

	@Override
	public int compareTo(Score o) {
		int tot = getSum();
		int oTot = o.getSum();
		if (tot > oTot) {
			return 1;
		} else if (tot == oTot) {
			return 0;
		} else {
			return -1;
		}
	}
}
