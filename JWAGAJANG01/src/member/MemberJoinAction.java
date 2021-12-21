package member;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberJoinAction implements Action {
	
	//action 인터페이스의 execute 함수 재정의해서 사용
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("MemberJoinAction안의 execute() 실행됨");
		
		//request객체를 이용해 jsp를 통해 값을 받을때 한글에 대한 처리를 해줘야함.
		req.setCharacterEncoding("UTF-8");
		
		//MemberBean 객체 생성후 데이터베이스로부터 정보저장
		MemberBean mb = new MemberBean();
		mb.setId(req.getParameter("id"));
		mb.setPw(req.getParameter("password"));
		mb.setEmail(req.getParameter("email"));
		mb.setContact(req.getParameter("contact"));
		mb.setAddress1(req.getParameter("address1"));
		mb.setAddress2(req.getParameter("address2"));
		mb.setAddress3(req.getParameter("address3"));
		mb.setReg_date(new Timestamp(System.currentTimeMillis()));
		System.out.println("@@@@ Action : 전달받은 정보 MemberBean 객체 확인"+mb);
		
		String id = req.getParameter("id");
		
		//DB로부터 가져온 정보를 처리하기 위한 DAO객체 생성
		MemberDAO mdao = new MemberDAO();
		MemberDAO iddupcheck = new MemberDAO();
		if(iddupcheck.idDupCheck(id) == -1) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('아이디 중복체크를 해주세요.');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
		}else if(iddupcheck.idDupCheck(id) == 0) {
			mdao.insertMember(mb);
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('회원가입을 축하드립니다.');");
			out.print("</script>");
			out.close();
			ActionForward forward = new ActionForward();
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}else if(iddupcheck.idDupCheck(id) == 1) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('이미 사용중인 아이디 입니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberJoin.me");
		forward.setRedirect(false);
		return forward;
	}

}
