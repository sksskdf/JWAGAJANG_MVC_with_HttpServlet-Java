package product.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.command.CommandHandler;
import member.model.Member;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import notice.dao.NoticeDAO;
import product.dao.ProductDAO;
import product.dto.ProductVO;
import product.service.ProductService;
import product.service.ProductServiceImpl;

public class ProductWriteHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}
		else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return "productWrite.jsp";
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String md_name = req.getParameter("md_name");
		String md_price = req.getParameter("md_price");
		String md_dc = req.getParameter("md_dc");
		String md_stock = req.getParameter("md_stock");
		String img_main = req.getParameter("img_main");
		String img_detail = req.getParameter("img_detail");
		String category_main = req.getParameter("category_main"); 
		String category_sub = req.getParameter("category_sub");
		
		ProductVO bVo = new ProductVO();
		bVo.setMd_name(md_name);
		bVo.setMd_price(Integer.parseInt(md_price));
		bVo.setMd_dc(Integer.parseInt(md_dc));
		bVo.setImg_main(img_main);
		bVo.setImg_detail(img_detail);
		bVo.setCategory_main(category_main);
		bVo.setCategory_sub(category_sub);
		
		ProductDAO bDao = ProductDAO.getInstance();
		bDao.insertProduct(bVo);
		res.sendRedirect("productList.do");
		
		ProductService productService = ProductServiceImpl.getInstance();
		productService.add(bVo);
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter writer;
		writer = res.getWriter();
		writer.println("<script>alert('등록되었습니다.');</script>"); 
		writer.close();
		return null;
	}

}
