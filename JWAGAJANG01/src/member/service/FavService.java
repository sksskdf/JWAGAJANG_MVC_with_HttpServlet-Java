package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import member.dao.FavDao;
import member.dao.OrderDao;
import member.model.Fav;
import member.model.Order;
import util.DBManager;

public class FavService {
	private static FavService instance = new FavService();
	public static FavService getInstance() {
		return instance;
	}
	private FavService() {
	}
	
	public List<Order> getFavList(String id,String page) {
		FavDao fDao = FavDao.getInstance();
		Connection conn = null;
		
		conn = DBManager.getConnection();
		
		
		return fDao.select(conn,id,page);
		
	}
	
	public int getCount(String id) {
		FavDao fDao = FavDao.getInstance();
		Connection conn = null;
		
		conn = DBManager.getConnection();
		
		
		return fDao.count(conn, id);
	}
	
	public void del(String id,String mdname) {
		FavDao fDao = FavDao.getInstance();
		Connection conn = null;
		
		conn = DBManager.getConnection();

		fDao.delete(conn, id, mdname);
	}
	
	public void insert(Fav fav) {
		FavDao fDao = FavDao.getInstance();
		
		Connection conn = null;
		
		conn = DBManager.getConnection();

		fDao.insert(conn,fav);
	}
}
