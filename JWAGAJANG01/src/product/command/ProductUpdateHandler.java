package product.command;

import java.io.File;
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

public class ProductUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			// GET 메소드가 동작
			String code = request.getParameter("code");
			ProductDAO pDao = ProductDAO.getInstance();
			ProductVO pVo = pDao.selectProductByCode(Integer.parseInt(code));
			request.setAttribute("product", pVo);
			return "productUpdate.jsp";	// 제품수정 page
		}
		else if(request.getMethod().equalsIgnoreCase("POST")) {
			// POST 메소드가 동작
			// 기존 이미지 -> 새로운 이미지 변경 : 기존 이미지 파일을 삭제 -> 고려되어 있지 않음
			// 기존 이미지를 그대로 유지
			request.setCharacterEncoding("UTF-8");
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("upload");
			String encType = "UTF-8";
			int sizeLimit = 20 * 1024 * 1024;
			// 새로운 이미지 파일은 자동으로 저장이 됨
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
					encType, new DefaultFileRenamePolicy());
			String code = multi.getParameter("code");
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String description = multi.getParameter("description");
			String pictureUrl = multi.getFilesystemName("pictureUrl");
			if (pictureUrl == null) {	// 새로운 이미지로 대체하지 않음
				pictureUrl = multi.getParameter("nonmakeImg");	// 기존 이미지를 유지
			} else {	// 변경됨
				String oldUrl = multi.getParameter("nonmakeImg");	// 이전 파일의 이름
				// oldUrl 파일을 삭제
				File oldFile = new File(path + File.separator + oldUrl);
				if(oldFile.exists()) {
					oldFile.delete();	// 파일을 삭제
				}
			}
			ProductVO pVo = new ProductVO();
			pVo.setCode(Integer.parseInt(code));
			pVo.setName(name);
			pVo.setPrice(price);
			pVo.setDescription(description);
			pVo.setPictureUrl(pictureUrl);
			ProductDAO pDao = ProductDAO.getInstance();
			pDao.updateProduct(pVo);
			response.sendRedirect("list.do"); // 브라우저
			return null;
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
}