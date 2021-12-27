package cart.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.service.BuyService;
import common.command.CommandHandler;

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

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		String md_code = req.getParameter("md_code");
		
		int md_code_ = Integer.parseInt(md_code);
		BuyService buyservice = BuyService.getInstance();
		String mdname = buyservice.get_mdname(md_code_);
		req.setAttribute("md_name", mdname);
		return "order.jsp";
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String md_id = (String)session.getAttribute("id");
		String md_code = req.getParameter("md_code");
		
		int md_code_ = Integer.parseInt(md_code);
		BuyService buyservice = BuyService.getInstance();
		buyservice.buy(md_code_,md_id);
		
		
		
		
		
		return "main.do";
	}

}
