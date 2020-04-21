package application;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
//	ServletConfig config = null;
	public void init(ServletConfig config) {
//		this.config=config;//최초 이 클래스에 대한 요청이 들어왔을때
		ServletContext sc = config.getServletContext();
//		System.out.println(sc.getInitParameter("address"));
		
		String jdbcURL = sc.getInitParameter("jdbcURL");
		String database = sc.getInitParameter("database");
		String DBUser = sc.getInitParameter("DBUser");
		String pass = sc.getInitParameter("DBPass");
		StringBuffer sb = new StringBuffer();
		sb.append(jdbcURL).append("/").append(database).append("?").append("user=").append(DBUser).append("&").append("password=").append(pass);
		System.out.println(sb);
		
		
		sc.setAttribute("URL", sb.toString());
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletContext sc = config.getServletContext();
//		sc.setAttribute("name", "tomcat server");
	}

}
