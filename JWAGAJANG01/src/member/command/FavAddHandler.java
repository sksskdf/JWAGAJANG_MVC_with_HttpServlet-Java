package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.command.CommandHandler;
import member.model.Fav;
import member.service.FavService;

public class FavAddHandler implements CommandHandler {
	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int mdcode = Integer.parseInt(req.getParameter("mdcode"));
		String userid = req.getParameter("userid");
		
		
		Fav fav = new Fav(mdcode,userid);
		
		FavService fs = FavService.getInstance();
		fs.insert(fav);
		
		
		return "goods.do?md_code="+mdcode;
	}
}
