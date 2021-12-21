package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("@@@@ Action: MemberLogoutAction안의 execute() 실행됨");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(); 
		session.invalidate();
		
		System.out.println("@@@@ Action : 로그아웃성공 후 페이지이동 ");		
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<script>");
		out.print("alert('정상적으로 로그아웃 되었습니다');");
		out.print("location.href='./Main.me';");
		out.print("</script>");
		out.close();
		return null;
	}
}
