// DAO : (Data Access Object) -> 
// DAO는 DB의 data에 접근하기 위한 객체로 직접 DB에 접근하여 데이터를 삽입, 삭제, 조회 등 조작할 수 있는 기능을 수행

package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import product.dto.ProductVO;
import util.DBManager;

public class ProductDAO {
	private static ProductDAO instance = null;
	public static ProductDAO getInstance() {
		if(instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}
	private ProductDAO() { }
	
	// 제품 목록 출력
	public List<ProductVO> selectAllProducts() {
		// code : auto_increment (1부터 시작 -> 내림차순) -> 최근 등록된 상품부터 보여주겠다.
		// 회원목록 : 정렬순서 (이름 가나다순, 최근 가입한 순서대로 -> 어떻게 정렬할 것인가? 정한다.)
		String sql = "select * from product order by code desc";	// 최근 등록 순
		List<ProductVO> list = new ArrayList<ProductVO>();	// 빈 목록을 생성
		// try-with-resource : 주의사항
		// 참조변수를 선언하고 그 주소를 얻을 수 있으면 ()안에 포함을 시킨다.
		try (Connection conn = DBManager.getConnection();	// CP사용하는 메소드를 DBManager.java로 빼냄
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 중간에 자원을 선언하는 것 외에 다른 실행문이 존재하면 사용할 수 없다. (ResultSet)
			ResultSet rs = pstmt.executeQuery();){
			while(rs.next()) {
				list.add(makeProductVO(rs));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 메소드로 만들어 준다.
	private ProductVO makeProductVO(ResultSet rs) throws SQLException {
		ProductVO pVo = new ProductVO();
		pVo.setMd_code(rs.getInt("md_code"));
		pVo.setMd_name(rs.getString("md_name"));
		pVo.setMd_price(rs.getInt("md_price"));
		pVo.setMd_dc(rs.getInt("md_dc"));
		pVo.setImg_main(rs.getString("img_main"));
		pVo.setImg_detail(rs.getString("img_detail"));
		pVo.setMd_regdate(rs.getTimestamp("md_regdate"));
		pVo.setMd_editdate(rs.getTimestamp("md_editdate"));
		pVo.setCategory_main(rs.getString("category_main"));
		pVo.setCategory_sub(rs.getString("category_sub"));
		pVo.setMd_ordercnt(rs.getInt("md_ordercnt"));
		
		return pVo;
	}
	
	public void insertProduct(ProductVO pVo) {
		String sql = "insert into product (md_name, md_price, img_main, img_detail) values(?, ?, ?, ?)";
		try (Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, pVo.getMd_name());
			pstmt.setInt(2, pVo.getMd_price());
			pstmt.setString(3, pVo.getImg_main());
			pstmt.setString(4, pVo.getImg_detail());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 제품에 대한 상세보기를 할 때, 제품 수정/삭제할 때 제품에 대한 정보를 보여주기 위해서 사용됨
	public ProductVO selectProductByCode(Integer md_code) {
		String sql = "select * from product where code = ?";
		ProductVO pVo = null;
		ResultSet rs = null;
		try (Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setInt(1, md_code);	// 중간에 실행문이 있으면 ResultSet을 ()안에 포함시킬수 없음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pVo = makeProductVO(rs);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs);	// rs만 반납
		}
		return pVo;
	}
	
	// update시는 변경 가능한 것과 변경 불가능한 것을 구분해서 처리
	public void updateProduct(ProductVO pVo) {
		String sql = "update product set md_name=?, md_price=?, pictureurl=?, description=? where md_code = ?";
		try (Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, pVo.getMd_name());
			pstmt.setInt(2, pVo.getMd_price());
			pstmt.setString(3, pVo.getImg_main());
			pstmt.setString(4, pVo.getImg_detail());
			pstmt.setInt(5, pVo.getMd_code());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//public void deleteProduct(Integer code) {
	//	String sql = "delete from product where code = ?";
	//	try (Connection conn = DBManager.getConnection();
	//		PreparedStatement pstmt = conn.prepareStatement(sql);){
	//		pstmt.setInt(1, code);
	//		pstmt.executeUpdate();
	//	} catch(Exception e) {
	//		e.printStackTrace();
	//	}
	//}
	
	public List<ProductVO> selectBestProduct() {
		String sql = "select md_code, md_name, md_price, md_dc, img_main from table_md order by md_ordercnt desc limit 4";
		List<ProductVO> list = new ArrayList<ProductVO>();
		try (Connection conn = DBManager.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				ProductVO pVo = new ProductVO();
				pVo.setMd_code(rs.getInt("md_code"));
				pVo.setMd_name(rs.getString("md_name"));
				pVo.setMd_price(rs.getInt("md_price"));
				pVo.setMd_dc(rs.getInt("md_dc"));
				pVo.setImg_main(rs.getString("img_main"));
				list.add(pVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ProductVO> selectNewProduct() {
		String sql = "select md_code, md_name, md_price, md_dc, img_main from table_md order by md_regdate desc limit 4;";
		List<ProductVO> list = new ArrayList<ProductVO>();
		try (Connection conn = DBManager.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				ProductVO pVo = new ProductVO();
				pVo.setMd_code(rs.getInt("md_code"));
				pVo.setMd_name(rs.getString("md_name"));
				pVo.setMd_price(rs.getInt("md_price"));
				pVo.setMd_dc(rs.getInt("md_dc"));
				pVo.setImg_main(rs.getString("img_main"));
				list.add(pVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}