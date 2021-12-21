package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	//DB에 접속하기 위한 객체들을 준비
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	//1. DB연결메서드
	public Connection getCon() throws Exception{
		Context init= new InitialContext();
		//Context.xml의 주소와 동일해야함
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/model2DB"); 
		con = ds.getConnection();
		return con;
	}//end of getCon()
	
	
	//2. 자원해제 메서드 구현
	public void closeDB(){
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}//closeDB()
	
	//3. 회원가입처리 (외부에서 접근가능해야하니까 public)
	public void insertMember(MemberBean mb){ //파라미터로 정보를 받아서 DB에 저장
		try {
			//3-1. DB연결메서드 불러오기
			con = getCon();
			//3-2. SQL & pstmt 생성 & 실행
			sql = "insert into user values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPw());
			pstmt.setString(3, mb.getEmail());
			pstmt.setString(4, mb.getAddress1());
			pstmt.setString(5, mb.getAddress2());
			pstmt.setString(6, mb.getAddress3());
			pstmt.setString(7, mb.getContact());
			pstmt.setTimestamp(8, mb.getReg_date());
			//insertForm에는 reg_date를 입력하는 란이 없기에 mb에 따로 넣어줘야한다.
			//즉, 파라미터로 전달되지 않는 정보는 insertForm에서 직접생성
			pstmt.executeUpdate();
			System.out.println("회원가입성공");
		} catch (SQLException e) {
			System.out.println("SQL구문 오류로 회원가입실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("회원가입실패");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
	}
	public int idCheck(String id, String pw){
		int result = -1;
		try {
			con = getCon();
			sql = "select PASSWORD from user where ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(pw.equals(rs.getString("PASSWORD"))){
					result = 1;
				}else{
					result = 0;
				}
			}else{
				result = -1;
			}	
			System.out.println("@@@@ DAO : 로그인처리완료 "+result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//상관없이 무조건 실행
		finally {
			closeDB();
		}
		return result;
	}
	
	
	
	public int idDupCheck(String id) {
		int result = -1; //-1이면 중복체크가 아직 안된것
		try {
			con = getCon();
			sql = "select ID from user where ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
		if(rs.next()) {
			if(id.equals(rs.getString("ID"))){
				result = 1; //1이면 중복인 아이디
			}else{
				result = 0; //0이면 사용가능한 아이디
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return result;
	}
}
