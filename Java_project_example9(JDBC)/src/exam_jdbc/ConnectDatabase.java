package exam_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	public static Connection makeConnection(String id, String password) {
		/* 11g : jdbc:oracle:thin:@127.0.0.1:1521:orcl
		 *							서버위치 : 포트번호 : SID
		 */
		
		/* 12c : jdbc:oracle:thin:@127.0.0.1:1521/pdborcl
		 * 							서버위치 : 포트번호 / 서비스 이름
		 */
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
			
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		}catch(ClassNotFoundException cnf) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			cnf.printStackTrace();
		}catch(SQLException sqle) {
			System.out.println("연결에 실패하였습니다.");
			sqle.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = makeConnection("javauser", "java1234");
		
//		conn.createStatement(resultSetType, resultSetConcurrency)
		
		if(conn != null) {
			System.out.println("접속을 해제합니다.");
			conn.close();			
		}
	}
}
