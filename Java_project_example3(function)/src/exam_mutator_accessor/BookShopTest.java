package exam_mutator_accessor;

/*Ŭ������ å����(bname), ����(author), å ����(price)�� �ʵ�� ������.
 * �� �� �ʵ�� �����޿� �����ڸ� �����Ѵ�.
 * �׸��� �ʵ忡 ���� �����ϱ� ���� �޼��嵵 �����Ѵ�.
 * 
 * [��°��]
 * <<�� ����>>
 * å�̸� : Web/Servlet
 * ���� : Dominica
 * ���� : 30000
 * 
 * <<�� ���� �� ���>>
 * å�̸� : ���α׷��� �̷��� �����ϼ���
 * ���� : ȫ�浿
 * ���� : 30000
 */
public class BookShopTest {
	public static void main(String[] args) {
		BookShop book = new BookShop();
		
		book.setBname("Web/Servlet");
		book.setAuthor("Dominica");
		book.setPrice(30000);
		System.out.println("<<�� ����>>");
		System.out.println(book.toString());
		System.out.println();

		book.setBname("���α׷��� �̷��� �����ϼ���");
		book.setAuthor("ȫ�浿");
		book.setPrice(30000);
		System.out.println("<<�� ���� �� ���>>");
		System.out.println(book.toString());
		System.out.println();
	}
}
