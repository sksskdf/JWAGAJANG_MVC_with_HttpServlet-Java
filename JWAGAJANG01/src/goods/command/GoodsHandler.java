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
		
		// 상품
		GoodsDAO gDao = GoodsDAO.getInstance();
		GoodsVO md = gDao.getMd(md_code);
		
		req.setAttribute("md", md);
		req.setAttribute("md_code", md_code);
		
		// 리뷰수 
		List<GoodsVO> reviewList;
	
		int count = gDao.reviewCount(md_code);
		
		if (count > 0) {
			reviewList = gDao.getReview(count);
			req.setAttribute("reviewList", reviewList);
		}
		
		req.setAttribute("count", new Integer(count));

		
		return "/goods.jsp";
	}

}
