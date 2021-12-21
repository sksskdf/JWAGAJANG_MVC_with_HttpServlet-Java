package goods.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.command.CommandHandler;
import goods.dao.GoodsDAO;
import goods.dto.GoodsVO;

public class GoodsListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}
		else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		String category_main = req.getParameter("category_main");
		String category_sub = req.getParameter("category_sub");
		String viewPage = "/list.jsp";
		GoodsDAO gDao = GoodsDAO.getInstance();
		List<GoodsVO> mdList;
		req.setAttribute("category_main", category_main);
		try {
			mdList = gDao.sortMd(category_main, category_sub);
			req.setAttribute("mdList", mdList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewPage;
	}

}
