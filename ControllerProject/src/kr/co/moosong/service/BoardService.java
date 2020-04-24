package kr.co.moosong.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardService implements ServiceController {// 여기서 멤버 DAO를 사용하면 된다.
	
	@Override
	public String doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().println("보드서비스");
		return "board.html";	
	}
	
}
