package product.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class ProductListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/product/productList.jsp");
		return "/index.jsp";
	}

}
