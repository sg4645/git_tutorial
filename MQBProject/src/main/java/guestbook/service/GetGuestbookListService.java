package guestbook.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetGuestbookListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		//
		int pg = Integer.parseInt(request.getParameter("pg"));
		//
		int endNum = pg * 3;
		int startNum = endNum - 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		List<GuestbookDTO> list = guestbookDAO.getGuestbookWrite(map);
		
		//¼¼¼Ç
		HttpSession session= request.getSession();
		String memId= (String)session.getAttribute("memId");
		
		//List -> json
		JSONObject json = new JSONObject();
		
		if(list != null) {
			JSONArray array = new JSONArray();
			for(GuestbookDTO guestbookDTO : list) {
				JSONObject temp = new JSONObject();
				temp.put("seq", guestbookDTO.getSeq());
				temp.put("name", guestbookDTO.getName());
				temp.put("email", guestbookDTO.getEmail());
				temp.put("homepage", guestbookDTO.getHomepage());
				temp.put("subject", guestbookDTO.getSubject());
				temp.put("content", guestbookDTO.getContent());
				temp.put("logtime", sdf.format(guestbookDTO.getLogtime()));
				
				array.add(temp);
			}//for
			json.put("list", array);
			
			
		}//if
		
		request.setAttribute("list", json);
		return "/guestbook/getGuestbookList.jsp";
	}

}
