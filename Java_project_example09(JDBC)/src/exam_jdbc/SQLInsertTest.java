package exam_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInsertTest {
	public static Connection makeConnection(String id, String pw) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
			
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 연결 성공");
		}catch(ClassNotFoundException cnf) {
			System.out.println("드라이버 적재 실패");
			cnf.printStackTrace();
		}catch(SQLException e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
		
		return con;
	}
	
	private static void addBook(String title, String publisher, String year, int price) {
		//드라이버 적재 및 데이터베이스 연결 객체 생성
		Connection con = makeConnection("javauser", "java1234");
		Statement stmt = null;
		try {
			//SQL문 입력을 위한 Statement(서술) 객체 생성
			stmt = con.createStatement();
			
			//SQL문을 담을 문자열버퍼 생성
			StringBuffer sb = new StringBuffer();
//			sb.append("INSERT INTO books (book_id, title, publisher, year, price) "
//					+ "VALUES(books_seq.nextval, " + "'" + title + "', '" +publisher + "', '"
//					+ year + "', " + price + ")");
			
			String str = String.format("INSERT INTO books(book_id, title, publisher, year, price) "
					+ "VALUES(books_seq.NEXTVAL, '%s', '%s', '%s', %d)", title, publisher, year, price);

//			String str = String.format("DELETE FROM books WHERE title = '창세기'");
			sb.append(str);
			
			//쿼리문이 전달되기 전에 써진 쿼리를 확인
			System.out.println("쿼리문 확인: " + sb);
			
			//Statement객체로 SQL문 업데이트
			int insertCount = stmt.executeUpdate(sb.toString());
			
			//반환된 값으로 성공과 실패 여부 확인 (성공 : 1, 실패 : 0)
			if(insertCount == 1)
				System.out.println("레코드 추가 성공");
			else
				System.out.println("레코드 추가 실패");
		}catch(SQLException e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}finally {
			try {
				if(con != null)
					con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void delBook(String column, String data) {
		Connection con = makeConnection("javauser", "java1234");
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			int n = -1;
			try {
				n = Integer.valueOf(data);
			}catch(Exception e) {
			}
			
			StringBuffer sb = new StringBuffer();
			if(n == -1) 
				sb.append(String.format("DELETE FROM books WHERE %s = %s", column, data));
			else
				sb.append(String.format("DELETE FROM books WHERE %s = %d", column, n));
			
			System.out.println(sb.toString());
			int result = stmt.executeUpdate(sb.toString());
			if(result == 1) {
				System.out.println("Success\n");
			}else {
				System.out.println("Fail\n");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null)
					con.close();
				if(stmt != null)
					stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void readBookAll() {
		//드라이버 적재 및 데이터베이스 연결
		Connection con = makeConnection("javauser", "java1234");
		Statement stmt = null;
		try {
			//SQL문을 문자열 버퍼에 삽입
			StringBuffer sb = new StringBuffer();
			sb.append(String.format("SELECT book_id, title, publisher, year, price FROM books ORDER BY book_id ASC"));
			
			//SQL문 전달을 위한 Statement(서술) 객체 생성
			stmt = con.createStatement();
			//executeQuery로 쿼리문 전달 후, 반환되는 ResultSet형을 받는다.
			ResultSet rs = stmt.executeQuery(sb.toString());
			System.out.println("\n*** books 테이블 데이터 출력 ***");
			System.out.println("책번호\t제목\t출판사\t출판연도\t가격\n");
			
			//출력은 next()가 있는지 여부를 판단 후, 맞는 자료형과 컬럼명을 이용해서 출력해준다.
			while(rs.next()) {
				System.out.print(rs.getInt("book_id")+"\t");
				System.out.print(rs.getString("title")+"\t");
				System.out.print(rs.getString("publisher")+"\t");
				System.out.print(rs.getString("year")+"\t");
				System.out.println(rs.getInt("price")+"\t");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null)
					con.close();
				if(stmt != null)
					stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void selBook(String sql) {
		Connection con = makeConnection("javauser", "java1234");
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			
//			StringBuffer sb = new StringBuffer();
//			sb.append(select);
//			stmt.executeQuery(sb.toString());
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getInt("book_id") + " ");
				System.out.print(rs.getString("title") + " ");
				System.out.print(rs.getString("publisher") + " ");
				System.out.print(rs.getString("year") + " ");
				System.out.println(rs.getInt("price") + " ");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null)
					con.close();
				if(stmt != null)
					stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
//		addBook("책", "출판사", "2020", 10000);
		
//		delBook("book_id", "\'책\'"); //전달할 문자
//		delBook("book_id", "4"); //전달할 숫자
	
//		String str = "SELECT book_id, title, publisher, year, price FROM books WHERE book_id = 2";
//		selBook(str);

//		readBookAll();
	}
}
