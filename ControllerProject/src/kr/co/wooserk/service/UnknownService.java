package kr.co.wooserk.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnknownService implements ServiceController
{

	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().println("�� �� ���� ���� ��û�Դϴ�.");
		
		return "unknown_result.html";
	}
	
}