package cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.Order;
import util.DBManager;

public class cartDao {
	private static cartDao instance = new cartDao();
	private cartDao() { }
	public static cartDao getInstance() {
		return instance;
	}
	
	public void buy(Connection conn,int md_code,String mdid) {
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO table_order(mdpic, mdname, mdprice, mdcode,mdid ) VALUES\r\n" + 
					"((SELECT img_main FROM table_md WHERE md_code = ?),(SELECT md_name FROM table_md WHERE md_code = ?),\r\n" + 
					"(SELECT md_price FROM table_md WHERE md_code = ?),(SELECT md_code FROM table_md WHERE md_code = ?), ?);";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, md_code);
			pstmt.setInt(2, md_code);
			pstmt.setInt(3, md_code);
			pstmt.setInt(4, md_code);
			pstmt.setString(5, mdid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt);
			
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
			
			mdname = rs.getString("md_name");
			System.out.println(md_code);
			System.out.println(mdname);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt);
		}
		return mdname;
	}
}
