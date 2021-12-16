package product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.command.CommandHandler;
import product.dao.ProductDAO;
import product.dto.ProductVO;

public class ProductListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("GET") || 
				request.getMethod().equalsIgnoreCase("POST")) {
			ProductDAO pDao = ProductDAO.getInstance();
			List<ProductVO> productList = pDao.selectAllProducts();
			request.setAttribute("productList", productList);
			return "productList.jsp";	// view 페이지를 반환
		}
		else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

}
