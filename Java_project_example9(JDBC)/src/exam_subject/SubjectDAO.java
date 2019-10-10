package exam_subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * DAO(Data Access Object) 클래스가 데이터 처리의 궁극적 단계
 * 
 * CRUD 프로그램 구현
 * : 기본적인 데이터 처리 기능인 입력(Create, Insert),
 * 조회(Read(또는 Retrieve), Select), 수정(Update),
 * 삭제(Delete) 기능을 구현한 데이터베이스 프로그램.
 */

public class SubjectDAO {
	private static final String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String USER = "javauser";
	private static final String PASSWORD = "java1234";

	// 싱글톤 구현 (객체가 있는지 여부 확인)
	private static SubjectDAO instance = null;

	public static SubjectDAO getInstance() {
		if (instance == null)
			instance = new SubjectDAO();
		return instance;
	}

	
	private SubjectDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("드라이버 적재 완료");

		} catch (ClassNotFoundException cnf) {
			System.out.println("드라이버 적재 실패");
			cnf.printStackTrace();
		}

	}

	private Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		return con;
	}

	
	// 학과 테이블에 데이터 입력 메소드
	public boolean subjectInsert(SubjectVO svo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO subject(no, s_num, s_name) VALUES(subject_seq.NEXTVAL, ?, ?)");

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		con = getConnection();

		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, svo.getS_num());
		pstmt.setString(2, svo.getS_name());

		// 오류구문 없이 멈춰있는 경우, 데이터베이스에서 변경사항을 반영(커밋)해준 후 실행한다.
		int cnt = pstmt.executeUpdate();
		if (cnt == 1) {
			success = true;
			System.out.println("레코드 추가 완료");
		} else {
			System.out.println("레코드 추가 실패");
		}

		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("DB 연동 해제 error = [" + e + " ]");
			e.printStackTrace();
		}

		return success;
	}

	// 학과 테이블에 데이터 수정 메소드
	public boolean subjectUpdate(SubjectVO svo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE subject SET s_num = ?, s_name = ? WHERE no = ?");

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		con = getConnection();

		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, svo.getS_num());
		pstmt.setString(2, svo.getS_name());
		pstmt.setInt(3, svo.getNo());

		int cnt = pstmt.executeUpdate();
		if (cnt == 1)
			System.out.println("레코드 수정 완료");
		else
			System.out.println("레코드 수정 실패");

		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("DB 연동 해제 error = [" + e + " ]");
			e.printStackTrace();
		}
		
		return success;
	}

	// 학과 테이블에 데이터 삭제 메소드
	public boolean subjectDelete(String s_name) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM subject WHERE s_name = ?");

		Connection con = null;
		PreparedStatement pstmt = null;

		con = getConnection();

		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, s_name);

		int cnt = pstmt.executeUpdate();
		if (cnt == 1) {
			System.out.println("레코드 삭제 완료\n");
		} else {
			System.out.println("레코드 삭제 실패\n");
		}

		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("DB 연동 해제 error = [" + e + " ]");
			e.printStackTrace();
		}

		return false;
	}

	// 학과 테이블에서 학과명으로 특정 데이터 조회 메소드
	public ArrayList<SubjectVO> subjectSelect(String s_name) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, s_num, s_name FROM subject WHERE s_name = ?");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO svo = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();

		con = getConnection();
		pstmt = con.prepareStatement(sql.toString());

		pstmt.setString(1, s_name);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			svo.setNo(rs.getInt("no"));
			svo.setS_num(rs.getString("s_num"));
			svo.setS_name(rs.getString("s_name"));

			list.add(svo);
		}

		try {
			if (con != null)
				con.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			System.out.println("DB 연동 해제 error = [" + e + " ]");
			e.printStackTrace();
		}

		return list;
	}

	// 학과 테이블에 모든 레코드를 반환 메소드
	public ArrayList<SubjectVO> getSubjectTotal() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, s_num, s_name FROM subject ORDER BY no");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO svo = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				svo = new SubjectVO();
				svo.setNo(rs.getInt("no"));
				svo.setS_num(rs.getString("s_num"));
				svo.setS_name(rs.getString("s_name"));

				list.add(svo);
			}
		} catch (SQLException e) {
			System.out.println("쿼리 error = [" + e + " ]");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("error = [" + e + " ]");
			e.printStackTrace();
		} finally {
			try {
				// 생성의 역순으로 닫기
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("DB 연동 해제 error = [" + e + " ]");
			}
		}

		return list;
	}
}
