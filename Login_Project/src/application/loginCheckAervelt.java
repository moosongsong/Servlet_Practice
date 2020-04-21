package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginCheck")
public class loginCheckAervelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();		
		boolean find = false;
		HttpSession session = request.getSession(false);
		try {
			
			Enumeration<String> atts = session.getAttributeNames();
			while (atts.hasMoreElements()) {
				String atr = (String) atts.nextElement();
				if (atr.equals("email")) {
					find=true;
					break;
				}
			}		
		} catch (NullPointerException e) {
			
		} finally {
			if(find==false) {
				out.println("{result:false, mesage:'현재로그인아님'}");
			}else {
				out.println("{result:true, mesage:'현재로그인'}");
			}
		}

	}

}
