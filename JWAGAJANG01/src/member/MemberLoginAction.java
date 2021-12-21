package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("@@@@ Action: MembeLoginAction안의 execute() 실행됨");

		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberDAO mdao = new MemberDAO();
		int check = mdao.idCheck(id, pw);
		
		System.out.println("@@@@ Action : 페이지이동 "+check);
		System.out.println(id);
		System.out.println(pw);
		
		if(check == 0){
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('비밀번호오류');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			return null;
		}else if(check == -1){
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('존재하지 않는 아이디입니다');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			return null;			
		}
		if (check == 1){
			HttpSession session = req.getSession(); 
			session.setAttribute("id", id);
			System.out.println("로그인 된 id : " + id);
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("./Main.me");
		forward.setRedirect(true);			
		return forward;
	}
}
