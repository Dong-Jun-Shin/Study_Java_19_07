package exam_class_basic;

public class MovieTest {
	public static void main(String[] args) {
		Movie first = new Movie();
		Movie second = new Movie();
		Movie myMovie = new Movie();
		
		first.set1();
		second.set2();
		myMovie.setUserData();
//		myMovie.setData("Aladdin", 9.44, "가이 리치", 2019);
		
		System.out.println(first.toString());
		System.out.println(second.toString());
		System.out.println(myMovie.toString());
		
	}
}
