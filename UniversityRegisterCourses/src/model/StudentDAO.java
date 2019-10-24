package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
	// 싱글톤
	private static StudentDAO instance = null;

	public static StudentDAO getInstance() {
		if (instance == null)
			instance = new StudentDAO();
		return instance;
	}

	private StudentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Connection getConnection() throws Exception {
		Connection con = DBUtil.getConnection();
		return con;
	}

	/**
	 * 학생 전체 리스트
	 * 
	 * @return ArrayList<StudentVO>
	 * @throws Exception
	 */
	public ArrayList<StudentVO> getStudentTotalList() throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, sd_num, sd_name, sd_id, sd_passwd, s_num, ");
		sql.append("sd_birth, sd_phone, address, sd_email, sd_date FROM student ");
		sql.append("ORDER BY no");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO svo = null;
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				svo = new StudentVO();
				svo.setNo(rs.getInt("no"));
				svo.setSd_num(rs.getString("sd_num"));
				svo.setSd_name(rs.getString("sd_name"));
				svo.setSd_id(rs.getString("sd_id"));
				svo.setSd_passwd(rs.getString("sd_passwd"));
				svo.setS_num(rs.getString("s_num"));
				svo.setSd_birth(rs.getString("sd_birth"));
				svo.setSd_phone(rs.getString("sd_phone"));
				svo.setSd_address(rs.getString("sd_address"));
				svo.setSd_email(rs.getString("sd_email"));
				svo.setSd_date(rs.getString("sd_date"));

				list.add(svo);
			}
		} catch (SQLException e) {
			System.out.println("쿼리 getStudentTotalList() error = [" + e + " ]");
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

	/**
	 * 학생 정보 리스트
	 * 
	 * @param searchObject 검색대상
	 * @param searchWord   검색단어
	 * @return ArrayList<StudentVO>
	 * @throws Exception
	 */
	public ArrayList<StudentVO> getStudentSearch(String searchObject, String searchWord) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, sd_num, sd_name, sd_id, sd_passwd, s_num, ");
		sql.append("sd_birth, sd_phone, address, sd_email, sd_date FROM student ");
		sql.append("WHERE ? LIKE ? ");
		sql.append("ORDER BY no");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO svo = null;
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, searchObject);
			pstmt.setString(2, "%" + searchWord + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				svo = new StudentVO();
				svo.setNo(rs.getInt("no"));
				svo.setSd_num(rs.getString("sd_num"));
				svo.setSd_name(rs.getString("sd_name"));
				svo.setSd_id(rs.getString("sd_id"));
				svo.setSd_passwd(rs.getString("sd_passwd"));
				svo.setS_num(rs.getString("s_num"));
				svo.setSd_birth(rs.getString("sd_birth"));
				svo.setSd_phone(rs.getString("sd_phone"));
				svo.setSd_address(rs.getString("sd_address"));
				svo.setSd_email(rs.getString("sd_email"));
				svo.setSd_date(rs.getString("sd_date"));

				list.add(svo);
			}
		} catch (SQLException e) {
			System.out.println("쿼리 getStudentSearch() error = [" + e + " ]");
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

	/**
	 * 동일 학과 학생 일련번호
	 * 
	 * @param subjectNum 학과번호
	 * @return String 각 학과별 일련번호 반환
	 * @throws Exception
	 */
	public String getStudentCount(String subjectNum) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no FROM subject ");
		sql.append("WHERE s_num = ? ");
		sql.append("ORDER BY no");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sNum = "";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, subjectNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sNum = subjectNum;
			}
		} catch (SQLException e) {
			System.out.println("쿼리 getStudentCount() error = [" + e + " ]");
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

		return sNum;
	}

	/**
	 * 학생 아이디 중복 체크
	 * 
	 * @param idOverlap 중복체크 할 아이디명
	 * @return boolean
	 * @throws Exception
	 */
	public boolean getStudentIdOverlap(String idOverlap) throws Exception {
		boolean overlap = true;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) FROM student WHERE sd_id = ?");
		sql.append("ORDER BY no");
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, idOverlap);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt(1);
			}

			if (cnt == 0)
				overlap = false;
		} catch (SQLException e) {
			System.out.println("쿼리 getStudentIdOverlap() error = [" + e + " ]");
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

		return overlap;
	}

	/**
	 * 학생 정보 등록(입력)
	 * 
	 * @param svo VO 클래스
	 * @return boolean
	 * @throws Exception
	 */
	public boolean studentInsert(StudentVO svo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO student (no, sd_num, sd_name, sd_id, sd_passwd, s_num, ");
		sql.append("sd_birth, sd_phone, sd_address, sd_email, sd_date) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			con = getConnection();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, svo.getNo());
			pstmt.setString(2, svo.getSd_num());
			pstmt.setString(3, svo.getSd_name());
			pstmt.setString(4, svo.getSd_id());
			pstmt.setString(5, svo.getSd_passwd());
			pstmt.setString(6, svo.getS_num());
			pstmt.setString(7, svo.getSd_birth());
			pstmt.setString(8, svo.getSd_phone());
			pstmt.setString(9, svo.getSd_address());
			pstmt.setString(10, svo.getSd_email());
			pstmt.setString(11, svo.getSd_date());

			// 오류구문 없이 멈춰있는 경우, 데이터베이스에서 변경사항을 반영(커밋)해준 후 실행한다.
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				success = true;
				System.out.println("레코드 추가 완료");
			} else {
				System.out.println("레코드 추가 실패");
			}
		} catch (Exception e) {
			System.out.println("쿼리 studentInsert() error = [" + e + " ]");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("DB 연동 해제 error = [" + e + " ]");
				e.printStackTrace();
			}
		}

		return success;
	}

	/**
	 * 학생 정보(학번, 이름, 학과번호 제외) 수정
	 * 
	 * @param svo VO 클래스
	 * @return boolean
	 * @throws Exception
	 */
	public boolean studentUpdate(StudentVO svo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE student SET sd_num = ?,  sd_id = ?, sd_passwd = ?, sd_birth = ?, ");
		sql.append("sd_phone = ?, sd_address = ?, sd_email = ?, sd_date = ? WHERE no = ?");

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		try {
			con = getConnection();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, svo.getSd_num());
			pstmt.setString(2, svo.getSd_id());
			pstmt.setString(3, svo.getSd_passwd());
			pstmt.setString(4, svo.getSd_birth());
			pstmt.setString(5, svo.getSd_phone());
			pstmt.setString(6, svo.getSd_address());
			pstmt.setString(7, svo.getSd_email());
			pstmt.setString(8, svo.getSd_date());
			pstmt.setInt(9, svo.getNo());

			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				System.out.println("레코드 수정 완료");
				success = true;
			} else {
				System.out.println("레코드 수정 실패");
			}
		} catch (SQLException se) {
			System.out.println("쿼리 studentUpdate() error = [" + se + " ]");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("DB 연동 해제 error = [" + e + " ]");
				e.printStackTrace();
			}
		}

		return success;
	}

	/**
	 * 학생 정보 삭제
	 * 
	 * @param no 삭제할 번호
	 * @return boolean
	 * @throws Exception
	 */
	public boolean studentDelete(StudentVO svo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM student WHERE no = ?");

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			con = getConnection();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, svo.getNo());
//			pstmt.setInt(1, no);

			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				System.out.println("레코드 삭제 완료\n");
				success = true;
			} else {
				System.out.println("레코드 삭제 실패\n");
			}
		} catch (SQLException se) {
			System.out.println("쿼리 studentDelete() error = [ " + se + " ]");
		} catch (Exception e) {
			System.out.println("error = [ " + e + " ]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("DB 연동 해제 error = [" + e + " ]");
				e.printStackTrace();
			}
		}

		return success;
	}
}
