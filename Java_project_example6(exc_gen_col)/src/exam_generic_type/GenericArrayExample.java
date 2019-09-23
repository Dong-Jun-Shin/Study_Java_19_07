package exam_generic_type;

import exam_none_generic_type.Apple;

/* GenericArray라는 이름으로 제네릭 클래스를 생성한다.
 * 필드는 size와 모든 타입을 다 설정할 수 있는 배열을 선언한다.
 * print()를 통해 배열을 값을 출력한다.
 */
class GenericArray<T>{
	private T[] arr;
	private int size;

	public GenericArray() {	
		
	}

	public final T[] getArr() {
		return arr;
	}

	public final void setArr(T[] arr) {
		this.arr = arr;
	}

	public final int getSize() {
		return size;
	}

	public final void setSize(int size) {
		this.size = size;
	}
	
	public void print() {
		for (T t : arr) {
			//println 구문을 사용할 때, 참조변수 명만 사용되면 해당 변수의 
			//(자신or부모) toString()을 호출한다. 
			System.out.println(t);
		}
	}
		
	
}

public class GenericArrayExample {
	public static void main(String[] args) {
		GenericArray<String> arr1 = new GenericArray<String>();
		String[] language = {"Java", "JSP", "SPRING"};
		arr1.setArr(language);
		arr1.print();
		
		GenericArray<Apple> app = new GenericArray<Apple>();
		Apple[] apple = {new Apple("빨간색"), new Apple("청색"), new Apple("황금")};
		app.setArr(apple);
		app.print();
		//toString 메소드의 유무에 따라 (부모의 toString())주소값과 (자신의 toString())내용이 나온다.
		
		
		//String
		GenericArray<String> arr2 = new GenericArray<String>();
		String[] str = {"a","b","c","d","f"};
		arr2.setArr(str);
//		arr2.setArr(new String[5]);
//		(arr2.getArr())[0] = "a";
//		(arr2.getArr())[1] = "b";
//		(arr2.getArr())[2] = "c";
//		(arr2.getArr())[3] = "d";
//		(arr2.getArr())[4] = "f";
		arr2.print();

		//Integer
		GenericArray<Integer> arr3 = new GenericArray<Integer>();
		//new로 객체생성 후 주소값 전달 방식
		//Integer[] i = {new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5)};
		Integer[] num = {1,2,3,4,5};
		arr3.setArr(num);
//		arr3.setArr(new Integer[5]);
//		(arr3.getArr())[0] = 1;
//		(arr3.getArr())[1] = 2;
//		(arr3.getArr())[2] = 3;
//		(arr3.getArr())[3] = 4;
//		(arr3.getArr())[4] = 5;
		
		arr3.print();
	}
}
