package exam_inheritance;

public class animal {
	public static void main(String[] args) {
		cat 냥 = new cat();
		dog 멍 = new dog();
		
		냥.셋발갯수(4);
		냥.운다();
		System.out.println(냥.겟발갯수());
		
		멍.셋발갯수(5);
		멍.운다();
		System.out.println(멍.겟발갯수());
		
	}
}
