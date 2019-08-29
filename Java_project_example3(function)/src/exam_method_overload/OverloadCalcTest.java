package exam_method_overload;

public class OverloadCalcTest {
	public static void main(String[] args) {
		OverloadCalc calc = new OverloadCalc();
		
		System.out.println("int");
		System.out.println(calc.plus(10, 20));
		System.out.println();
		
		// 'f'������, �Ǽ� �⺻���� double������ �ε��ȴ�.
		System.out.println("float");
		System.out.println(calc.plus(10.99f, 20.88f));
		System.out.println();
		
		System.out.println("double");
		System.out.println(calc.plus(10.99, 20.88));
		System.out.println();
		
		System.out.println("���� ���� �Ű�����");
		System.out.println(calc.plus(10, 20, 10, 40, 30));
		System.out.println();
		
		int[] v = {10, 20, 10, 40, 30};
		System.out.println("�����ּҸ� ���� �ִ� �迭���� -> �Ű�����");
		System.out.println(calc.plus(v));
		System.out.println();
		
		System.out.println("�迭������ �ϰ� �ּҸ� -> �Ű�����");
		System.out.println(calc.plus(new int[] {10, 20, 10, 40, 30}));
		System.out.println();
	}
}
