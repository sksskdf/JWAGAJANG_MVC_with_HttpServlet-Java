package member;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("MemberJoinAction안의 execute() 실행됨");
		req.setCharacterEncoding("UTF-8");
		
		//MemberBean 객체 생성후 데이터베이스로부터 정보저장
		MemberBean mb = new MemberBean();
		mb.setId(req.getParameter("id"));
		mb.setPw(req.getParameter("pw"));
		mb.setEmail(req.getParameter("email"));
		mb.setContact(req.getParameter("contact"));
		mb.setAddress1(req.getParameter("address1"));
		mb.setAddress2(req.getParameter("address2"));
		mb.setAddress3(req.getParameter("address3"));
		mb.setReg_date(new Timestamp(System.currentTimeMillis()));
		System.out.println("@@@@ Action : 전달받은 정보 MemberBean 객체 확인"+mb);
		
		//DB로부터 가져온 정보를 처리하기 위한 DAO객체 생성
		MemberDAO mdao = new MemberDAO();
		mdao.insertMember(mb);
		System.out.println("@@@@ Action : 디비작업처리완료");
		
		System.out.println("@@@@ Action : 페이지이동");
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberLogin.me");
		forward.setRedirect(true);
		return forward;
	}

}
