package cart.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.service.BuyService;
import common.command.CommandHandler;
import member.model.Order;

public class BuyHandler implements CommandHandler {
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

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		System.out.println(id);
		if(id == null) { //로그인 검사
			System.out.println("로그인 실패");
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter writer;
			writer = res.getWriter();
			writer.println("<script>alert('로그인 후 이용해주세요.');</script>"); 
			writer.println("<script>location.href=\"/login.do\";</script>");
			writer.close();
		}
		String md_code = req.getParameter("md_code");
		
		int md_code_ = Integer.parseInt(md_code);
		BuyService buyservice = BuyService.getInstance();
		String mdname = buyservice.get_mdname(md_code_);
		Order orderinfo = buyservice.get_orderInfo(id);
		
		req.setAttribute("md_name", mdname);
		req.setAttribute("orderinfo", orderinfo);
		System.out.println("handler console md_name"+mdname);
		return "order.jsp";
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String md_id = (String)session.getAttribute("id");
		String md_code = req.getParameter("md_code");
		
		Order order = new Order();
		order.setOrder_name(req.getParameter("name"));
		order.setMobile(req.getParameter("phone"));
		order.setAddress(req.getParameter("address"));
		order.setAddress2(req.getParameter("addDetail"));
		order.setOrderrequest(req.getParameter("request"));
		
		int md_code_ = Integer.parseInt(md_code);
		BuyService buyservice = BuyService.getInstance();
		buyservice.buy(md_code_,md_id,order);
		
		
		
		
		
		return "complete.do";
	}

}
