package kr.co.wooserk.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardService implements ServiceController
{
	public String doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().println("게시판 서비스");
		
		return "board_result.html";
	}
}
