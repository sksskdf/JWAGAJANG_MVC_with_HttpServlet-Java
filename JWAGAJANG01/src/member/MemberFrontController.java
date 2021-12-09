package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet{
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException{
		
		System.out.println("doProcess메서드 호출");

		
		String requestURI = req.getRequestURI();
		StringBuffer requestURL = req.getRequestURL();
		
		System.out.println("리퀘스트uri: "+ requestURI); 
		System.out.println("리퀘스트url: "+ requestURL); 
		
		String contextPath = req.getContextPath();
		System.out.println("contextPath: "+ contextPath);
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("잘 짤렸는지 가상주소 command: "+command);

		//여러번 쓸 수 있게 처리.
		//if문이 처리가 안 될 시 null로 미리 선언을 해놓고 null을 반환함으로써 따로 처리를 할 수 있음.
		Action action = null;
		ActionForward forward = null;

		if(command.equals("/MemberJoin.me")){
			System.out.println("/MemberJoin.me 호출");
			
			forward = new ActionForward();
			forward.setPath("./join.jsp");
			forward.setRedirect(false); 
		}else if(command.equals("/MemberJoinAction.me")){ 
			System.out.println("/MemberJoinAction.me 주소 호출");
			
			action = new MemberJoinAction();
			try {
				System.out.println("@@@@ Controller : MemberJoinAction 객체생성완료 후 excute()호출완료");
				forward = action.execute(req, resp);
				System.out.println("@@@@ Controller : 회원가입 처리완료 후 페이지 이동"+forward);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberLogin.me")){
			forward = new ActionForward();
			forward.setPath("./login.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/MemberLoginAction.me")){
			action = new MemberLoginAction();
			try {
				System.out.println("@@@@ Controller : MembeLoginAction 객체생성완료 후 excute()호출완료");
				forward = action.execute(req, resp);
				System.out.println("@@@@ Controller : 로그인 처리완료 후 페이지 이동"+forward);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//메인페이지
		}else if(command.equals("/Main.me")){ 
			System.out.println("Main.me 입력받음");
			forward = new ActionForward();
			forward.setPath("./index.jsp");
			forward.setRedirect(false);
			try {
				forward =  action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberLogout.me")){
			System.out.println("@@@@ Controller : 가상주소 /MemberLogout.me 실제주소: ./member/MemberLogoutAction.java");
			action = new MemberLogoutAction();
			try {
				forward =  action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//forward에 담아놓은 path,Redirect 값을 검사하여 실질적으로 페이지이동을 시키는 부분
		//1.forward가 null이 아닌지를 먼저 체크한다.
		//2.null이 아니라면 위의 조건식에 의해 path와redirect가 set됐을 것이다.
		//3.isredirect의 데이터타입은 boolean형 , true라면 response객체의 sendRedirect함수를 이용해
		if(forward != null){
			System.out.println("@@@페이지이동@@@");
			if(forward.isRedirect()){
				System.out.println("sendRedirect방식의 이동"+forward.getPath());
				resp.sendRedirect(forward.getPath());
			}else{
				System.out.println("RequestDispatcher방식의 이동"+forward.getPath());
				RequestDispatcher dis = req.getRequestDispatcher(forward.getPath());
				dis.forward(req, resp);
			}
		}
	}
	
	
	//get post 구분없이 둘다 process로 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost호출");
		doProcess(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet호출");
		doProcess(req,resp);
	}
}
