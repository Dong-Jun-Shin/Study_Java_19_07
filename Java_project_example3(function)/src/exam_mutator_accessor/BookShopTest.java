package exam_mutator_accessor;

/*클래스는 책제목(bname), 저자(author), 책 가격(price)를 필드로 가진다.
 * 각 각 필드는 설정잗와 접근자를 생성한다.
 * 그리고 필드에 값을 대입하기 위한 메서드도 생성한다.
 * 
 * [출력결과]
 * <<값 대입>>
 * 책이름 : Web/Servlet
 * 저자 : Dominica
 * 가격 : 30000
 * 
 * <<값 변경 후 출력>>
 * 책이름 : 프로그래밍 이렇게 시작하세요
 * 저자 : 홍길동
 * 가격 : 30000
 */
public class BookShopTest {
	public static void main(String[] args) {
		BookShop book = new BookShop();
		
		book.setBname("Web/Servlet");
		book.setAuthor("Dominica");
		book.setPrice(30000);
		System.out.println("<<값 대입>>");
		System.out.println(book.toString());
		System.out.println();

		book.setBname("프로그래밍 이렇게 시작하세요");
		book.setAuthor("홍길동");
		book.setPrice(30000);
		System.out.println("<<값 변경 후 출력>>");
		System.out.println(book.toString());
		System.out.println();
	}
}
