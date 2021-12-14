package member.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import common.command.CommandHandler;
import member.model.Member;
import member.service.MemberService;
import member.service.MemberServiceImpl;

public class JoinMemberHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}
		else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}
		else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return "/member/join.jsp";
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		Member member = new Member(id, pwd, mobile , email);
		MemberService memberService = MemberServiceImpl.getInstance();
		memberService.add(member);
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter writer;
		writer = res.getWriter();
		writer.println("<script>alert('회원가입을 축하드립니다!');</script>"); 
		writer.println("<script>location.href=\"login.do?id="+id+"\";</script>");
		writer.close();
		return null;
	}

}
