package product.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.bean.ProductDTO;
import product.dao.ProductDAO;

public class ProductWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//���� ����
		String realFolder = request.getServletContext().getRealPath("/storage");
		System.out.println(realFolder);
		
		//���ε�
		MultipartRequest multi = new MultipartRequest(request
													, realFolder
													, 5*1024*1024 //5mb
													, "UTF-8"
													, new DefaultFileRenamePolicy());
		
		//data
		String img = multi.getOriginalFileName("img");
		String name = multi.getParameter("name");
		int unit = Integer.parseInt(multi.getParameter("unit"));
		int qty = Integer.parseInt(multi.getParameter("qty")); 
		int total = unit*qty;
		int rate = Integer.parseInt(multi.getParameter("rate"));
		int discount = total*rate/100;
		int price = total-discount;
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setImg(img);
		productDTO.setName(name);
		productDTO.setUnit(unit);
		productDTO.setQty(qty);
		productDTO.setTotal(total);
		productDTO.setRate(rate);
		productDTO.setDiscount(discount);
		productDTO.setPrice(price);
		
		//DB
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.productWrite(productDTO);
		
		request.setAttribute("display", "/product/productWrite.jsp");
		return "/index.jsp";
	}

}
