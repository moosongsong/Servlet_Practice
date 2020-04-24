package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mariadb.jdbc.Driver;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			response.getWriter().println("드라이버 검색 성공");
		} catch (ClassNotFoundException e) {
			response.getWriter().println("드라이버 검색 실패");
		}
	}

}
