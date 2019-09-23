package exam_generic_extends_implements;

interface Maximum<T extends Comparable<T>>{
	T max();
}

class NumUtil <T extends Comparable<T>> implements Maximum<T>{
	private T[] value;
	
	public NumUtil(T[] value) {
		this.value = value;
	}
	
	public T max() {
		T v = value[0];
		
		for (int i = 1; i < value.length; i++) {
			if(value[i].compareTo(v) > 0) {
				v = value[i];
			}
		}
		
		return v;
	}
}

public class GenInterfaceExample {
	public static void main(String[] args) {
		String[] str = {"1","3","2","6","7","20","9"};
		Integer[] num = {1,2,3,4,7,8,9,20};
		Double[] dou = {1.0, 2.0, 3.0, 4.0, 6.0};
		Apple[] apple = {new Apple("홍로", 4), new Apple("부사", 9), new Apple("가나다", 5)};
		
		NumUtil<String> ustr = new NumUtil<String>(str);
		NumUtil<Integer> unum = new NumUtil<Integer>(num);
		NumUtil<Double> udou = new NumUtil<Double>(dou);
		NumUtil<Apple> uapp = new NumUtil<Apple>(apple);
		
//		NumUtil<String> ustr = new NumUtil(str);
//		NumUtil<Integer> unum = new NumUtil(num);
//		NumUtil<Double> udou = new NumUtil(dou);
//		NumUtil<Apple> uapp = new NumUtil(apple);
		
		System.out.println(ustr.max());
		System.out.println(unum.max());
		System.out.println(udou.max());
		System.out.println(uapp.max());
	}
}
