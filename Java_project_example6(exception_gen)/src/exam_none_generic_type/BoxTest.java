package exam_none_generic_type;

class Box{
	private Object data;
	
	public void set(Object data) {
		this.data = data;
	}
	
	public Object get() {
		return data;
	}
}

public class BoxTest {
	public static void main(String[] args) {
		Box s = new Box();
		//String
		s.set("aa");
		System.out.println(s.get());
		//int
		s.set(123);
		System.out.println(s.get());
		//char
		s.set('g');
		System.out.println(s.get());
		//double
		s.set(12.34);
		System.out.println(s.get());
		//Box
		s.set(s);
		System.out.println(s.get());
		System.out.println();
		
		Object c = s.get();
		((Box) c).set("aaa");
		System.out.println(((Box) c).get());
		
		
		//String
		System.out.println();
		String str = new String("aa");
		s.set(str); //오토언박싱
		System.out.println(s.get());
		String name = (String)s.get();
		System.out.println(name); //오토언박싱
		
		//Integer
		Integer in = new Integer(123);
		s.set(in); //오토언박싱
		System.out.println(s.get());
		Integer num = (Integer)s.get();
		System.out.println(num.intValue()); //오토언박싱
		
		//Double
		Double dou = new Double(12.34);
		s.set(dou); //오토언박싱
		System.out.println(s.get());
		Double doub = (Double)s.get();
		System.out.println(doub.doubleValue()); //오토언박싱
		
		//Character
		Character cha = new Character('g');
		s.set(cha); //오토박싱
		Character ch = (Character)s.get();
		System.out.println(ch); //오토언박싱
		
		//Box
		s.set(c);
		System.out.println(s.get());
	}
}
