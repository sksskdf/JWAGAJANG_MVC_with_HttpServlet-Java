package cart.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.dto.CartVO;
import common.command.CommandHandler;

public class CartPutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")|| 
			req.getMethod().equalsIgnoreCase("POST")) {
			return processForm(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<CartVO> cartList = null;
		
		Object obj = req.getAttribute("cart");	//세션 객체에서 cart 값을 가져온다.

		if(obj == null) {	//세션 정보가 없으면 배열을 생성 : 최초 주문한 경우
			cartList = new ArrayList<CartVO>();	
		} else {			//세션 정보가 있으면 강제로 캐스팅 : 추가 주문
			cartList = (ArrayList<CartVO>) obj;
		}
		
		
		return "cart.jsp";
	}

}
