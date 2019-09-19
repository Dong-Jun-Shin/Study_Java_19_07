package exam_inner_class;

class OverMemberO {
	public int num;

	public OverMemberO() {
		this.num = 100;
	}

	class OverMemberI {
		int num = 200;

		public void method() {
			int num = 300;
			int localNum = num;
			System.out.println("localNum = " + localNum);
			//내부클래스의  num을 접근
			int innerNum = /*OverMemberI.*/this.num;
			System.out.println("innerNum = " + innerNum);
			//외부클래스의 num을 접근
			int outerNum = OverMemberO.this.num;
			System.out.println("outerNum = " + outerNum);
		}
	}
}
