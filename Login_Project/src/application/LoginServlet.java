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
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");

		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		// 이메일과 비밀번호 파라미터를 이용하여 멤버스 테이블로부터 회원정보를 확인하고
		// 계정이 존재하지 ㅇ낳으면 계정이 존재하지 않습니다, 메시지를 반환하고
		// 계정은 존재하지만 비밀번혹 일치하지 않을 경우 비밀번호가 일치하지 않습니다.
		// 메시지를 변환하고 계정도 일치하고 비밀번호도 일치하다면 정상적으로 로그인 처리가 완료되었습니다.
		// 메시지를 반환
		// 정상적으로 로그인 되었다면 세션변수를 설벙한다.
		// 사용자 계정을 "이메일" 이라는 식별자로 세션에 저장한다.
		Connection con = null;
		Statement stmt1 = null;
		Statement stmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		final String url = "jdbc:mariadb://localhost:3306/servlet";
		final String user = "servlet";
		final String password = "1234";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection is completed!!");

			String sql = "Select * from members where email='" + (email) + "';";

			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery(sql);

			if (rs1.next()) {

				String sql2 = "Select * from members where email='" + (email) + "' and password('" + pass + "');";
				stmt2 = con.createStatement();
				rs2 = stmt2.executeQuery(sql2);
				if (rs2.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					out.println("{errno:0, message:'로그인이 정상적으로됨'}");
				} else {
					out.println("{errno:1, message:'비밀번호가 일치하지 않습니다.'}");
				}
			} else {
				out.println("{errno:2, message:'계정이 존재하지 않습니다.'}");
			}

		} catch (ClassNotFoundException e) {
			out.println("{errno:3, message:'드라이버 없음'}");
		} catch (SQLException e) {
			out.println("{errno:4, message:'sql error'}");
		} catch (Exception e) {
			out.println("{errno:5, message:'excep'}");
		} finally {
			try {
				rs2.close();
			} catch (Exception e1) {

			}
			try {
				rs1.close();
			} catch (Exception e1) {

			}
			try {
				stmt2.close();
			} catch (Exception e) {

			}
			try {
				stmt1.close();
			} catch (Exception e) {
			}

			try {
				con.close();
			} catch (Exception e) {

			}

		}
	}

}
