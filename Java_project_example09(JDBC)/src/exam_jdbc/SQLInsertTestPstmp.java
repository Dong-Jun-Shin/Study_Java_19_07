package exam_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

interface MENU_SELECT {
	public int READ_ALL_BOOK = 1;
	public int ADD_BOOK = 2;
	public int UPDATE_BOOK = 3;
	public int DEL_BOOK = 4;
}

public class SQLInsertTestPstmp implements MENU_SELECT{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String title, publisher, year;
		int book_id, price, selNum;

		System.out.print("선택 : ");
		selNum = scan.nextInt();
		scan.nextLine();

		switch (selNum) {
		case READ_ALL_BOOK:
			readAllBook();
			break;
		case ADD_BOOK:
			System.out.println("\n*** books 테이블 데이터 입력 ****");
			System.out.print("책제목 입력: ");
			title = scan.nextLine();
			System.out.print("출판사 입력: ");
			publisher = scan.nextLine();
			System.out.print("출판연도 입력 : ");
			year = scan.nextLine();
			System.out.print("가격 입력 : ");
			price = scan.nextInt();
			System.out.println();

			addBook(title, publisher, year, price);
			break;
		case UPDATE_BOOK:
			System.out.println("\n*** books 테이블 데이터 수정 ****");
			System.out.println("변경할 책번호 입력 : ");
			book_id = scan.nextInt();
			scan.nextLine();
			System.out.print("변경될 책제목 입력 : ");
			title = scan.nextLine();
			
			updateBook(book_id, title);
			break;
		case DEL_BOOK:
			System.out.println("\n*** books 테이블 데이터 삭제 ****");
			System.out.print("삭제할 책번호 입력 : ");
			book_id = scan.nextInt();
			scan.nextLine();
			
			delBook(book_id);
			break;
		default:
			System.out.println("잘못 입력");
		}

		scan.close();
	}

	public static Connection makeConnection(String id, String pw) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");

			con = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 연결 성공");

		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	private static void readAllBook() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = makeConnection("javauser", "java1234");

			StringBuffer sb = new StringBuffer();
			sb.append("SELECT * FROM books ORDER BY book_id ASC");

			ps = con.prepareStatement(sb.toString());
			rs = ps.executeQuery();

			System.out.println("\n**** books 테이블 데이터 출력 ****");
			System.out.println("책번호\t제목\t출판사\t출판연도\t가격");
			while (rs.next()) {
				System.out.print(rs.getInt("book_id") + "\t");
				System.out.print(rs.getString("title") + "\t");
				System.out.print(rs.getString("publisher") + "\t");
				System.out.print(rs.getString("year") + "\t");
				System.out.println(rs.getInt("price") + "\t");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void addBook(String title, String publisher, String year, int price) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = makeConnection("javauser", "java1234");
			String sql = "INSERT INTO books(book_id, title, publisher, year, price) "
					+ "VALUES(books_seq.NEXTVAL,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, publisher);
			ps.setString(3, year);
			ps.setInt(4, price);

			int insertCount = ps.executeUpdate();

			if (insertCount == 1) {
				System.out.println("레코드 추가 성공");
			} else {
				System.out.println("레코드 추가 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void updateBook(int book_id, String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE books SET title = ? WHERE book_id = ?";

			con = makeConnection("javauser", "java1234");
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, title);
			pstmt.setInt(2, book_id);

			int cnt = pstmt.executeUpdate();

			if (cnt == 1) {
				System.out.println("데이터 수정 완료");
			} else {
				System.out.println("데이터 수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void delBook(int book_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM books WHERE book_id = ?";
			con = makeConnection("javauser", "java1234");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, book_id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt == 1) {
				System.out.println("레코드 삭제 성공");
			}else {
				System.out.println("레코드 삭제 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}finally {
			try {
				if(con != null) con.close();
				if(pstmt!= null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
