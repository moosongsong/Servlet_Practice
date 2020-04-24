package kr.co.moosong;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.moosong.dao.MemberDao;
import kr.co.moosong.model.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.search(email, pass);
		
		if (member == null) {
			out.println("존재하지 않는 이메일이거나 비밀번호가 일치하지 않습니다.");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			RequestDispatcher disp = request.getRequestDispatcher("/loginAfter");
			disp.forward(request, response);
		}
	}

}
