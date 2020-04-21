package kr.co.powerlinux;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterMember() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		final String url = "jdbc:mariadb://localhost:3306/servlet";
		final String user = "servlet";
		final String password = "1234";
		
		try {
			out = response.getWriter();

			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("jdbc is here!!");
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection is completed!!");
			
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String nick = request.getParameter("nick");
			
			if (email.trim().equals("")) {
				throw new Exception("이름 없음");
			}
			
			if (pass.trim().equals("")) {
				throw new Exception("비번 없음");
			}
			
			if (nick.trim().equals("")) {
				throw new Exception("별명 없음");
			}

			String sql = "Insert into members(email, pass, nick) values (?,  password(?),?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			pstmt.setString(3, nick);
			
			if (pstmt.executeUpdate()==0) {
				throw new Exception("회원가입 실패");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.println("error");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("데이타베이스 서버 오류가 발생하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			out.println(e.getMessage());
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
