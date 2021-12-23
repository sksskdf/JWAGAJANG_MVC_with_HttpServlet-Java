package review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import goods.dto.GoodsVO;
import review.dto.ReviewVO;
import util.DBManager;

public class ReviewDAO {
	
	private static ReviewDAO instance = new ReviewDAO();
	
	public static ReviewDAO getInstance() {
		return instance;
	}
	
	private ReviewDAO() {}
	
	// 리뷰 등록
	@SuppressWarnings("resource")
	public int insertReview(ReviewVO review) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			sql = "insert into table_review(md_code, user_id, ";
			sql += "review_rate, review_content) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, review.getMd_code());
			pstmt.setString(2, review.getUser_id());
			pstmt.setInt(3, review.getReview_rate());
			pstmt.setString(4, review.getReview_content());
			pstmt.executeUpdate();
			ResultSet keys = pstmt.getGeneratedKeys();     
		      keys.next();   
		      result = keys.getInt(1);    // row id 값
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
		}
		return result;
	}
	
	// 리뷰
	public ReviewVO getReview(int review_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewVO review = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select * from table_review where review_code=?");
			pstmt.setInt(1, review_code);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
					review = new ReviewVO();
					review.setMd_code(rs.getInt("md_code"));
					review.setReview_code(rs.getInt("md_code"));
					review.setUser_id(rs.getString("user_id"));
					review.setUser_name(rs.getString("user_name"));
					review.setReview_rate(rs.getInt("review_rate"));
					review.setReview_content(rs.getString("review_content"));
					review.setReview_regdate(rs.getTimestamp("review_regdate"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
		}
		return review;
	}
}



