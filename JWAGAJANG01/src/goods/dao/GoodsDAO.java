package goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import goods.dto.GoodsVO;
import util.DBManager;

public class GoodsDAO {
	
	private static GoodsDAO instance = new GoodsDAO();
	
	public static GoodsDAO getInstance() {
		return instance;
	}
	
	private GoodsDAO() { }
	
	// 상품 분류
	public List<GoodsVO> sortMd(String category_main, String category_sub) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GoodsVO> mdCate = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sqlAll = "select * from table_md";
			String sqlCate = "select * from table_md";
			sqlCate += " where category_main = ?";
			
			if(category_sub != null) {
				sqlCate += " and category_sub = ?";
			}
			
			if(category_main.equals("All") || category_main.equals("")) {
				pstmt = conn.prepareStatement(sqlAll);
			} else {
				pstmt = conn.prepareStatement(sqlCate);
				pstmt.setString(1, category_main);
				
				if(category_sub != null) {
				pstmt.setString(2, category_sub);
				}
			}
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				mdCate = new ArrayList<GoodsVO>();
				do {
					GoodsVO md = new GoodsVO();
					md.setMd_code(rs.getInt("md_code"));
					md.setMd_name(rs.getString("md_name"));
					md.setMd_price(rs.getInt("md_price"));
					md.setMd_dc(rs.getInt("md_dc"));
					md.setImg_main(rs.getString("img_main"));
					md.setCategory_main(rs.getNString("category_main"));
					md.setCategory_sub(rs.getNString("category_sub"));
					mdCate.add(md);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
		}
		return mdCate;
	}
	
	
	// 상품 상세
	public GoodsVO getMd(int md_code) {
		String sql = "select * from table_md where md_code=?";
		GoodsVO md = null;
		ResultSet rs = null;
		
		try (Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql); ) {
			pstmt.setInt(1, md_code);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				md = new GoodsVO();
				md.setMd_code(rs.getInt("md_code"));
				md.setMd_name(rs.getString("md_name"));
				md.setMd_price(rs.getInt("md_price"));
				md.setMd_dc(rs.getInt("md_dc"));
				md.setImg_main(rs.getString("img_main"));
				md.setImg_detail(rs.getString("img_detail"));
				md.setCategory_main(rs.getNString("category_main"));
				md.setCategory_sub(rs.getNString("category_sub"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}
		return md;
	}
	
	
	// 리뷰
	public List<GoodsVO> getReview(int md_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GoodsVO> reviewList = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select * from table_review where md_code="+md_code);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				reviewList = new ArrayList<GoodsVO>();
				do {
					GoodsVO gVo = new GoodsVO();
					gVo.setMd_code(rs.getInt("md_code"));
					gVo.setReview_code(rs.getInt("md_code"));
					gVo.setUser_id(rs.getString("user_id"));
					gVo.setReview_rate(rs.getInt("review_rate"));
					gVo.setReview_content(rs.getString("review_content"));
					gVo.setReview_regdate(rs.getTimestamp("review_regdate"));
				} while (rs.next());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
		}
		return reviewList;
	}
	
	
	// 리뷰 수
	public int reviewCount(int md_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select count(*) from table_review where md_code = " + md_code);
			rs = pstmt.executeQuery();
			
			if (rs.next())
				x = rs.getInt(1);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
		}
		return x;
	}
	
	
	// 리뷰 등록
	@SuppressWarnings("resource")
	public void insertReview(GoodsVO review) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			sql = "insert into table_review(md_code, review_code, user_id, ";
			sql += "review_rate, review_content, review_regdate) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review.getMd_code());
			pstmt.setInt(2, review.getReview_code());
			pstmt.setString(3, review.getUser_id());
			pstmt.setInt(4, review.getReview_rate());
			pstmt.setString(5, review.getReview_content());
			pstmt.setTimestamp(6, review.getReview_regdate());
			pstmt.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
		}
	}
	
}
