package exam_inheritance;

//����ϴ� ����Ŭ����
public class Cry {
	private int �߰���;

	public void �¹߰���(int ��) {
		�߰��� = ��;
	}

	public int �ٹ߰���() {
		return �߰���;
	}

	public void ���() {
		System.out.println("���� ���. �̷���");
	}
}

//��ӹ��� ����Ŭ����
class cat extends Cry {
	public void ���() {
		System.out.println("mumu~");
	}
}

class dog extends Cry {
	public void ���() {
		System.out.println("walwal~");
	}
}
