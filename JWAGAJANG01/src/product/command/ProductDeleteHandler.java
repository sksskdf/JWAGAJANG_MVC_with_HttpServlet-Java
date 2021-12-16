package product.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.command.CommandHandler;
import product.dao.ProductDAO;
import product.dto.ProductVO;

public class ProductDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			Integer code = Integer.valueOf(request.getParameter("code"));
			ProductDAO pDao = ProductDAO.getInstance();
			ProductVO pVo = pDao.selectProductByCode(code);
			request.setAttribute("product", pVo);
			return "productDelete.jsp";
		}
		else if(request.getMethod().equalsIgnoreCase("POST")) {
			// 문제점 : 이미지 파일이 남는 것이 문제 (이미지 파일이 존재하면 파일을 삭제해 주어야 함)
			Integer code = Integer.valueOf(request.getParameter("code"));
			ProductDAO pDao = ProductDAO.getInstance();
			// 문제점 -> 해결방법
			// - 이미지 파일 삭제 한다.
			//   + 제품 정보를 검색(데이터베이스 검색)하여 파일의 이름을 찾는다.
			ProductVO pVo = pDao.selectProductByCode(code);
			//   + 파일을 삭제한다.
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("upload");
			File oldFile = new File(path + File.separator + pVo.getPictureUrl());
			if(oldFile.exists()) {
				oldFile.delete();	// 파일을 삭제
			}
			pDao.deleteProduct(code);
			response.sendRedirect("list.do");
			return null;
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
}