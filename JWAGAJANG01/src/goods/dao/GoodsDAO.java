package goods.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goods.dto.GoodsVO;
import util.DBManager;

public class GoodsDAO {
	
	private static GoodsDAO instance = new GoodsDAO();
	
	public static GoodsDAO getInstance() {
		return instance;
	}
	
	private GoodsDAO() { }
	
	// 상품 분류
	public List<GoodsVO> sortMd(String category_main, String category_sub, String order,
			int firstRow, int endRow, boolean readContnent) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GoodsVO> mdCate = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sqlAll = "select * from table_md";
			String sqlCate = "select * from table_md";
			sqlCate += " where category_main = ?";
			
			if(category_sub != null && !category_sub.isEmpty()) {
				sqlCate += " and category_sub = ?";
			}
			
			if(order.equals("1")) {
				sqlAll += " order by md_regdate desc";
				sqlCate += " order by md_regdate desc";
			} else if(order.equals("2")) {
				sqlAll += " order by md_ordercnt desc";
				sqlCate += " order by md_ordercnt desc";
			} else if(order.equals("4")) {
				sqlAll += " order by md_price asc";
				sqlCate += " order by md_price asc";
			} else if(order.equals("5")) {
				sqlAll += " order by md_price desc";
				sqlCate += " order by md_price desc";
			}
			
			sqlAll += " limit ?, ?";
			sqlCate += " limit ?, ?";
			
			if(category_main.equals("All") || category_main.equals("")) {
				pstmt = conn.prepareStatement(sqlAll);
				pstmt.setInt(1, firstRow-1);
				pstmt.setInt(2, endRow-firstRow+1);
			} else {
				pstmt = conn.prepareStatement(sqlCate);
				pstmt.setString(1, category_main);
				
				if(category_sub != null && !category_sub.isEmpty()) {
					pstmt.setString(2, category_sub);
					pstmt.setInt(3, firstRow-1);
					pstmt.setInt(4, endRow-firstRow+1);
				} else {
					pstmt.setInt(2, firstRow-1);
					pstmt.setInt(3, endRow-firstRow+1);
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
					md.setCategory_main(rs.getString("category_main"));
					md.setCategory_sub(rs.getString("category_sub"));
					md.setCategory_main_name(rs.getString("category_main_name"));
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
				md.setMd_stock(rs.getInt("md_stock"));
				md.setImg_main(rs.getString("img_main"));
				md.setImg_detail(rs.getString("img_detail"));
				md.setCategory_main(rs.getNString("category_main"));
				md.setCategory_sub(rs.getNString("category_sub"));
				md.setCategory_main_name(rs.getString("category_main_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);
		}
		return md;
	}
	
	
	// 전체 리뷰 수
	public int reviewCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select count(*) from table_review");
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
	
	// 리뷰 수
	public int reviewCount(int md_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select count(*) from table_review where md_code = ?");
			pstmt.setInt(1, md_code);
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
	

	// 리뷰
	public List<GoodsVO> getReviewList(int count, int md_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GoodsVO> reviewList = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select * from table_review where md_code = ?");
			pstmt.setInt(1, md_code);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				reviewList = new ArrayList<GoodsVO>(count);
				do {
					GoodsVO review = new GoodsVO();
					review.setMd_code(rs.getInt("md_code"));
					review.setReview_code(rs.getInt("review_code"));
					review.setUser_id(rs.getString("user_id"));
					review.setUser_name(rs.getString("user_name"));
					review.setReview_rate(rs.getInt("review_rate"));
					review.setReview_content(rs.getString("review_content"));
					review.setReview_regdate(rs.getTimestamp("review_regdate"));
					reviewList.add(review);
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
	
	// 리뷰 삭제
	public int deleteReview(int review_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("delete from table_review where review_code=?");
			pstmt.setInt(1, review_code);
			pstmt.executeUpdate();
			x = 1; 	// 글 삭제 성공
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
		}
		return x;
	}
	
	
	
	// 검색
	/*
	 * public List<GoodsVO> searchResult(String md_name) { Connection conn = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * try { conn = DBManager.getConnection(); pstmt =
	 * conn.prepareStatement("select * from table_md where " + md_name + " like ?");
	 * pstmt.setString(1, "%"+md_name+"%"); rs = pstmt.executeQuery();
	 * 
	 * return result(rs); } }
	 */
	

	// 상품 갯수 (페이징에 필요)
	public int selectCount(String category_main, String category_sub) throws SQLException {
		ResultSet rs = null;
	    int count = 0;
	      
	    String sql = "select count(*) from table_md";
	    if (!category_main.equals("All") && !category_main.equals("")) {
	    	sql += " where category_main='" + category_main + "'";
	    } 
		if(category_sub != null && !category_sub.isEmpty()) {
			sql += " and category_sub='" + category_sub + "'";
		}

		try (Connection conn = DBManager.getConnection();
			Statement stmt = conn.createStatement();) {
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					count = rs.getInt(1); 
				}
			} finally {
				DBManager.close(rs);
			}
		return count;
	}
	
	
	// 최근 본 상품
	private static final String encoding = "UTF-8";
	private static final String path = "/";

	/**
	  * @description 특정 key의 쿠키값을 List로 반환한다.
	  * @params key: 쿠키 이름
	  */
	public List<String> getValueList(String key, HttpServletRequest req) throws UnsupportedEncodingException {
		Cookie[] cookies = req.getCookies();
		String[] cookieValues = null;
		String value = "";
		List<String> ckList = null;
		
		// 특정 key의 쿠키값을 ","로 구분하여 String 배열에 담아준다.
		// ex) 쿠키의 key/value ---> key = "clickItems", value = "211, 223, 303"(상품 번호)
		if (cookies != null) {
			for (int i=0; i<cookies.length; i++) {
				if (cookies[i].getName().equals(key)) {
					value = cookies[i].getValue();
					cookieValues = (URLDecoder.decode(value, encoding)).split(",");
					break;
				}
			}
		}
		// String 배열에 담겼던 값들을 List로 다시 담는다.
		if (cookieValues != null) {
			ckList = new ArrayList<String>(Arrays.asList(cookieValues));
			
			if(ckList.size() > 3) {	// 값이 3개를 초과하면, 최근 것 3개만 담는다.
				int start = ckList.size() -3;
				List<String> copyList = new ArrayList<String>();
				for (int i=start; i<ckList.size(); i++) {
					copyList.add(ckList.get(i));
				}
				ckList = copyList;
			}
		}
		return ckList;
	}
	
	 /**
	  * @description 쿠키를 생성 혹은 업데이트한다.
	  * @params key: 쿠키 이름, value: 쿠키 이름과 짝을 이루는 값, day: 쿠키의 수명
	  */
	public void setCookie(String key, String value, int day, HttpServletRequest req, HttpServletResponse res) 
			throws UnsupportedEncodingException{
		List<String> ckList = getValueList(key, req);
		String sumValue = "";
		int equalsValueCnt = 0;
		
		if (ckList != null) {
			for (int i=0; i<ckList.size(); i++) {
				sumValue += ckList.get(i) + ",";
				if (ckList.get(i).equals(value)) {
					equalsValueCnt++;
				}
			}
			if (equalsValueCnt != 0) {	// 같은 값을 넣으려고 할 때의 처리
				if (sumValue.substring(sumValue.length()-1).equals(",")) {
					sumValue = sumValue.substring(0, sumValue.length()-1);
				}
			} else {
				sumValue += value;
			}
		} else {
			sumValue = value;
		}
		if (!sumValue.equals("")) {
			Cookie cookie = new Cookie(key, URLEncoder.encode(sumValue, encoding));
			cookie.setMaxAge(60*60*24*day);
			cookie.setPath(path);
			res.addCookie(cookie);
		}
	}
}
