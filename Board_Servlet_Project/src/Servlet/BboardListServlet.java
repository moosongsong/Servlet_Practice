package Servlet;

import java.io.IOException;
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

@WebServlet("/boardList")
public class BboardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		final String url = "jdbc:mariadb://localhost:3306/servlet";
		final String user = "servlet";
		final String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection is completed!!");
			
			String sql = "Select * from boards;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			StringBuffer sb = new StringBuffer();
			boolean comma = false;
			sb.append("[");
			while(rs.next()) {
				if (!comma) {
					comma = !comma;
				}else {
					sb.append(",");
				}
				sb.append("{ id:"+rs.getInt("id")+
						", title:'"+rs.getString("title")+
						"', regdate:'"+rs.getString("regdate")+	
						"', good:"+rs.getInt("good")+
						", bad:"+rs.getInt("bad")+
						"}");
			}
			sb.append("]");
			
			response.getWriter().print(sb);
			
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			
		} finally {
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
