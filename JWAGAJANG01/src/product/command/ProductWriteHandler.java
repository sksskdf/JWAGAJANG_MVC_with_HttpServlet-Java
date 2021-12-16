package product.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.command.CommandHandler;
import product.dao.ProductDAO;
import product.dto.ProductVO;

public class ProductWriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return "productWrite.jsp";	// view page를 반환
		}
		else if(request.getMethod().equalsIgnoreCase("POST")) {
			request.setCharacterEncoding("UTF-8");
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("upload");
			String encType = "UTF-8";
			int sizeLimit = 20 * 1024 * 1024;
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
					encType, new DefaultFileRenamePolicy());
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String description = multi.getParameter("description");
			String pictureUrl = multi.getFilesystemName("pictureUrl");
			ProductVO pVo = new ProductVO();
			pVo.setName(name);
			pVo.setPrice(price);
			pVo.setDescription(description);
			pVo.setPictureUrl(pictureUrl);
			ProductDAO pDao = ProductDAO.getInstance();
			pDao.insertProduct(pVo);
			// forward하지 않고 목록 보기로 redirect
			// forward 할 것인가? 리다이렉트 할 것인가? 판단을 해야 한다.
			// forward 할 때는 .jsp로 포워드(화면에 응답을 출력)
			// 리다이렉트 할 때는 *.do url을 사용한다.
			response.sendRedirect("list.do");
			return null;	// redirect를 할 경우 view page를 null로 반환
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
}