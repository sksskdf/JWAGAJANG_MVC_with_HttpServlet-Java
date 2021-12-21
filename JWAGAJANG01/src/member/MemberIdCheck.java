package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberIdCheck implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("ID중복체크 execute() 호출");
		
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		
		MemberDAO mdao = new MemberDAO(); // 데이터베이스에 Access하기 위해 DAO객체 생성
		int check = mdao.idDupCheck(id);
		System.out.println("iddupcheck반환값: " + mdao.idDupCheck(id));
		
		if(check == 1) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('사용중인 아이디 입니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			return null;
		}
		if(check == 0) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('사용 가능한 아이디 입니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
		}
		if(check == -1) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('아이디 중복체크를 해주세요.');");
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
