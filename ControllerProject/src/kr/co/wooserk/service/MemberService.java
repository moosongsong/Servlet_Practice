package kr.co.wooserk.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberService implements ServiceController
{
	public String doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String type = request.getParameter("type");
		
		switch(type)
		{
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
	
	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*
		 * response.setContentType("text/html; charset=utf-8");
		 * response.getWriter().println("회원가입 서비스가 요청되었습니다.");
		 */
		
		return "register_ok.html";
	}
	
	private String entire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		return "entire_ok.html";
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		return "login_ok.html";
	}
}
