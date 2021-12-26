package goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import goods.dto.GoodsVO;
import util.DBManager;

public class GoodsDAO {
	
	private static GoodsDAO instance = new GoodsDAO();
	
	public static GoodsDAO getInstance() {
		return instance;
	}
	
	private GoodsDAO() { }
	
	// 상품 분류
	public List<GoodsVO> sortMd(String category_main, String category_sub, String order) throws Exception {
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
			
			if(category_main.equals("All") || category_main.equals("")) {
				pstmt = conn.prepareStatement(sqlAll);
			} else {
				pstmt = conn.prepareStatement(sqlCate);
				pstmt.setString(1, category_main);
				
				if(category_sub != null && !category_sub.isEmpty()) {
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
	
	// 검색
	public List<GoodsVO> searchResult(String md_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("select * from table_md where " + md_name + " like ?");
			pstmt.setString(1, "%"+md_name+"%");
			rs = pstmt.executeQuery();
			
			return result(rs);
		}
	}
	
	// 최근 본 상품
	@SuppressWarnings("unchecked")
	public void addGoodsInQuick(int md_code, GoodsVO goodsVO, HttpSession session) {
		boolean already_existed = false;
		List<GoodsVO> quickGoodsList;
		quickGoodsList = (ArrayList<GoodsVO>)session.getAttribute("quickGoodsList");	// 세션에 저장된 최근 본 상품 목록 가져옴
		
		if (quickGoodsList != null)	{	// 최근 본 상품이 있는 경우
			if(quickGoodsList.size() < 4) {	// 상품 목록이 네 개 이하인 경우
				for (int i=0; i<quickGoodsList.size(); i++) {
					GoodsVO gVo = (GoodsVO)quickGoodsList.get(i);
					if (md_code == gVo.getMd_code()) {
						already_existed = true;
						break;
					}
				}	// 상품 목록을 가져와 이미 존재하는 상품인지 비교, 이미 존재할 경우 already_existed를 true로 설정
				if (already_existed == false) {
					quickGoodsList.add(goodsVO);					// false면 상품 정보를 목록에 저장
				}
			}
		} else {
			quickGoodsList = new ArrayList<GoodsVO>();	// 최근 본 상품 목록이 없으면 생성하여 정보 저장
			quickGoodsList.add(goodsVO);
		}
		session.setAttribute("quickGoodsList", quickGoodsList);	// 최근 본 상품 목록을 세션에 저장
		session.setAttribute("quickGoodsListNum", quickGoodsList.size());	// 최근 본 상품 목록에 저장된 상품 개수를 세션에 저장
	}
	
}
