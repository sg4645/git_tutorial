package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.dao.ImageboardDAO;

public class ImageboardDeleteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//data
		String[] choice = request.getParameterValues("choice");
		
		//DB
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		imageboardDAO.imageboardDelete(choice);
		
		
		request.setAttribute("display", "/imageboard/imageboardDelete.jsp");
		return "/index.jsp";
	}

}
