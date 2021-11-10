package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardModifyService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//data
		String seq = request.getParameter("seq");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		map.put("subject", subject);
		map.put("content", content);
		
		//db
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardModify(map);
		//응답
		
		return "/board/boardModify.jsp";
	}

}
