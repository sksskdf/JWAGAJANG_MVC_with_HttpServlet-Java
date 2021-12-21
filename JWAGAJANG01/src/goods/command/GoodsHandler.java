package goods.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.command.CommandHandler;
import goods.dao.GoodsDAO;
import goods.dto.GoodsVO;

public class GoodsHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		List<GoodsVO> mdDetail;
		Integer md_code = Integer.parseInt(req.getParameter("md_code"));
		
		GoodsDAO gDao = GoodsDAO.getInstance();
		GoodsVO md = gDao.getMd(md_code);
		
		req.setAttribute("md", md);
		req.setAttribute("md_code", md_code);
		return "/goods.jsp";
	}

}
