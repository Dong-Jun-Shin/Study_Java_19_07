package model;

import java.sql.Connection;
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
	// 싱글톤 구현 (객체가 있는지 여부 확인)
	private static SubjectDAO instance = null;

	public static SubjectDAO getInstance() {
		if (instance == null)
			instance = new SubjectDAO();
		return instance;
	}

	private SubjectDAO() {
	}

	private Connection getConnection() throws Exception {
		Connection con = DBUtil.getConnection();
		return con;
	}

	/**
	 * subjectInsert() 메서드 : 학과 테이블에 데이터 입력
	 * 
	 * @return 성공여부를 boolean형 리턴
	 */
	public boolean subjectInsert(SubjectVO svo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO subject(no, s_num, s_name, filename) VALUES(subject_seq.NEXTVAL, ?, ?, ?)");

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			con = getConnection();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, svo.getS_num());
			pstmt.setString(2, svo.getS_name());
			pstmt.setString(3, svo.getFilename());

			// 오류구문 없이 멈춰있는 경우, 데이터베이스에서 변경사항을 반영(커밋)해준 후 실행한다.
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				success = true;
				System.out.println("레코드 추가 완료");
			} else {
				System.out.println("레코드 추가 실패");
			}
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
	 * subjectUpdate 메서드 : 학과 테이블에 데이터 수정
	 * 
	 * @param svo : SubjectVO형의 변수를 받는다.
	 * @return 성공여부를 boolean형으로 반환
	 * @throws Exception
	 */
	public boolean subjectUpdate(SubjectVO svo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE subject SET s_name = ?, filename = ? WHERE no = ?");

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		try {

			con = getConnection();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, svo.getS_name());
			pstmt.setString(2, svo.getFilename());
			pstmt.setInt(3, svo.getNo());

			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				System.out.println("레코드 수정 완료");
				success = true;
			} else {
				System.out.println("레코드 수정 실패");
			}
		} catch (SQLException se) {
			System.out.println("쿼리 subjectUpdate error = [" + se + " ]");
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
	 * subjectDelete 메서드 : 학과 테이블에 데이터 삭제
	 * 
	 * @param no : 번호로 키워드를 받는다.
	 * @return 성공여부를 boolean형 반환
	 * @throws Exception
	 */
//	public boolean subjectDelete(SubjectVO svo) throws Exception{
	public boolean subjectDelete(int no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM subject WHERE no = ?");

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			con = getConnection();

			pstmt = con.prepareStatement(sql.toString());
			// pstmt.setInt(1, svo.getNo());
			pstmt.setInt(1, no);

			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				System.out.println("레코드 삭제 완료\n");
				success = true;
			} else {
				System.out.println("레코드 삭제 실패\n");
			}
		} catch (SQLException se) {
			System.out.println("쿼리 subjectDelete error = [ " + se + " ]");
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

	/**
	 * getSubjectTotalList() 메서드 : 학과 테이블에 모든 레코드를 반환
	 * 
	 * @param searchWord : WHERE절에 사용되는 키워드. 전체 검색인지, 부분 검색인지 여부를 결정
	 * @return ArrayList<SubjectVO> 리턴
	 */
	public ArrayList<SubjectVO> getSubjectTotalList(String searchWord) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, s_num, s_name, filename FROM subject ");
		if (searchWord != null) {
			sql.append("WHERE s_name LIKE ? ");
		}
		sql.append("ORDER BY no");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO svo = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			if (searchWord != null) {
				pstmt.setString(1, "%" + searchWord + "%");
			}
			rs = pstmt.executeQuery();

			while (rs.next()) {
				svo = new SubjectVO();
				svo.setNo(rs.getInt("no"));
				svo.setS_num(rs.getString("s_num"));
				svo.setS_name(rs.getString("s_name"));
				svo.setFilename(rs.getString("filename"));

				list.add(svo);
			}
		} catch (SQLException e) {
			System.out.println("쿼리 getSubjectTotalList() error = [" + e + " ]");
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
	 * getSubjectNum() 메서드 : 자동으로 학과 번호 부여.
	 * 
	 * @return String형 리턴
	 */
	public String getSubjectNum() throws Exception {
		StringBuffer sql = new StringBuffer();
		// 전체 2자리의 구성 중 빈 자리를 0으로 채운다(LPAD) 만약 값이 없다면 01을 출력한다.
		sql.append("SELECT NVL(LPAD(MAX(TRIM('0' FROM s_num))+1,2,'0'),'01') AS subjectNum FROM subject");

		// 시퀀스를 이용하여 4자리 코드번호 부여 (예를 들어 : 0005)
//		sql.append("SELECT TRIM(TO_CHAR(subject_seq.NEXTVAL, '0000')) AS codeNumber FROM dual");
		// 문자와 시퀀스를 이용하여 문자 4자리 코드번호 부여(예를 들어: CODE0005)
//		sql.append("SELECT CONCAT('CODE', TRIM(TO_CHAR(subject_seq.NEXTVAL, '0000'))) AS codeNumber FROM dual");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String subjectNumber = "";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				subjectNumber = rs.getString("subjectNum");
			}
		} catch (SQLException se) {
			System.out.println("쿼리 getSubjectNum error = [" + se + "]");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println("error = [" + e + "]");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				// TODO: handle exception
				System.out.println("디비 연동 해제 error = [" + se + "]");
			}
		}

		return subjectNumber;
	}

}
