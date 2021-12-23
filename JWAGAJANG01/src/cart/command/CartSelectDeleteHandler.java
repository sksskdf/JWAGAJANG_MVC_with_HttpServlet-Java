package cart.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.dto.CartVO;
import common.command.CommandHandler;

public class CartSelectDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("POST")) {
				return processForm(req, res);
			} else {
				res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return null;
			}
		}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String[] chkarr = req.getParameterValues("chbox");
		int[] newchkarr = null;
		
		ArrayList<CartVO> cartList = (ArrayList<CartVO>) session.getAttribute("cartList");
		
		for (int i = 0; i < chkarr.length; i++) {
			newchkarr[i] = Integer.parseInt(chkarr[i]);
		}
		
		for (int i = 0; i < newchkarr.length; i++) {
			cartList.remove(newchkarr[i]);
		}
		
		return null;
	}
	
}


