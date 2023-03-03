package com.ktdsuniversity.edu.goodgag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAO;
import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAOImpl;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public class GoodGagDAO {

	public static void printAllReplies() {

		// 1. Oracle Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. Database 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String id = "BBS";
			String pw = "BBS1234";
			conn = DriverManager.getConnection(url, id, pw);

			// 3. Query 작성
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT REPLY_NO                                                 ");
		    query.append("      , ARTICLE_NO                                               ");
		    query.append("      , EMAIL                                                    ");
		    query.append("      , DESCRIPT                                                 ");
		    query.append("      , TO_CHAR(REGIST_DATE,'YYYY-MM-DD HH24:MI:SS') REGIST_DATE ");
		    query.append("      , TO_CHAR(MODIFY_DATE,'YYYY-MM-DD HH24:MI:SS') MODIFY_DATE ");
		    query.append("      , PARENT_REPLY_NO                                          ");
		    query.append("   FROM REPLIES                                                  ");

			// 4. Query 실행
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery(); // ResultSet

			// 5. Query 결과 받아서 출력하기
			while (rs.next()) {
				String replyNo = rs.getString("REPLY_NO");
				String articleNo = rs.getString("ARTICLE_NO");
				String email = rs.getString("EMAIL");
				String descript = rs.getString("DESCRIPT");
				String registDate = rs.getString("REGIST_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String parentReplyNo = rs.getString("PARENT_REPLY_NO");

				System.out.println(replyNo + "\t" 
								+ articleNo + "\t" 
								+ email + "\t" 
								+ descript + "\t" 
								+ registDate + "\t"
								+ modifyDate + "\t" 
								+ parentReplyNo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			// 6. DB 연결 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			System.out.println("DB연결해제 성공");
		}

	
	}
	
	public static void printAllArticles() {
		// 1. Oracle Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. Database 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS1234");

			// 3. Query 작성
			StringBuffer query = new StringBuffer();
			query.append(" SELECT ARTICLE_NO                                               ");
			query.append("      , EMAIL                                                    ");
			query.append("      , TITLE                                                    ");
			query.append("      , DESCRIPT                                                 ");
			query.append("      , TO_CHAR(REGIST_DATE,'YYYY-MM-DD HH24:MI:SS') REGIST_DATE ");
			query.append("      , SOURCE                                                   ");
			query.append("      , NOTI_YN                                                  ");
			query.append("   FROM ARTICLE                                                  ");

			// 4. Query 실행
//			pstmt = conn.prepareStatement(query.toString());
			pstmt = conn.prepareStatement("SELECT ARTICLE_NO\r\n"
					+ "	 , EMAIL\r\n"
					+ "	 , TITLE\r\n"
					+ "	 , DESCRIPT\r\n"
					+ "	 , TO_CHAR(REGIST_DATE,'YYYY-MM-DD HH24:MI:SS') REGIST_DATE \r\n"
					+ "	 , SOURCE\r\n"
					+ "	 , NOTI_YN\r\n"
					+ "  FROM ARTICLE ");
			rs = pstmt.executeQuery(); // ResultSet

			// 5. Query 결과 받아서 출력하기
			while (rs.next()) {
				String articleNo = rs.getString("ARTICLE_NO");
				String email = rs.getString("EMAIL");
				String title = rs.getString("TITLE");
				String descript = rs.getString("DESCRIPT");
				String registDate = rs.getString("REGIST_DATE");
				String source = rs.getString("SOURCE");
				String notiYN = rs.getString("NOTI_YN");

				System.out.println(articleNo + "\t" + email + "\t" + title + "\t" + descript + "\t" + registDate + "\t"
						+ source + "\t" + notiYN);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			// 6. DB 연결 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			System.out.println("DB연결해제 성공");
		}

	}
	// 6. DB 연결 해제하기

	
	
	// 파라미터에 입력한 한명만 조회하기
	public static void printOneMembers(String pEmail, String pPassword) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String id = "BBS";
			String pw = "BBS1234";
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB연결 성공");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT EMAIL ");
			query.append(" 	    , NICKNAME ");
			query.append(" 	    , VERIFIED_YN ");
			query.append(" 	    , PASSWORD ");
			query.append(" 	    , TO_CHAR(JOIN_DATE,'YYYY-MM-DD HH24:MI:SS') JOIN_DATE");
			query.append(" 	 FROM MEMBER ");
			query.append(" 	WHERE EMAIL = ? ");
			query.append(" 	  AND PASSWORD = ? ");
			
			// 3-1. 쿼리 실행하기
			pstmt = conn.prepareStatement(query.toString());
			// 3-2. 쿼리 파라미터 바인딩하기
			pstmt.setString(1, pEmail); // parameterIndex 번째 물음표에 x 값을 바인딩하라. 1부터시작
			pstmt.setString(2, pPassword); // parameterIndex 번째 물음표에 x 값을 바인딩하라. 1부터시작
			
			rs = pstmt.executeQuery(); 

			while (rs.next()) {
				String email = rs.getString("EMAIL");
				String nickName = rs.getString("NICKNAME");
				String verifiedYN = rs.getString("VERIFIED_YN");
				String password = rs.getString("PASSWORD");
				String joinDate = rs.getString("JOIN_DATE");

				System.out.println(email + "\t" 
								+ nickName + "\t" 
								+ verifiedYN + "\t" 
								+ password + "\t" 
								+ joinDate);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			System.out.println("DB연결해제 성공");
		}

	
	}
	
	
	public static void printAllMembers() {

		// 1. Oracle Driver Loading
		// oracle.jdbc.driver.OracleDriver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		// 2. Oracle DB에 연결
		// jdbc:oracle:thin:@localhost:1521:XE
		Connection conn = null;
		PreparedStatement pstmt = null; // DB에게 쿼리 실행을 요청하는 객체
		ResultSet rs = null; // 쿼리의 실행 결과를 받아오는 객체

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBS", "BBS1234");
			System.out.println("DB연결 성공");

			// 3. Query 작성
			// 여러 줄의 String을 작성할 때, 사용할 수 있는 객체
			StringBuffer query = new StringBuffer();
			query.append(" SELECT EMAIL ");
			query.append(" 	    , NICKNAME ");
			query.append(" 	    , VERIFIED_YN ");
			query.append(" 	    , PASSWORD ");
			query.append(" 	    , TO_CHAR(JOIN_DATE,'YYYY-MM-DD HH24:MI:SS') JOIN_DATE");
			query.append(" 	 FROM MEMBER ");

			// 3-1. Query 실행하기
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery(); // ResultSet

			// 4. Query 결과 받아오기
			// ResultSet
			// rs.next() ==> Cursor를 한 칸 아래로 내린다.
			while (rs.next()) {
				// rs.get~~~("컬럼명"); => Cursor가 가리키는 ROW의 COLUMN 데이터를 받아온다.
				String email = rs.getString("EMAIL");
				String nickName = rs.getString("NICKNAME");
				String verifiedYN = rs.getString("VERIFIED_YN");
				String password = rs.getString("PASSWORD");
				String joinDate = rs.getString("JOIN_DATE");

				System.out.println(email + "\t" + nickName + "\t" + verifiedYN + "\t" + password + "\t" + joinDate);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			// 5. DB 연결 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
			System.out.println("DB연결해제 성공");
//			연결해제는 연결의 역순으로 진행한다. !!메모리누수 주의
//			연결 및 동작진행 중 에러 발생 시 정상오픈상태가 아니게 되며,
//			선언시 초기화했던 null값을 갖게된다.
//			때문에 null값을 반드시 확인해야한다. *NullPointException
//			연결해제는 반드시 동작해야하기 때문에 finally에 작성하며
//			null값을 반드시 확인해야한다.
//			1) Connection - OPEN
//			2) PreparedStatement - OPEN
//			3) ResultSet - OPEN
//
//			4) resultSet - CLOSE
//			5) PreparedStatement - CLOSE
//			6) Connection - CLOSE

		}

	}

	public static void main(String[] args) {
//		printAllMembers();
//		printAllArticles();
//		printAllReplies();
//		printOneMembers("1@gmail.com" , "111");
		MemberDAO memberDAO = new MemberDAOImpl();
		List<MemberVO> allMemberList = memberDAO.getAllMembers();
		MemberVO member = memberDAO.getOneMember("2@gmail.com", "111");
		
		for(MemberVO eachMember : allMemberList) {
			System.out.println(eachMember.getEmail()
					+ "\t" + eachMember.getNickname()
					+ "\t" + eachMember.getPassword()
					+ "\t" + eachMember.getVerifiedYN()
					+ "\t" + eachMember.getJoinDate());
		}
		System.out.println("\n====================================================\n");
		System.out.println(member.getEmail()
				+ "\t" + member.getNickname()
				+ "\t" + member.getPassword()
				+ "\t" + member.getVerifiedYN()
				+ "\t" + member.getJoinDate());
	}

}
