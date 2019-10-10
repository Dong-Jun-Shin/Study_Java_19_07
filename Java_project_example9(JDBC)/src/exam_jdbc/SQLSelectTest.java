package exam_jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLSelectTest {
	public static void main(String[] args) {
		ResultSet rs = null;
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("찾을 사원이름을 입력해주세요.");
			rs = InsertSQL(scan.nextLine());
			System.out.println("**** EMP 테이블 데이터 출력 ****\n");
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				System.out.println("사원번호 : " + empno + " 사원이름 : " + ename);
			}
		} catch (SQLException s) {
			System.out.println("찾는 사원이 없습니다.");
			System.err.println("[쿼리문 ERROR] \n" + s.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection makeConnection(String id, String pw) {
		String url = "jdbc:oracle:thin:@172.0.0.1:1521:orcl";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");

			con = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 연결 성공");

		} catch (ClassNotFoundException cnf) {
			System.out.println("드라이버 적재 실패");
			cnf.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return con;
	}

	private static ResultSet InsertSQL(String name) {
		StringBuffer sb = new StringBuffer();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = makeConnection("scott", "tiger");
			stmt = con.createStatement();
			sb.append("SELECT empno, ename FROM emp WHERE ename = '");
			sb.append(name);
			sb.append("'");
			rs = stmt.executeQuery(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

}
