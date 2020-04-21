package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		Connection con =null;
		PreparedStatement pstmt = null;
		
		final String url = "jdbc:mariadb://localhost:3306/servlet";
		final String user = "servlet";
		final String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection is completed!!");
			
			String sql = "Insert into members(email, pass, nick) values (?,  password(?),?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("email"));
			pstmt.setString(2, request.getParameter("pass"));
			pstmt.setString(3, request.getParameter("nick"));
			
			if(pstmt.executeUpdate()==0) {
				throw new Exception("오류 발생");
			}
			RequestDispatcher disp = request.getRequestDispatcher("/success.html");
			disp.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			RequestDispatcher disp = request.getRequestDispatcher("/Driver_exam.html");
			disp.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher disp = request.getRequestDispatcher("/sql_exam.html");
			disp.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher disp = request.getRequestDispatcher("/error.html");
			disp.forward(request, response);
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
