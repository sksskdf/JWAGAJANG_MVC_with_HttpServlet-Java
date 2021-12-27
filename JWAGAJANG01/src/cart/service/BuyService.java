package cart.service;

import java.sql.Connection;
import java.sql.SQLException;

import cart.dao.cartDao;
import member.model.Order;
import util.DBManager;

public class BuyService {
	private static BuyService instance = new BuyService();
	public static BuyService getInstance() {
		return instance;
	}
	private BuyService() {}
	
	public void buy(int md_code,String md_id) {
		cartDao cDao = cartDao.getInstance();
		Connection conn = null;
		
		conn = DBManager.getConnection();
		cDao.buy(conn,md_code,md_id);
		
		DBManager.close(conn);
	
	}
	
	public String get_mdname(int md_code) {
		cartDao cDao = cartDao.getInstance();
		Connection conn = null;
		
		conn = DBManager.getConnection();
		
		return cDao.get_mdname(conn,md_code);
	}
}
