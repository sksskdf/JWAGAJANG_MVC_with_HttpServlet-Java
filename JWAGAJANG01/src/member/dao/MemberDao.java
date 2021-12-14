package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.Member;
import util.DBManager;


public class MemberDao {
	//싱글톤패턴
	private static MemberDao instance = new MemberDao();
	private MemberDao() { }
	public static MemberDao getInstance() {
		return instance;
	}
	//회원정보 불러오기
	public Member getMember(Connection conn, String id, String password) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			String query = "select * from member where id=? and pwd=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = makeMemberFromResultSet(rs);
			}
		} finally {
			DBManager.close(rs);
			DBManager.close(pstmt);
		}
		return member;
	}
	//ID 선택
	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return null;
			}
			Member item = makeMemberFromResultSet(rs);
			return item;
		} finally {
			System.out.println("rs : "+rs);
			DBManager.close(rs);
			DBManager.close(pstmt);
		}
	}
	
	//ResultSet에 저장된 DB정보를 membervo에 저장.
	public Member makeMemberFromResultSet(ResultSet rs) throws SQLException {
		Member member = new Member();
		member.setId(rs.getString("id"));
		member.setPwd(rs.getString("pwd"));
		member.setMobile(rs.getString("mobile"));
		member.setEmail(rs.getString("email"));
		member.setCreatedAt(rs.getTimestamp("createdAt"));
		member.setModifiedAt(rs.getTimestamp("modifiedAt"));
		return member;
	}
	
	public int insert(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		//기본값은 -1로 초기화
		int result = -1;
		try {
			String query = "insert into member (id, pwd, email, mobile"
					+ ") values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getMobile());
			result = pstmt.executeUpdate();
			//System.out.println("result = " + result);
		} finally {
			DBManager.close(pstmt);
		}
		return result;
	}
	public void update(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String query = "UPDATE `jwagajang`.`member` \r\n"
					+ "SET \r\n"
					+ "	`pwd` = ?, \r\n"
					+ "	`mobile` = ?, \r\n"
					+ "	`address` = ?, \r\n"
					+ "	`address2` = ?, \r\n"
					+ "	`address3` = ?, \r\n"
					+ "	`email` = ?\r\n"
					+ " WHERE (`id` = ?);";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getMobile());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getAddress2());
			pstmt.setString(5, member.getAddress3());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getId());
			System.out.println();
			pstmt.executeUpdate();
			System.out.println(member.toString());
		} finally {
			DBManager.close(pstmt);
		}

	}
}
