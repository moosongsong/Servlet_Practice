package kr.co.moosong;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.moosong.dao.MemberDao;
import kr.co.moosong.model.Member;

@WebServlet("/apply")
public class applyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		request.setCharacterEncoding("utf-8");
    		response.setContentType("text/html; charset=utf-8");
    		PrintWriter out = response.getWriter();
    		
    		String email = request.getParameter("email");
    		String nick = request.getParameter("nick");
    		String pass = request.getParameter("pass");
    		
    		MemberDao memberDao = new MemberDao();
    		Member member = new Member(email, nick, pass, null, null);
    		;
    		
    		if (memberDao.insert(member) == false) {
    			out.println("회원가입에 실패하였습니다.");
    		} else {
    			out.println("회원가입에 성공하였습니다.");
    		}
	}

}
