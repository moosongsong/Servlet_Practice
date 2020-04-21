package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkEmail")
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=utf-8"); 
		PrintWriter out = null;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String email = request.getParameter("email");
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/servlet", "servlet", "1234");
			
			out = response.getWriter();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from members where email='"+email+"'");
			
			if(rs.next()) {
				out.println("{error:1, message:'이미 등록되었음'}");
			}
			else {
				out.println("{error:0, message:'사용가능한 전자메일 주소입니다.'}");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.println("{error:2, message:'JDBC가 없졍'}");
		} catch (SQLException e) {
			out.println("{error:3, message:'DB 오류가 발생'}");
			e.printStackTrace();
		} catch (Exception e) {
			out.println("{error:3, message:'예상하지 못한 오류가 발생'}");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
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
