package kr.co.moosong.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberService implements ServiceController {

	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("회원서비스");
		
		String type = request.getParameter("type");
		switch (type) {
		case "register":
			return register(request, response);
		case "entire":
			return entire(request, response);
		case "login":
			return login(request, response);
		default:
			return "member_result.html";
		}
	}

	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().println("회원가입 서비스가 요청되었습니다.");
		return "register.html";
	}
	
	private String entire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().println("회원탈퇴 서비스가 요청되었습니다.");
		return "entire.html";
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().println("회원로그인 서비스가 요청되었습니다.");
		return "login.html";
	}


}
