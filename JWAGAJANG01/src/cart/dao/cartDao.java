package cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import goods.dto.GoodsVO;
import member.model.Order;
import util.DBManager;

public class cartDao {
	private static cartDao instance = new cartDao();
	private cartDao() { }
	public static cartDao getInstance() {
		return instance;
	}
	
	public void buy(Connection conn,int md_code,String mdid,Order order) {
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO table_order(mdpic, mdname, mdprice, mdcode, mdid,order_name,mobile,address,address2,orderrequest ) VALUES\r\n" + 
					"((SELECT img_main FROM table_md WHERE md_code = ?),(SELECT md_name FROM table_md WHERE md_code = ?),\r\n" + 
					"(SELECT md_price FROM table_md WHERE md_code = ?),(SELECT md_code FROM table_md WHERE md_code = ?), ?,?,?,?,?,?);";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, md_code);
			pstmt.setInt(2, md_code);
			pstmt.setInt(3, md_code);
			pstmt.setInt(4, md_code);
			pstmt.setString(5, mdid);
			pstmt.setString(6, order.getOrder_name());
			pstmt.setString(7, order.getMobile());
			pstmt.setString(8, order.getAddress());
			pstmt.setString(9, order.getAddress2());
			pstmt.setString(10, order.getOrderrequest());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt);
			DBManager.close(conn);
			
		}	
	}
	
	public String get_mdname(Connection conn,int md_code) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String mdname = null;
		try {
			String query = "select md_name from table_md where md_code = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, md_code);

			rs = pstmt.executeQuery();
			if(rs.next()) { //요놈
			GoodsVO gVo = new GoodsVO();
			gVo.setMd_name(rs.getString("md_name"));
			mdname = gVo.getMd_name();
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt);
			DBManager.close(conn);
		}
		return mdname;
	}
}
