package guestbook.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import guestbook.dao.GuestbookDAO;

public class GuestbookWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		
		String name = (String) session.getAttribute("memName");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("email", email );
		map.put("homepage", homepage);
		map.put("subject", subject);
		map.put("content", content);
		
		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		guestbookDAO.guestbookWrite(map);
		
		
		return "/guestbook/guestbookWrite.jsp";
	}

}
