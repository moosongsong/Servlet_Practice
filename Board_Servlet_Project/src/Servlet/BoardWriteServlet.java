package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Common.ConnectionManager;

@WebServlet("/writeBoard")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected String setNumber(String key, Number value) {
		return (key +":"+value);
	}
	
	protected String setString(String key, String value) {
		return (key +":'"+value+"'");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		if (session == null) {//키검색
			StringBuffer sb = new StringBuffer();
			sb.append("{")
				.append(setNumber("errno",9))
				.append(",")
				.append(setString("message", "로그인을 해주세요"))
				.append("}");
			out.println(sb);
			return;
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement("Insert into boards values(DEFAULT, ?,?,?, DEFAULT, DEFAULT, DEFAULT, DEFAULT)");
			pstmt.setString(1, (String) session.getAttribute("email"));
			pstmt.setString(2, request.getParameter("title"));
			pstmt.setString(3, request.getParameter("content"));
			
			pstmt.executeUpdate();
			out.println("{errno:0, message:'자료등록이 정상적으로 처리 되었습니다.'}");
		} catch (SQLException e) {
			out.println("{errno:1, message:'자료 등록에 실해하였습니다.'}");
			System.err.println(e.getMessage());
		} finally {
			ConnectionManager.close(pstmt);
		}
		
		
	}

}
