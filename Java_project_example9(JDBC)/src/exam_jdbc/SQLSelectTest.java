package exam_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSelectTest {
	public static Connection makeConnection(String id, String password) {
		String url = "jdbc:oracle:thin:@172.0.0.1:orcl";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
			
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		}catch(ClassNotFoundException cnf) {
			System.out.println("드라이버 적재 실패");
			cnf.printStackTrace();
		}catch(SQLException sqle) {
			System.out.println("데이터베이스 연결 실패");
			sqle.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		try {
			Connection con = ConnectDatabase.makeConnection("scott", "tiger");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT empno, ename FROM emp");
			System.out.println("**** EMP 테이블 데이터 출력 ****\n");
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				System.out.println("사원번호 : " + empno + " 사원이름 : " + ename);
			}
		}catch(SQLException s) {
			System.err.println("[쿼리문 ERROR] \n" + s.getMessage());
		}
	}
}
