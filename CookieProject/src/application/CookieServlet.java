package application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset='utf-8'");
		Cookie cookie = new Cookie("name", request.getParameter("name"));
		cookie.setMaxAge(1*24*60*60);
//		cookie.setDomain("powerlinux.co.kr");
//		cookie.setPath("/");
		
		response.addCookie(cookie);
		response.getWriter().println("dd");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
