package product.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.command.CommandHandler;
import member.service.MemberServiceImpl;
import product.command.*;
import product.dao.*;
import product.dto.*;
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
		}
		else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return "productWrite.jsp";
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String md_code = req.getParameter("md_code");
		String md_name = req.getParameter("md_name");
		String md_price = req.getParameter("md_price");
		String md_dc = req.getParameter("md_dc");
		String img_main = req.getParameter("img_main");
		String img_detail = req.getParameter("img_detail");
		String md_regdate = req.getParameter("md_regdate");
		String md_editdate = req.getParameter("md_editdate");
		String category_main = req.getParameter("category_main");
		String category_sub = req.getParameter("category_sub");
		String md_ordercnt = req.getParameter("md_ordercnt");		
		ProductVO product = new ProductVO(md_code, md_name, md_price, md_dc, img_main, img_detail, md_regdate, md_editdate, category_main, category_sub, md_ordercnt);
		ProductService productService = ProductServiceImpl.getInstance();
		ProductService.add(product);
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter writer;
		writer = res.getWriter();
		writer.println("<script>alert('등록되었습니다.');</script>"); 
		writer.println("<script>location.href=\"productWrite.do?id="+md_code+"\";</script>");
		writer.close();
		return null;
	}

}
