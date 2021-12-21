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
			if (rs != null)
				try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null)
				try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null)
				try { conn.close(); } catch(SQLException ex) {}
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
	
}
