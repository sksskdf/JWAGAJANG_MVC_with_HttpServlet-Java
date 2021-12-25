package qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.command.CommandHandler;
import qna.dto.QnaVO;

public class RepleWriteHandler implements CommandHandler {

   @Override
   public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
      int md_code = Integer.parseInt(req.getParameter("md_code"));
      String user_id = req.getParameter("user_id");
      int review_rate = Integer.parseInt(req.getParameter("review_rate"));
      String review_content = req.getParameter("review_content");
      
      QnaVO qVo = new QnaVO();
      qVo.setUser_id(user_id);
      qVo.setleg_date(review_rate);
      qVo.setReview_content(review_content);
   
      
      ReviewDAO rDao = ReviewDAO.getInstance();
      int review_code = rDao.insertReview(rVo);
      
      ReviewVO added = rDao.getReview(review_code);
      req.setAttribute("review", added);
      
      return "goodsReview.jsp";
   }

}