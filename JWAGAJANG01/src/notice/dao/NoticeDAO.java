package notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import notice.dto.NoticeVO;
import util.DBManager;


public class NoticeDAO { // data access object. db랑 웹사이트에서 쓰는 내용을 연결시켜줌
	private Connection conn;
	private PreparedStatement pstmt;

	private NoticeDAO() {
	}

	private static NoticeDAO instance = new NoticeDAO(); // 싱글톤

	public static NoticeDAO getInstance() {
		return instance;
	}

	/* 검색 + 리스트 + 페이징 */
	public List<NoticeVO> getBoardList(HashMap<String, Object> listOpt) {

		// 글 목록을 가져올 메서드인 getBoardList()를 작성한다
		// 이 메서드는 글 목록을 ArrayList에 담아서 BoardListAction으로 전달한다.
		// 글 검색도 같이 처리하기 위해 인자로 검색 옵션, 검색 내용, 현재 페이지 번호를 갖고 있는 HashMap을 넘겨받는다.
		List<NoticeVO> list = new ArrayList<NoticeVO>();

		StringBuffer sql = new StringBuffer();
		String opt = (String) listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
		String condition = (String) listOpt.get("conditon"); // 검색내용
		int start = (Integer) listOpt.get("start"); // 현재 페이지번호

		 try {
	            conn = DBConnection.getConnection();
	            StringBuffer sql = new StringBuffer();
	            
		// 글목록 전체를 보여줄 때
		if (opt == null) {
			// BOARD_RE_REF(그룹번호)의 내림차순 정렬 후 동일한 그룹번호일 때는
			// BOARD_RE_SEQ(답변글 순서)의 오름차순으로 정렬 한 후에
			// 10개의 글을 한 화면에 보여주는(start번째 부터 start+9까지) 쿼리
			// desc : 내림차순, asc : 오름차순 ( 생략 가능 )
			sql.append("select * from ");
			sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
			sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_COUNT, BOARD_RE_REF");
			sql.append(", BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_DATE ");
			sql.append("FROM");
			sql.append(" (select * from MEMBER_BOARD order by BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
			sql.append("where rnum>=? and rnum<=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, start + 9);

			// StringBuffer를 비운다.
			sql.delete(0, sql.toString().length());
		} else if (opt.equals("2")) { // 제목+내용으로 검색 
			sql.append("select * from ");
			sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
			sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT");
			sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ");
			sql.append("FROM ");
			sql.append("(select * from MEMBER_BOARD where BOARD_SUBJECT like ? OR BOARD_CONTENT like ? ");
			sql.append("order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
			sql.append("where rnum>=? and rnum<=?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + condition + "%");
			pstmt.setString(2, "%" + condition + "%");
			pstmt.setInt(3, start);
			pstmt.setInt(4, start + 9);

			sql.delete(0, sql.toString().length());
		}
		catch(Exception e) {
		throw new RuntimeException(e.getMessage());
	}
	close();
	return list;
}

	// DB 자원해제
	private void close() {
		{
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} // end close()
	}

	/*	public List<NoticeVO> selectAllBoards() { // 게시글 목록 출력, List안에 NoticeVO를 저장하겠다고 약속 . <>안에는 특정한 값 넣을 수 있음
		String sql = "select * from notice order by notice_regdate desc";
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try (Connection conn = DBManager.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				NoticeVO bVo = getBoardVOFromResultSet(rs);
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	*/
	private NoticeVO getBoardVOFromResultSet(ResultSet rs) throws SQLException { // 상세내용 출력
		NoticeVO bVo = new NoticeVO();
		bVo.setNotice_code(rs.getInt("notice_code"));
		bVo.setNotice_label(rs.getString("notice_label"));
		bVo.setNotice_title(rs.getString("notice_title"));
		bVo.setNotice_regdate(rs.getTimestamp("notice_regdate"));
		bVo.setNotice_editdate(rs.getTimestamp("notice_editdate"));
		bVo.setNotice_content(rs.getString("notice_content"));
		bVo.setNotice_count(rs.getInt("notice_count"));
		return bVo;
	}

	// 게시글 등록
	public void insertBoard(NoticeVO bVo) {
		String sql = "insert into notice(notice_label, notice_title, notice_content) " + "values(?, ?, ?)";
		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, bVo.getNotice_label());
			pstmt.setString(2, bVo.getNotice_title());
			pstmt.setString(3, bVo.getNotice_content());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 게시글 조회 횟수 갱신
	public void updateReadCount(int notice_count) { 
		String sql = "update notice set notice_count=notice_count+1 where notice_code=?";
		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, notice_count);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
	public NoticeVO selectOneBoardByNum(int notice_code) {
		String sql = "select * from notice where notice_code = ?";
		NoticeVO bVo = null;
		ResultSet rs = null;
		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, notice_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = getBoardVOFromResultSet(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}
		return bVo;
	}

	// 게시글 수정
	public void updateBoard(NoticeVO bVo) {
		String sql = "update notice set notice_label=?, notice_title=?, notice_content=? where notice_code=?";
		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, bVo.getNotice_label());
			pstmt.setString(2, bVo.getNotice_title());
			pstmt.setString(3, bVo.getNotice_content());
			pstmt.setInt(4, bVo.getNotice_code());
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 게시글 삭제
	public void deleteBoard(int notice_code) {
		String sql = "delete from notice where notice_code=?";
		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, notice_code);
			pstmt.executeUpdate(); /* 변경쿼리 executeUpdate */
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
}