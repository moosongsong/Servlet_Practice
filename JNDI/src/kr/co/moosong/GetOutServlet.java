package kr.co.moosong;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.moosong.dao.MemberDao;
import kr.co.moosong.model.Member;

@WebServlet("/getOut")
public class GetOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDao memberDao = new MemberDao();

		
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("member"));
		if(session.getAttribute("member")!=null) {
			if (memberDao.delete((Member) session.getAttribute("member")) == false) {
				out.println("회원탈퇴에 실패하였습니다.");
			} else {
				out.println("회원탈퇴에 성공하였습니다.");
			}
		}else {
			out.println("비로그인 상태입니다.");
		}
		
		
		
		
		
		;
		
		
	}

}
