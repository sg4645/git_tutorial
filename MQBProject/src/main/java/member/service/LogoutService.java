package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		
		//�듅�젙 �꽭�뀡 �젣嫄�
		session.removeAttribute("memName");
		session.removeAttribute("memId");
					
		//紐⑤뱺 �꽭�뀡 �젣嫄�
		session.invalidate();//臾댄슚�솕
		
		return "/member/logout.jsp";
	}

}
