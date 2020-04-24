package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "/test",
		urlPatterns="/test",
		initParams = {@WebInitParam(name="encoding", value="utf-8"),
						@WebInitParam(name="content", value="text/http; charset=utf-8")
		})
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String encoding = null;
    private String content = null;
    
	public void init(ServletConfig config) throws ServletException{
		encoding = config.getInitParameter("encoding");
		content = config.getInitParameter("content");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType(content);
		ServletContext sc = request.getServletContext();
		
		PrintWriter out = response.getWriter();
		out.println("test servlet doGet()");
		
		out.println(sc.getAttribute("serverName"));
		
		request.setAttribute("you", "me");
		request.setAttribute("you", "you");
		request.removeAttribute("you");
		
		
		out.println("세션을 생성할 것이다.");
		HttpSession session = request.getSession();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		session.setAttribute("data", "love");
		session.setAttribute("data", "me");
		session.removeAttribute("data");
		
		out.println("세션을 삭제하겠다.");
		session.invalidate();
		

	}

}
