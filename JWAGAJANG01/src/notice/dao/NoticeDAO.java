package notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import notice.dto.NoticeVO;
import util.DBManager;

public class NoticeDAO { // data access object. db랑 웹사이트에서 쓰는 내용을 연결시켜줌
	private NoticeDAO() {
	}

	private static NoticeDAO instance = new NoticeDAO(); // 싱글톤

	public static NoticeDAO getInstance() {
		return instance;
	}

	public List<NoticeVO> selectAllBoards() { // 게시글 목록 출력
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
		String sql = "insert into notice(" + "notice_label, notice_title, notice_content) " + "values(?, ?, ?)";
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
		String sql = "update notice set notice_label=?, notice_title=?, notice_content=?";
		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, bVo.getNotice_label());
			pstmt.setString(2, bVo.getNotice_title());
			pstmt.setString(3, bVo.getNotice_content());
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
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}