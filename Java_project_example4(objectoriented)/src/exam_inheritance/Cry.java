package exam_inheritance;

//상속하는 슈퍼클래스
public class Cry {
	private int 발갯수;

	public void 셋발갯수(int 발) {
		발갯수 = 발;
	}

	public int 겟발갯수() {
		return 발갯수;
	}

	public void 운다() {
		System.out.println("나는 운다. 이렇게");
	}
}

//상속받은 서브클래스
class cat extends Cry {
	public void 운다() {
		System.out.println("mumu~");
	}
}

class dog extends Cry {
	public void 운다() {
		System.out.println("walwal~");
	}
}
