package member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.Order;
import util.DBManager;

public class FavDao {
	private static FavDao instance = new FavDao();
	public static FavDao getInstance() {
		return instance;
	}
	
	public List<Order> select(Connection conn,String id,String page) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;
		List<Order> favlist = new ArrayList<>();
		int page_ = Integer.parseInt(page);
		
		try {
			String query = "SELECT *\r\n"
					+ "FROM\r\n"
					+ "(\r\n"
					+ "  SELECT \r\n"
					+ "      @rownum:=@rownum+1  rnum, \r\n"
					+ "      jwagajang.table_fav.* \r\n"
					+ "  FROM \r\n"
					+ "      jwagajang.table_fav, \r\n"
					+ "      (SELECT @ROWNUM := 0) R\r\n"
					+ "  WHERE \r\n"
					+ "      1=1\r\n"
					+ ") list\r\n"
					+ "WHERE rnum >= ? AND rnum <= ? AND user_id = ?;";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 1+(page_-1)*5);// 등차수열 1 + (page_ - 1) * 5
			pstmt.setInt(2, page_*5);
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mdpic = rs.getString("order_pic");
				String mdname = rs.getString("order_name");
				Date mdorderdate = rs.getDate("order_regdate");
				String mdprice = rs.getString("order_price");
				
				order = new Order(
						mdpic,mdname,mdorderdate,mdprice
						);

				favlist.add(order);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt);
			DBManager.close(rs);
			DBManager.close(conn);
		}
		
		
		return favlist;
	}
	
	public int count(Connection conn,String id) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String query = "SELECT count(*)\r\n"
					+ "FROM\r\n"
					+ "(\r\n"
					+ "  SELECT \r\n"
					+ "      @rownum:=@rownum+1  rnum, \r\n"
					+ "      jwagajang.table_fav.* \r\n"
					+ "  FROM \r\n"
					+ "      jwagajang.table_fav, \r\n"
					+ "      (SELECT @ROWNUM := 0) R\r\n"
					+ "  WHERE \r\n"
					+ "      1=1\r\n"
					+ ") list\r\n"
					+ "WHERE user_id = ?;";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(pstmt);
			DBManager.close(rs);
			DBManager.close(conn);
		}
		
		return count;
	}
	
	public void delete(Connection conn,String id,String mdname) {
		PreparedStatement pstmt = null;
		try {
			String query = "DELETE FROM `jwagajang`.`table_fav` WHERE (`order_name` = ?  and `user_id` = ?);";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mdname);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(pstmt);
			DBManager.close(conn);
		}
	}
}
