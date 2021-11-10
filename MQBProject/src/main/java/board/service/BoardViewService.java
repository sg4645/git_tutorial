package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("seq", seq);
		request.setAttribute("display", "/board/boardView.jsp");
		return "/index.jsp";
	}

}
