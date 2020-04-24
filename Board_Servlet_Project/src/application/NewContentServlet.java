package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newContent")
public class NewContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=utf-8"); 
		PrintWriter out = null;
		
		final String url = "jdbc:mariadb://localhost:3306/servlet";
		final String user = "servlet";
		final String password = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String pass = request.getParameter("password");
		String content = request.getParameter("content");
	
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("jdbc is here!!");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection is completed!!");

			out = response.getWriter();
			
			String sql = "Insert into boards(title, writer, pass, content) values (?, ?, password(?),?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, pass);
			pstmt.setString(4, content);
			
			
			if(pstmt.executeUpdate()==0) {
				throw new Exception("오류 발생");
			}
			out.println("{error:0, message:'성공'}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.println("{error:1, message:'JDBC가 없졍'}");
		} catch (SQLException e) {
			out.println("{error:2, message:'DB 오류가 발생'}");
			e.printStackTrace();
		} catch (Exception e) {
			out.println("{error:3, message:'예상하지 못한 오류가 발생'}");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
